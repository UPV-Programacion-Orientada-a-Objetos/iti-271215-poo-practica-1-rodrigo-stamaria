package sentencias;

import sentencias.clasePadre.Sentencia;

import java.io.*;

public class Use extends Sentencia {
    String consulta;
    String[] consultaSeparada;
    File ruta;

    public Use(String consulta, String[] consultaSeparada) {
        this.consulta = consulta;
        this.consultaSeparada = consultaSeparada;
    }

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
