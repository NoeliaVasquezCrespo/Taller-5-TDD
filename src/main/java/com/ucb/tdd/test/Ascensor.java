package com.ucb.tdd.test;
import java.util.Random;

public class Ascensor {

    Random r = new Random(); //Para numeros random 
    private int pisoActual = 1; //piso inicial del ascensor
    private boolean puerta = false; //Validación puerta: cerrada = false -> abierta = true
    private boolean movAscensor = false; //Movimiento ascensor: subida = true -> bajada = false
    private int pisoDestino; //Piso destino de la persona
    private boolean personaAdentro = false; //Persona se encuentra en el ascensor: fuera = false -> dentro = true
    private int cantidadPersonas; //Cantidad de personas que quieren ingresar al ascensor
    private final int pisoMin = 1; //Piso inferior del edificio
    private final int pisoMax = 3; //Piso superior del edificio


    public boolean verificarEstadoInicial(){
        if(pisoActual == 1 && puerta == false){
            System.out.println("Puerta cerrada -> Abrir");
            return true;
        }
        System.out.println("Puerta Abierta -> Cerrar");
        return false;
    }

    public boolean movAscensor(){
        return movAscensor;
    }

    public Persona crearPersona() throws Exception{ 
        int piso = r.nextInt(pisoMax - pisoMin + 1) + 1;
        System.out.println("El piso en el que se encuentra es: " + piso);
        return new Persona(piso);
    }

    public void crearCantidadPersonas(int cantidadPersonas) throws Exception{
      //  cantidadPersonas = r.nextInt(5-1+1)+ 1;
        System.out.println("Cantidad de personas en el piso " + cantidadPersonas);
        validarCantidad(cantidadPersonas);
        
    }

    public void validarCantidad(int cantidad) throws Exception{
        if( cantidad > 1 ) {
            throw new Exception("La capacidad del ascensor fue superada");
        }  
    }

    public void tomarAscensor(int personaPisoActual, int personaPisoDestino) throws Exception{
        
        if(personaPisoActual != pisoActual){
            pisoActual = personaPisoActual;
            System.out.println("Ascensor en el piso " + pisoActual);
        } 
        if(personaPisoActual == pisoActual){
            setPisoDestino(personaPisoDestino);
            setPuerta(true);
            System.out.println("Abriendo puertas");
            setPersonaAdentro(true);
            System.out.println("La persona ingresa al ascensor");
            setPuerta(false);
            System.out.println("Cerrando puertas");
        }
    }

    public void transportarPersona() throws Exception{
        if (puerta){
            setPuerta(false);
        }
        if(puerta){
            throw new Exception("Puerta no está cerrada");
        }
        pisoActual = pisoDestino;
        System.out.println("Abriendo puertas para que salga la persona");
        setPuerta(true);
        System.out.println("No hay persona en el ascensor");
        setPersonaAdentro(false);
        System.out.println("Se cierra la puerta");
        setPuerta(false);
    }

    





// Getters y setters
    
    public int getPisoActual() {
        return pisoActual;
    }

    public void setPisoActual(int pisoActual) {
        this.pisoActual = pisoActual;
    }

    public boolean getPuerta() {
        return puerta;
    }

    public void setPuerta(boolean puerta) {
        this.puerta = puerta;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }

    public void setPisoDestino(int pisoDestino) {
        this.pisoDestino = pisoDestino;
    }

    public boolean getPersonaAdentro() {
        return personaAdentro;
    }

    public void setPersonaAdentro(boolean personaAdentro) {
        this.personaAdentro = personaAdentro;
    }

}

