package com.ucb.tdd.test;

import java.util.Random;

public class Persona {
    
    Random r = new Random();  
    private int perPisoInicio;
    private int perPisoDestino;

    private final int pisoMax = 3;
    private final int pisoMin = 1;

    public Persona(int perPisoInicio, int perPisoDestino) {
        this.perPisoInicio = perPisoInicio;
        this.perPisoDestino = perPisoDestino;
    }


    public Persona(int perPisoInicio) throws Exception{
        this.perPisoInicio = perPisoInicio;

        int pisoDestino = perPisoInicio;
        if(pisoDestino > pisoMax || pisoDestino < pisoMin){
            throw new Exception(" No existen esos pisos en el edificio");
        }

        while(pisoDestino == perPisoInicio){
            pisoDestino = r.nextInt(pisoMax - pisoMin + 1) + 1;
            System.out.println("El piso destino es: "+ pisoDestino);
        }
        
        this.perPisoDestino = pisoDestino;
    }


    public void llamarAscensor(Ascensor ascensor) throws Exception{
        System.out.println("Persona esta en el piso: "+ perPisoInicio + " -> Se dirige al piso: " + perPisoDestino);
        ascensor.tomarAscensor(perPisoInicio, perPisoDestino);
        
    }



// Getters y setters 

    public int getPerPisoInicio() {
        return perPisoInicio;
    }

    public void setPerPisoInicio(int perPisoInicio) {
        this.perPisoInicio = perPisoInicio;
    }

    public int getPerPisoDestino() {
        return perPisoDestino;
    }

    public void setPerPisoDestino(int perPisoDestino) {
        this.perPisoDestino = perPisoDestino;
    }
    
}