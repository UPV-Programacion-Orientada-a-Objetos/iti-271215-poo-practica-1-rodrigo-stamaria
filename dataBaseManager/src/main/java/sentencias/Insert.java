package sentencias;

import clases.ManipularCSV;
import excepciones.InexistentComponentException;
import sentencias.clasePadre.Sentencia;

import java.io.FileNotFoundException;

import excepciones.InvalidSentenceException;
import java.io.File;

public class Insert extends Sentencia {
    String columnas = "";
    String valores = "";

    public Insert (String[] consultaSeparada, File ruta) {
        super(consultaSeparada, ruta);
    }

    public void comprobarSintaxis() throws FileNotFoundException {
        File[] tablas = ruta.listFiles();
        Boolean encontrado = false;

        if (!consultaSeparada[1].equalsIgnoreCase("INTO")) {
            throw new InvalidSentenceException();
        }

        for (File tabla : tablas) {
            if (tabla.getName().equalsIgnoreCase(consultaSeparada[2].concat(".csv"))) {
                encontrado = true;
            }
        }

        if (encontrado == false || tablas == null) {
            throw new InexistentComponentException();
        }

        int numerito = 0;

        if (consultaSeparada[3].startsWith("(")) {
            for (int i=3; i<consultaSeparada.length; i++) {
                columnas = columnas.concat(consultaSeparada[i] + " ");
                if (consultaSeparada[i].endsWith(")")) {
                    numerito = i + 1;
                    break;
                }
            }
        } else {
            throw new InvalidSentenceException();
        }

        if (!(consultaSeparada[numerito].equalsIgnoreCase("VALUES"))) {
            throw new InvalidSentenceException();
        }

        numerito++;

        if (consultaSeparada[numerito].startsWith("(")) {
            for (int i=numerito; i<consultaSeparada.length; i++) {
                valores = valores.concat(consultaSeparada[i] + " ");
                if (consultaSeparada[i].endsWith(")")) {
                    break;
                }
            }
        } else {
            throw new InvalidSentenceException();
        }

        ManipularCSV.leerCSV(new File(ruta + "/" + consultaSeparada[2].toUpperCase().concat(".csv")));

        //leer la primera linea del csv y compararla con el array "columnas"
        //comparar que la misma cantidad de palabras exista en el array columnas y en el array valores
        //insertar el array valores en una nueva linea en el archivo csv

        String linesita = ManipularCSV.leerPrimeraLinea(new File(ruta + "/" + consultaSeparada[2].toUpperCase().concat(".csv")));
        System.out.println(columnas);
        System.out.println(valores);
        System.out.println(linesita);
    }

    public void accionSentencia() {
        //Se modifica el archivo CSV para que se inserte una nueva linea
    }
}
