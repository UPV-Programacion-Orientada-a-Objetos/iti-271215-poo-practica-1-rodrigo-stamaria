package sentencias;
import sentencias.clasePadre.Sentencia;
import java.io.*;

public class Use extends Sentencia {
    File rutaAbuscar = new File(consultaSeparada[1]);

    public Use(String[] consultaSeparada, File ruta) {
        super(consultaSeparada, ruta);
    }

    public void comprobarSintaxis() throws FileNotFoundException {
        if (!rutaAbuscar.exists()) {
            throw new FileNotFoundException();
        }
    }

    public void accionSentencia() {
        ruta = rutaAbuscar;
    }

    public File getRuta() {
        return ruta;
    }
}
