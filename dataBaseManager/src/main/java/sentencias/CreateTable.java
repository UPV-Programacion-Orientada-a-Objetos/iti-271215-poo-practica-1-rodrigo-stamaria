package sentencias;
import clases.ManipularCSV;
import excepciones.ExistentComponentException;
import excepciones.InvalidSentenceException;
import sentencias.clasePadre.Sentencia;

import java.io.File;

public class CreateTable extends Sentencia {
    String datosDeTabla = "";
    String cabecera = "";

    public CreateTable(String[] consultaSeparada, File ruta) {
        super(consultaSeparada, ruta);
    }

    public void comprobarSintaxis() {
        File[] tablas = ruta.listFiles();

        if (!consultaSeparada[1].equalsIgnoreCase("TABLE")) {
            throw new InvalidSentenceException();
        }

        for (File tabla : tablas) {
            if (tabla.getName().equalsIgnoreCase(consultaSeparada[2].toUpperCase().concat(".csv"))) {
                throw new ExistentComponentException();
            }
        }

        for (int i=3; i<consultaSeparada.length; i++) {
            datosDeTabla = datosDeTabla.concat(consultaSeparada[i] + " ");
        }

        String[] arrayDatosDeTabla = datosDeTabla.split(",");

        for (int i=0; i<arrayDatosDeTabla.length; i++) {
            arrayDatosDeTabla[i] = arrayDatosDeTabla[i].trim();
        }

        if (!(arrayDatosDeTabla[0].startsWith("(") &&
                arrayDatosDeTabla[arrayDatosDeTabla.length-1].trim().endsWith(")"))) {
            throw new InvalidSentenceException();
        }

        if (arrayDatosDeTabla[0].startsWith("(")) {
            arrayDatosDeTabla[0] = arrayDatosDeTabla[0].replace("(", "").trim();
        }

        if (arrayDatosDeTabla[arrayDatosDeTabla.length-1].trim().endsWith(")")) {
            arrayDatosDeTabla[arrayDatosDeTabla.length-1] = arrayDatosDeTabla[arrayDatosDeTabla.length-1].replace(")", "");
        }

        String[] columnas = new String[arrayDatosDeTabla.length];

        for (int i=0; i<arrayDatosDeTabla.length; i++) {
            columnas[i] = arrayDatosDeTabla[i].substring(0, arrayDatosDeTabla[i].indexOf(" "));
            cabecera = cabecera.concat(columnas[i]);
            if (i<arrayDatosDeTabla.length-1) {
                cabecera = cabecera.concat(", ");
            }
        }

    }

    public void accionSentencia() {
        ManipularCSV.crearCSV(ruta.toString(), consultaSeparada[2], cabecera);
    }
}
