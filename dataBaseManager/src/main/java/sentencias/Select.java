package sentencias;

import sentencias.clasePadre.Sentencia;

import java.io.FileNotFoundException;

public class Select extends Sentencia {

    public Select (String[] consultaSeparada) {
        super(consultaSeparada);
    }

    public void comprobarSintaxis() throws FileNotFoundException {
        //Se comprueba la sintaxis del select
    }

    public void accionSentencia() {
        //Se realiza la impresion solicitda por el usuario
    }
}
