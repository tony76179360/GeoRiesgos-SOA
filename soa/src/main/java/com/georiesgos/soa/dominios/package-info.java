/**
 * Entidades JPA y repositorios. Es el centro del sistema.
 *
 * <p>Regla de dependencia: no importa nada de {@code adapter} ni de {@code api}.
 * Si una entidad tiene un campo llamado {@code attributes} u {@code OBJECTID}, la capa
 * de adaptadores no está cumpliendo su función.
 */
package com.georiesgos.soa.dominios;
