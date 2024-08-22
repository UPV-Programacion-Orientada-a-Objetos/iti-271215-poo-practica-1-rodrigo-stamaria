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

        if (!encontrado || tablas == null) {
            throw new InexistentComponentException();
        }

        int numerito = 0;

        if (consultaSeparada[3].startsWith("(")) {
            for (int i = 3; i < consultaSeparada.length; i++) {
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
            for (int i = numerito; i < consultaSeparada.length; i++) {
                valores = valores.concat(consultaSeparada[i] + " ");
                if (consultaSeparada[i].endsWith(")")) {
                    break;
                }
            }
        } else {
            throw new InvalidSentenceException();
        }

        String linesita = ManipularCSV.leerPrimeraLinea(new File(ruta + "/" + consultaSeparada[2].toUpperCase().concat(".csv")));

        columnas = columnas.replace("(", "").replace(")", "").trim();
        valores = valores.replace("(", "").replace(")", "").trim();

        if (!columnas.equals(linesita)) {
            throw new InexistentComponentException();
        }

        int contadorComasColumnas = 0;
        int contadorComasValores= 0;

        for (int i=0; i<columnas.length(); i++) {
            if (columnas.charAt(i) == ',') { contadorComasColumnas++; }
        }
        for (int i=0; i<valores.length(); i++) {
            if (valores.charAt(i) == ',') { contadorComasValores++; }
        }

        if (contadorComasColumnas != contadorComasValores) {
            throw new InvalidSentenceException();
        }

    }

    public void accionSentencia() {
        ManipularCSV.escribirNuevaLinea (ruta.toString(), consultaSeparada[2], valores);
    }
}
