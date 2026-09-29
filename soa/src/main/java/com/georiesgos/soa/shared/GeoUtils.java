package com.georiesgos.soa.shared;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.geom.PrecisionModel;

/**
 * Convención única de coordenadas del proyecto.
 *
 * <p><b>Toda</b> geometría JTS que se persista o se compare usa {@code x = longitud},
 * {@code y = latitud} (el orden habitual de GeoJSON y de los MapServer del Estado).
 * Se verificó contra MySQL 8.4: Hibernate escribe el WKB tal cual y MySQL lo lee con
 * esa misma convención para el SRID 4326, de modo que un polígono cargado desde el INEI
 * no necesita ningún volteo de ejes.
 *
 * <p>Ojo con el WKT: {@code ST_AsText} sobre una columna 4326 imprime
 * <i>latitud primero</i> (es el orden de eje que declara el SRS). No es un error del
 * dato; es la salida de la función. Por eso las consultas nativas construyen el punto
 * con {@code ST_SRID(POINT(longitud, latitud), 4326)} y no con WKT, para no depender
 * de ese orden invertido.
 *
 * <p>MySQL no implementa {@code ST_Centroid} sobre SRS geográficos: por eso
 * {@code Distrito} guarda el centroide en dos columnas decimales propias.
 */
public final class GeoUtils {

    /** WGS 84, el SRID en que publican INEI, IGP y SENAMHI. */
    public static final int SRID_WGS84 = 4326;

    private static final GeometryFactory FACTORY =
            new GeometryFactory(new PrecisionModel(), SRID_WGS84);

    private GeoUtils() {
    }

    /** Fábrica compartida, ya configurada con el SRID 4326. */
    public static GeometryFactory factory() {
        return FACTORY;
    }

    /** Construye un punto respetando la convención (x = longitud, y = latitud). */
    public static Point punto(double latitud, double longitud) {
        return FACTORY.createPoint(new Coordinate(longitud, latitud));
    }

    /**
     * Normaliza a {@code MultiPolygon}, que es como {@code Distrito.geometria} guarda el
     * límite distrital.
     *
     * <p>El INEI devuelve {@code Polygon} para la mayoría de distritos y
     * {@code MultiPolygon} para los discontinuos o con islas. Los adaptadores pasan por
     * aquí para no tener que distinguir el caso.
     *
     * @throws IllegalArgumentException si la geometría no es un polígono ni un multipolígono
     */
    public static MultiPolygon aMultiPolygon(Geometry geometria) {
        return switch (geometria) {
            case MultiPolygon multi -> multi;
            case Polygon poligono -> FACTORY.createMultiPolygon(new Polygon[] { poligono });
            default -> throw new IllegalArgumentException(
                    "Se esperaba Polygon o MultiPolygon y llegó " + geometria.getGeometryType());
        };
    }

}
