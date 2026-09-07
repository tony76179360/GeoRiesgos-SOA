# Sistema Web para el Monitoreo y Análisis de Riesgos Naturales en el Perú

Proyecto académico del curso Arquitectura Orientada a Servicios.

## Descripción

El proyecto propone el diseño de una plataforma web basada en Arquitectura Orientada a Servicios (SOA), destinada a integrar información pública relacionada con eventos sísmicos, datos meteorológicos e información demográfica del Perú.

La propuesta considera el consumo de servicios del Instituto Geofísico del Perú (IGP), el Servicio Nacional de Meteorología e Hidrología del Perú (SENAMHI) y el Instituto Nacional de Estadística e Informática (INEI).

## Problema identificado

La información sísmica, meteorológica y demográfica se encuentra publicada en plataformas independientes. Esto obliga a los usuarios a consultar diferentes fuentes para obtener información relacionada con una misma zona geográfica.

El proyecto plantea centralizar la consulta y presentación de estos datos mediante una aplicación web.

## Objetivo general

Diseñar una plataforma web basada en SOA que permita integrar y presentar información del IGP, SENAMHI e INEI mediante un dashboard interactivo.

## Fuentes de información consideradas

### Instituto Geofísico del Perú

Se considera el servicio geoespacial “Último Sismo”, publicado mediante ArcGIS REST.

- Entidad: Instituto Geofísico del Perú
- Información: eventos sísmicos
- Formatos considerados: JSON y GeoJSON
- Sitio oficial: https://www.igp.gob.pe/servicios/infraestructura-de-datos-espaciales/componentes/webservice

### SENAMHI

Se consideran los geoservicios relacionados con información de precipitación publicados mediante WFS.

- Entidad: Servicio Nacional de Meteorología e Hidrología del Perú
- Información: datos geográficos de precipitación
- Estándar considerado: OGC WFS
- Sitio oficial: https://idesep.senamhi.gob.pe/portalidesep/idesep_componente_catalogo_geoservicios_wfs.jsp

### INEI

Se consideran los servicios geoespaciales de límites político-administrativos e información poblacional.

- Entidad: Instituto Nacional de Estadística e Informática
- Información: límites territoriales y población
- Estándares considerados: WMS y WFS
- Sitio oficial: https://ide.inei.gob.pe/

## Arquitectura preliminar

La arquitectura propuesta contempla los siguientes componentes:

- Aplicación web o dashboard
- Backend con API REST
- Servicio de integración u orquestación
- Adaptador para el IGP
- Adaptador para SENAMHI
- Adaptador para el INEI
- Mecanismo de almacenamiento temporal o caché
- Servicios externos de las entidades públicas

El diseño es preliminar y podrá ajustarse después de verificar las características y limitaciones de cada servicio externo.

## Tecnologías propuestas

- Frontend: HTML, CSS y JavaScript
- Backend: Java
- Framework: Spring Boot
- API interna: REST
- Formato interno: JSON
- Comunicación: HTTP/HTTPS
- Arquitectura: Arquitectura Orientada a Servicios

Estas tecnologías forman parte de la propuesta inicial y podrían ajustarse durante el diseño e implementación.

## Estado del proyecto

Actualmente, el proyecto se encuentra en la etapa de propuesta y documentación correspondiente al primer avance.

### Actividades actuales

- [x] Definición inicial del problema
- [x] Selección preliminar de entidades públicas
- [x] Definición de objetivos
- [x] Elaboración del esquema preliminar
- [x] Elaboración de fichas técnicas preliminares
- [ ] Validación definitiva de servicios y capas
- [ ] Diseño completo de la arquitectura
- [ ] Implementación del backend
- [ ] Implementación del frontend
- [ ] Integración de servicios externos
- [ ] Pruebas
- [ ] Prototipo funcional

## Integrantes

- Antony Frank Encalada Perez
- Jannely Rosario Rodriguez Nolasco
- Marco Antonio Barrios Delgado
- Castañeda Inocencio Rosalía Hillary 
- [Nombre del quinto integrante]

## Docente

Elmer Ely Medina Rodriguez

## Curso

Arquitectura Orientada a Servicios

## Uso académico

Este repositorio contiene los avances documentales y, posteriormente, el código fuente desarrollado por el equipo para el proyecto del curso.

La información presentada por la futura aplicación tendrá carácter informativo y no reemplazará los avisos o comunicados oficiales emitidos por las instituciones públicas.
