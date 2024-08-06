package sentencias;
import excepciones.ExistentComponentException;
import excepciones.InvalidSentenceException;
import sentencias.clasePadre.Sentencia;

import java.io.File;

public class CreateTable extends Sentencia {
    String datosDeTabla = "";

    public CreateTable(String[] consultaSeparada, File ruta) {
        super(consultaSeparada, ruta);
    }

    public void comprobarSintaxis() {
        File[] tablas = ruta.listFiles();

        if (!consultaSeparada[1].equalsIgnoreCase("TABLE")) {
            throw new InvalidSentenceException();
        }

        for (File tabla : tablas) {
            if (tabla.getName().equalsIgnoreCase(consultaSeparada[2].concat(".csv"))) {
                throw new ExistentComponentException();
            }
        }

        for (int i=3; i<consultaSeparada.length; i++) {
            datosDeTabla = datosDeTabla.concat(consultaSeparada[i] + " ");
        }

        String[] separacionPorParentesis = datosDeTabla.split(",");

        if (!(separacionPorParentesis[0].startsWith("(") &&
              separacionPorParentesis[separacionPorParentesis.length-1].trim().endsWith(")"))) {
            throw new InvalidSentenceException();
        }

        for (int i=0; i<separacionPorParentesis.length; i++) {
            //En esta seccion se debe comprobar la sintaxis de cada una de las columnas de la tabla (?)
        }
    }

    public void accionSentencia() {
        //Se crea la tabla en formato csv
    }
}
