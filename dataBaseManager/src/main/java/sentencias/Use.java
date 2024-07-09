package sentencias;
import sentencias.clasePadre.Sentencia;
import java.io.*;

public class Use extends Sentencia {
    File ruta;

    public Use(String[] consultaSeparada) { super(consultaSeparada); }

    public void comprobarSintaxis() throws FileNotFoundException {
        File rutaAbuscar = new File(consultaSeparada[1]);
        if (!rutaAbuscar.exists()) {
            throw new FileNotFoundException();
        }
        ruta = rutaAbuscar;
    }

    public void accionSentencia() {
        this.ruta = ruta;
    }

    public File getRuta() {
        return ruta;
    }
}
