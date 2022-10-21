package com.ucb.tdd.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class AscensorTest {
    
    private Ascensor ascensor;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Before
    public void before(){
        ascensor = new Ascensor();
    }

    @Test
    public void verificarPuertasCerradasYPisoInicio() throws Exception{
        // 1. Preparación de la prueba
        System.out.println("------------------------------- "+ascensor);

        // 2. Lógica de la prueba.
        boolean estadoInicial = ascensor.verificarEstadoInicial();

        // 3. Verificación o Assert
        assertEquals(true, estadoInicial);
    }

    @Test
    public void verificarPuertaCerrada() throws Exception{
        // 1. Preparación de la prueba
        System.out.println("------------------------------- "+ascensor);
        Persona persona = ascensor.crearPersona();

        // 2. Lógica de la prueba
        persona.llamarAscensor(ascensor);
        
        // 3. Verificación o Assert
        assertEquals(false, ascensor.getPuerta());
    }
    
    @Test
    public void crearPersonaEnPisoYDestino() throws Exception{
        // 1. Preparación de la prueba
        System.out.println("------------------------------- "+ascensor);

        // 2. Lógica de la prueba
        Persona persona = ascensor.crearPersona();

        // 3. Verificación o Assert
        assertNotNull(persona);
    }

    @Test
    public void verificarCantidadPersonasException() throws Exception{
        // 1. Preparación de la prueba
        System.out.println("------------------------------- "+ascensor);

        // 2. Lógica de la prueba
    
        // 3. Verificación o Assert
        ascensor.crearCantidadPersonas(1);
    }

    @Test
    public void verificarEstadoMovimientoAscensor() throws Exception{
        // 1. Preparación de la prueba
        System.out.println("------------------------------- "+ascensor);

        // 2. Lógica de la prueba
        boolean estadoSubidaBajada = ascensor.movAscensor();

        // 3. Verificación o Assert
        assertEquals(false, estadoSubidaBajada);
    }

    @Test
    public void verificarPisoInicioYPisoDestino() throws Exception{
        // 1. Preparación de la prueba
        System.out.println("------------------------------- "+ascensor);

        // 2. Lógica de la prueba
        Persona persona = ascensor.crearPersona();

        // 3. Verificación o Assert
        assertNotSame(persona.getPerPisoInicio(), persona.getPerPisoDestino());
    }

    @Test
    public void verificarPisoDestinoPersonaAscensor() throws Exception{
        // 1. Preparación de la prueba
        System.out.println("------------------------------- "+ascensor);
        Persona persona = ascensor.crearPersona();

        // 2. Lógica de la prueba
        persona.llamarAscensor(ascensor);
        
        // 3. Verificación o Assert
        assertEquals(ascensor.getPisoDestino(), persona.getPerPisoDestino());
        ascensor.setPuerta(false);
    }

    @Test
    public void verificarEstadoMovimientoYPersona() throws Exception{
        // 1. Preparación de la prueba
        System.out.println("------------------------------- "+ascensor);
        Persona persona = ascensor.crearPersona();

        // 2. Lógica de la prueba
        persona.llamarAscensor(ascensor);
        
        // 3. Verificación o Assert
        assertEquals(ascensor.getPisoActual(), persona.getPerPisoInicio());
        assertEquals(true, ascensor.getPersonaAdentro());
    }

    @Test
    public void trayectoFinalDelAscensor() throws Exception{
        // 1. Preparación de la prueba
        System.out.println("------------------------------- "+ascensor);
        Persona persona = ascensor.crearPersona();
        
        // 2. Lógica de la prueba
        persona.llamarAscensor(ascensor);

        // 3. Verificación o Assert
        ascensor.transportarPersona();
        assertEquals(ascensor.getPisoActual(), persona.getPerPisoDestino());
       
    }

    
}
