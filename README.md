# TodoAutos SPA - Enterprise Microservices Platform

Este repositorio contiene el ecosistema completo de backend para **TodoAutos SPA**, diseñado bajo una arquitectura de sistemas distribuidos altamente escalable, tolerante a fallos y basada en microservicios.

## Mapa de la Arquitectura

El sistema está planificado para integrarse por 10 microservicios especializados, centralizados bajo el siguiente flujo de infraestructura:

1. **Spring Cloud Gateway:** API Gateway encargado del enrutamiento dinámico.
2. **Spring Cloud Eureka:** Servidor de descubrimiento (Service Discovery) para gestionar la localización de cada microservicio.
3. **Seguridad Centralizada (JWT):** Filtros de autenticación y autorización mediante JSON Web Tokens.
4. **Microservicio de Usuarios y Accesos (IAM):** Gestión de usuarios, roles, permisos y lógica defensiva con MySQL.

##  Tecnologías Core
* **Lenguaje:** Java 17
* **Framework Principal:** Spring Boot 3.x
* **Ecosistema Cloud:** Spring Cloud (Netflix Eureka, Gateway)
* **Seguridad:** Spring Security & JWT
* **Base de Datos:** MySQL