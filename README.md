# M05-0487-EndTerm-grupo10

Práctica EndTerm del módulo M05-0487 (Entornos de Desarrollo) - Grupo 10.

---

## Ejercicio 1: Desarrollo de un Vehículo

### Descripción

Este proyecto implementa una clase `Vehiculo` siguiendo la metodología **Test Driven Development (TDD)** con JUnit 5, gestionado con Maven.

---

### Requisitos funcionales de la clase `Vehiculo`

#### Atributos

| Atributo | Tipo | Descripción |
|---|---|---|
| `marca` | `String` | Marca del vehículo (p.ej. "Toyota") |
| `modelo` | `String` | Modelo del vehículo (p.ej. "Corolla") |
| `velocidadActual` | `int` | Velocidad actual en km/h (no puede ser negativa) |
| `velocidadMaxima` | `int` | Velocidad máxima en km/h (debe ser > 0) |

#### Métodos

##### `acelerar(int incremento)`
- Si el incremento es positivo, aumenta `velocidadActual`.
- No puede superar `velocidadMaxima`.
- Si el incremento es negativo o cero, no hace nada.

##### `frenar(int decremento)`
- Si el decremento es positivo, reduce `velocidadActual`.
- No puede bajar de 0 (velocidad mínima).
- Si el decremento es negativo o cero, no hace nada.

---

### Casos de test (JUnit 5)

#### Constructor
- Constructor válido crea el objeto correctamente.
- Velocidad máxima 0 lanza excepción.
- Velocidad máxima negativa lanza excepción.

#### acelerar
- Incremento positivo aumenta la velocidad.
- No supera la velocidad máxima.
- Exactamente igual a la velocidad máxima es válido.
- Incremento cero no cambia la velocidad.
- Incremento negativo no cambia la velocidad.

#### frenar
- Decremento positivo reduce la velocidad.
- No baja de cero.
- Desde cero no cambia nada.
- Decremento negativo no cambia la velocidad.
- Decremento cero no cambia la velocidad.

---

### Estructura del proyecto

```
M05-0487-EndTerm-grupo10/
├── .github/
│   └── workflows/
│       └── maven.yml        # CI con GitHub Actions
├── src/
│   ├── main/java/
│   │   └── Vehiculo.java    # Implementación de la clase
│   └── test/java/
│       └── VehiculoTest.java # Tests JUnit 5
├── .gitignore
├── pom.xml
└── README.md
```

---

### Cómo ejecutar los tests

```bash
mvn test
```

---

### Integrantes del grupo

- igarciacastro
- pribasp
- sfrancasdam
