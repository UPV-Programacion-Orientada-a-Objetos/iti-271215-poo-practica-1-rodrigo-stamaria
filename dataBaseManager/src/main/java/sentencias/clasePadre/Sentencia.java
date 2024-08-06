package sentencias.clasePadre;

import java.io.FileNotFoundException;
import java.io.File;

public class Sentencia {
    public File ruta;
    public String[] consultaSeparada;
    public Sentencia(String[] consultaSeparada, File ruta) {
        this.consultaSeparada = consultaSeparada;
        this.ruta = ruta;
    }
    public void comprobarSintaxis() throws FileNotFoundException {}
    public void accionSentencia() {}
}
