package sentencias;

import excepciones.InexistentComponentException;
import excepciones.InvalidSentenceException;
import sentencias.clasePadre.Sentencia;
import java.io.File;

public class Update extends Sentencia{

    public Update (String[] consultaSeparada, File ruta) {
        super(consultaSeparada, ruta);
    }

    public void comprobarSintaxis() {
        File[] tablas = ruta.listFiles();
        Boolean encontrado = false;

        for (File tabla : tablas) {
            if (tabla.getName().equalsIgnoreCase(consultaSeparada[1].concat(".csv"))) {
                encontrado = true;
            }
        }

        if (!encontrado || tablas == null) {
            throw new InexistentComponentException();
        }

        if (!consultaSeparada[2].equalsIgnoreCase("SET")) {
            throw new InvalidSentenceException();
        }

        String columnaAactualizar = consultaSeparada[3];
        String actualizacion = consultaSeparada[5];

        String columnaCondicion = consultaSeparada[7];
        String condicion = consultaSeparada[9];
    }

    public void accionSentencia() {
        Where where = new Where(consultaSeparada, ruta, "UPDATE");
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
