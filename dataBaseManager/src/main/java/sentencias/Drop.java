package sentencias;

import sentencias.clasePadre.Sentencia;

import java.io.FileNotFoundException;

public class Drop extends Sentencia {

    public Drop (String[] consultaSeparada) {
        super(consultaSeparada);
    }

    public void comprobarSintaxis() throws FileNotFoundException {
        System.out.println("Comprobar Sintaxis");
    }
}
