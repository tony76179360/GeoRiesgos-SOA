/**
 * "API REST Interna" de la Figura 1 del informe.
 *
 * <p>Regla de dependencia: nunca llama a un adaptador directamente, siempre pasa por
 * {@code orchestration}. Si un controller importa {@code IgpAdapter}, se saltó el orquestador.
 *
 * <p>Las respuestas públicas viven en {@code api.dto}.
 */
package com.georiesgos.soa.api;
