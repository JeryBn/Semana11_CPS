# Spring Boot : Application PetClinic

## Features  

### 1.  Unit Test  --> Tag v1.0.0

mvn test -Dspring.profiles.active=h2
## Grupo 3 - Integrante A

Jery Becerra: pruebas de creacion, actualizacion y busqueda por ID de especialidades.

- `SpecialtyServiceTest`: pruebas unitarias con JUnit 5 y Mockito.
- `SpecialtyServiceDatabaseTest`: las mismas operaciones con la base de datos H2 del proyecto. Cada prueba revierte sus cambios.

En Windows, desde la carpeta del proyecto:

```powershell
.\mvnw.cmd "-Dtest=SpecialtyServiceTest,SpecialtyServiceDatabaseTest" test
.\mvnw.cmd test
```

La revision, integracion y documentacion de conflictos corresponden al trabajo del equipo.
