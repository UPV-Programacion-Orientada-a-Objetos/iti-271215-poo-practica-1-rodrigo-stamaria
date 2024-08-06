package sentencias;

import sentencias.clasePadre.Sentencia;

import java.io.FileNotFoundException;
import java.io.File;

public class Select extends Sentencia {

    public Select (String[] consultaSeparada, File ruta) {
        super(consultaSeparada, ruta);
    }

    public void comprobarSintaxis() throws FileNotFoundException {
        //Se comprueba la sintaxis del select
    }

    public void accionSentencia() {
        //Se realiza la impresion solicitda por el usuario
    }
}
