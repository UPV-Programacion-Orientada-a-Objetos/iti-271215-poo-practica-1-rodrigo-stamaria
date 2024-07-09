package sentencias.clasePadre;

import java.io.FileNotFoundException;

public class Sentencia {
    public String[] consultaSeparada;
    public Sentencia(String[] consultaSeparada) { this.consultaSeparada = consultaSeparada; }
    public void comprobarSintaxis() throws FileNotFoundException {}
    public void accionSentencia() {}
}
