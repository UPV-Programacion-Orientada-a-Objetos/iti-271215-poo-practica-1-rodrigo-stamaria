package sentencias;
import excepciones.ExistentComponentException;
import excepciones.InexistentComponentException;
import excepciones.InvalidSentenceException;
import sentencias.clasePadre.Sentencia;

import java.io.FileNotFoundException;
import java.io.File;

public class Delete extends Sentencia{

    public Delete (String[] consultaSeparada, File ruta) { super(consultaSeparada, ruta); }

    public void comprobarSintaxis() {
        File[] tablas = ruta.listFiles();
        Boolean encontrado = false;

        if (!consultaSeparada[1].equalsIgnoreCase("FROM")) {
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

        if (!consultaSeparada[3].equalsIgnoreCase("WHERE")) {
            throw new InvalidSentenceException();
        }
    }

    public void accionSentencia() {
        Where where = new Where(consultaSeparada, ruta, "DELETE");
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
    }
}
