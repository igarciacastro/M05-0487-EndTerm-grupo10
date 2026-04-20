package com.grupo10.vehiculo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de la clase Vehiculo")
class VehiculoTest {

    private Vehiculo vehiculo;

    @BeforeEach
    void setUp() {
        vehiculo = new Vehiculo("Toyota", "Corolla", 180);
    }

    // ===================== CONSTRUCTOR =====================

    @Test
    @DisplayName("Constructor: crea vehicle amb velocitat maxima valida")
    void constructor_velocidadMaximaValida_creaVehiculoCorrectamente() {
        assertEquals("Toyota", vehiculo.getMarca());
        assertEquals("Corolla", vehiculo.getModelo());
        assertEquals(180, vehiculo.getVelocidadMaxima());
        assertEquals(0, vehiculo.getVelocidadActual());
    }

    @Test
    @DisplayName("Constructor: velocitat maxima 0 llanca IllegalArgumentException")
    void constructor_velocidadMaximaCero_lanzaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
            () -> new Vehiculo("Ford", "Focus", 0));
    }

    @Test
    @DisplayName("Constructor: velocitat maxima negativa llanca IllegalArgumentException")
    void constructor_velocidadMaximaNegativa_lanzaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
            () -> new Vehiculo("Ford", "Focus", -50));
    }

    // ===================== ACELERAR =====================

    @Test
    @DisplayName("Acelerar: incrementa la velocitat correctament")
    void acelerar_conIncrementoPositivo_incrementaVelocidad() {
        vehiculo.acelerar(50);
        assertEquals(50, vehiculo.getVelocidadActual());
    }

    @Test
    @DisplayName("Acelerar: no supera la velocitat maxima")
    void acelerar_superaVelocidadMaxima_quedaEnVelocidadMaxima() {
        vehiculo.acelerar(200);
        assertEquals(180, vehiculo.getVelocidadActual());
    }

    @Test
    @DisplayName("Acelerar: exactament fins a la velocitat maxima")
    void acelerar_exactamenteVelocidadMaxima_quedaEnVelocidadMaxima() {
        vehiculo.acelerar(180);
        assertEquals(180, vehiculo.getVelocidadActual());
    }

    @Test
    @DisplayName("Acelerar: amb valor 0 no canvia la velocitat")
    void acelerar_conCero_noModificaVelocidad() {
        vehiculo.acelerar(50);
        vehiculo.acelerar(0);
        assertEquals(50, vehiculo.getVelocidadActual());
    }

    @Test
    @DisplayName("Acelerar: amb valor negatiu no canvia la velocitat")
    void acelerar_conNegativo_noModificaVelocidad() {
        vehiculo.acelerar(50);
        vehiculo.acelerar(-10);
        assertEquals(50, vehiculo.getVelocidadActual());
    }

    // ===================== FRENAR =====================

    @Test
    @DisplayName("Frenar: decrementa la velocitat correctament")
    void frenar_conDecrementoPositivo_decrementaVelocidad() {
        vehiculo.acelerar(100);
        vehiculo.frenar(30);
        assertEquals(70, vehiculo.getVelocidadActual());
    }

    @Test
    @DisplayName("Frenar: no baixa de 0 km/h")
    void frenar_superaVelocidadCero_quedaEnCero() {
        vehiculo.acelerar(50);
        vehiculo.frenar(100);
        assertEquals(0, vehiculo.getVelocidadActual());
    }

    @Test
    @DisplayName("Frenar: desde 0 continua a 0")
    void frenar_desdeCero_continuaEnCero() {
        vehiculo.frenar(50);
        assertEquals(0, vehiculo.getVelocidadActual());
    }

    @Test
    @DisplayName("Frenar: amb valor 0 no canvia la velocitat")
    void frenar_conCero_noModificaVelocidad() {
        vehiculo.acelerar(80);
        vehiculo.frenar(0);
        assertEquals(80, vehiculo.getVelocidadActual());
    }

    @Test
    @DisplayName("Frenar: amb valor negatiu no canvia la velocitat")
    void frenar_conNegativo_noModificaVelocidad() {
        vehiculo.acelerar(80);
        vehiculo.frenar(-20);
        assertEquals(80, vehiculo.getVelocidadActual());
    }
}
