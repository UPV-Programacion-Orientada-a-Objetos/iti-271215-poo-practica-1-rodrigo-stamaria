package sentencias;

import clases.ManipularCSV;
import excepciones.InexistentComponentException;
import excepciones.InvalidSentenceException;
import sentencias.clasePadre.Sentencia;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Locale;

public class Select extends Sentencia {
    Where where = new Where(consultaSeparada, ruta, "SELECT");
    String seleccion = consultaSeparada[1];

    public Select (String[] consultaSeparada, File ruta) {
        super(consultaSeparada, ruta);
    }

    public void comprobarSintaxis() throws FileNotFoundException {
        File[] tablas = ruta.listFiles();
        Boolean encontrado = false;

        if (!consultaSeparada[2].equalsIgnoreCase("FROM")) {
            throw new InvalidSentenceException();
        }

        for (File tabla : tablas) {
            if (tabla.getName().equalsIgnoreCase(consultaSeparada[3].concat(".csv"))) {
                encontrado = true;
            }
        }

        if (!encontrado || tablas == null) {
            throw new InexistentComponentException();
        }
    }

    public void accionSentencia() {
        if (consultaSeparada.length>4) {
            //Comprobar que se use la palabra whehre !!
            try {
                where.comprobarSintaxis();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                where.accionSentencia();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            if (seleccion.equalsIgnoreCase("*")) {
                File rutaDeTabla = new File(ruta + "/" + consultaSeparada[3].toUpperCase() + ".csv");
                ManipularCSV.leerCSV(rutaDeTabla);
            } else {
                //AQUI SE IMPRIME SOLO LA COLUMNA QUE SOLICITÓ EL USUARIO
            }
        }
    }
}
