/**
 * Grupo 1 del modelo de datos: la jerarquía territorial del INEI
 * ({@code Departamento} → {@code Provincia} → {@code Distrito}) y sus repositorios.
 *
 * <p>Son datos maestros: se cargan una vez y se refrescan rara vez. El {@code ubigeo} es
 * la clave natural de las tres entidades, y es lo que permite re-sincronizar con el INEI
 * sin duplicar registros.
 *
 * <p>{@code Distrito} es además el ancla geoespacial del sistema: su columna
 * {@code geometria} (SRID 4326, con SPATIAL INDEX) resuelve el point-in-polygon del
 * epicentro y el buffer por radio dentro de la base, sin traer polígonos a la aplicación.
 */
package com.georiesgos.soa.dominios.territorio;
