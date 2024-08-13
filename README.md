# Prueba tecnica Inditex

El proyecto a continuación presenta una solución al caso de consulta de precios aplicados en Inditex,
se realiza bajo lenguaje de programacion Java con el marco de trabajo SpringBoot y base de datos H2.
Adicionalmente, se complementa utilizando arquitectura hexagonal.


### Pre-requisitos 

-Maven <br>
-Lombok

### Base de datos 

Diagrama relacional de la base de datos

![Base de datos](bd.png)


### Instalación 

Generar proyecto por maven

```
mvn clean install
```

Ejecutar proyecto por maven

```
mvn spring-boot:run

```

### Consulta de precio aplicado

<bold>Endpoint para consultar precio aplicado a un producto especifico</bold>

```
GET(/api/inditex/findPriceBetweenDates/{dateSearch}/{productId}/{brandId})   

```
