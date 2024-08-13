package sentencias;

import excepciones.InexistentComponentException;
import excepciones.InvalidSentenceException;
import sentencias.clasePadre.Sentencia;

import java.io.FileNotFoundException;
import java.io.File;

public class DropTable extends Sentencia {
    File tablaAborrar;

    public DropTable(String[] consultaSeparada, File ruta) {
        super(consultaSeparada, ruta);
    }

    public void comprobarSintaxis() throws FileNotFoundException {
        File[] tablas = ruta.listFiles();
        Boolean encontrado = false;

        if (!consultaSeparada[1].equalsIgnoreCase("TABLE")) {
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

        tablaAborrar = new File(ruta + "/" + consultaSeparada[2].toUpperCase().concat(".csv"));
    }

    public void accionSentencia() {
        tablaAborrar.delete();
    }
}
