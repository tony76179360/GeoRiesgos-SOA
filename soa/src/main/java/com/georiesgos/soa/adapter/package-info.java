/**
 * "Adaptadores" de la Figura 1: absorben la heterogeneidad de formatos y protocolos.
 *
 * <p>Regla de dependencia: {@code adapter.*.dto} nunca se importa fuera de su propio
 * subpaquete. Cada adaptador expone solo objetos de {@code dominios}.
 */
package com.georiesgos.soa.adapter;
