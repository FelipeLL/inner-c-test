# Inner Consulting Prueba técnica

Este repositorio contiene un microservicio de gestión de productos, implementado utilizando Spring Boot y desplegado en Kubernetes. Esta aplicación incluye pruebas unitarias y está configurada para la integración continua utilizando Jenkins.

## Tabla de Contenidos

- [Características](#características)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Configuración del Proyecto](#configuración-del-proyecto)
- [Ejecutar la Aplicación](#ejecutar-la-aplicación)
- [Ejecutar Pruebas Unitarias](#ejecutar-pruebas-unitarias)
- [Despliegue en Kubernetes](#despliegue-en-kubernetes)
- [Integración Continua con Jenkins](#integración-continua-con-jenkins)

## Características

- Gestión de productos con operaciones CRUD (Crear, Leer, Actualizar, Eliminar).
- Documentación de la API utilizando Swagger.
- Pruebas unitarias implementadas con JUnit y Mockito.
- Despliegue en un clúster de Kubernetes.
- Integración continua configurada con Jenkins.

## Tecnologías Utilizadas

- **Spring Boot**: Framework para construir aplicaciones Java.
- **H2 Database**: Base de datos en memoria utilizada para la gestión de datos.
- **JUnit y Mockito**: Herramientas para pruebas unitarias.
- **Swagger**: Documentación de la API.
- **Kubernetes**: Orquestador de contenedores para el despliegue.
- **Jenkins**: Herramienta de integración continua.

## Configuración del Proyecto

1. **Clonar el Repositorio**:
   ```bash
   git clone https://github.com/FelipeLL/inner-c-test.git
   cd inner-c-test
2. **Compilar el Proyecto**:
   ```bash
   mvn clean install
3. **Ejecutar la aplicación**:
   ```bash
   mvn spring-boot:run
4. **Ejecutar pruebas unitarias**:
   ```bash
   mvn test

## Despliegue en Kubernetes
Para este paso se utilizó Minikube para el clúster de forma local
1. **Aplicar el despliegue**:
   ```bash
   kubectl apply -f deployment.yaml

## Integración Continua con Jenkins
El proyecto está configurado para integración continua utilizando Jenkins. El Jenkinsfile incluido define los pasos para la construcción y prueba de la aplicación.



