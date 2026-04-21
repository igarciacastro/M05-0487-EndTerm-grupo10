# M05-0487-EndTerm-grupo10

Pràctica EndTerm del mòdul M05-0487 (Entorns de Desenvolupament) - Grup 10.

---

## Exercici 1: Desenvolupament d'un Vehicle

### Descripció

Aquest projecte implementa una classe `Vehiculo` seguint la metodologia **Test Driven Development (TDD)** amb JUnit 5, gestionat amb Maven.

---

### Requisits funcionals de la classe `Vehiculo`

#### Atributs

| Atribut | Tipus | Descripció |
|---|---|---|
| `marca` | `String` | Marca del vehicle (p.ex. "Toyota") |
| `modelo` | `String` | Model del vehicle (p.ex. "Corolla") |
| `velocidadActual` | `int` | Velocitat actual en km/h (no pot ser negativa) |
| `velocidadMaxima` | `int` | Velocitat màxima en km/h (ha de ser > 0) |

#### Mètodes

##### `acelerar(int incremento)`
- Incrementa `velocidadActual` en el valor d'`incremento`.
- Si `velocidadActual + incremento > velocidadMaxima`, llavors `velocidadActual = velocidadMaxima`.
- Si `incremento <= 0`, no fa res (s'ignora).

##### `frenar(int decremento)`
- Decrementa `velocidadActual` en el valor de `decremento`.
- Si `velocidadActual - decremento < 0`, llavors `velocidadActual = 0`.
- Si `decremento <= 0`, no fa res (s'ignora).

#### Validacions al constructor
- `velocidadMaxima` ha de ser > 0. Si no, es llança `IllegalArgumentException`.
- `velocidadActual` inicial sempre és 0.

---

### Casos de test previstos

#### `acelerar`
- [ ] Accelerar amb valor positiu incrementa la velocitat.
- [ ] Accelerar no supera la velocitat màxima.
- [ ] Accelerar exactament fins a la velocitat màxima.
- [ ] Accelerar amb valor 0 no canvia la velocitat.
- [ ] Accelerar amb valor negatiu no canvia la velocitat.

#### `frenar`
- [ ] Frenar amb valor positiu decrementa la velocitat.
- [ ] Frenar no baixa de 0 km/h.
- [ ] Frenar des de 0 continua a 0.
- [ ] Frenar amb valor 0 no canvia la velocitat.
- [ ] Frenar amb valor negatiu no canvia la velocitat.

#### Constructor
- [ ] Crear vehicle amb velocitat màxima vàlida.
- [ ] Crear vehicle amb velocitat màxima 0 llança `IllegalArgumentException`.
- [ ] Crear vehicle amb velocitat màxima negativa llança `IllegalArgumentException`.

---

### Estructura del projecte

```
src/
  main/java/com/grupo10/vehiculo/
    Vehiculo.java
  test/java/com/grupo10/vehiculo/
    VehiculoTest.java
pom.xml
README.md
```

---

### Com executar els tests

```bash
mvn test
```

---

### Flux de treball (GitFlow simplificat)

- Cada funcionalitat es desenvolupa en una branca `feature/<nom>`.
- Es fa PR a `main` i cal almenys 1 revisió aprovada abans de fer merge.
- GitHub Actions executa els tests automàticament en cada PR.
