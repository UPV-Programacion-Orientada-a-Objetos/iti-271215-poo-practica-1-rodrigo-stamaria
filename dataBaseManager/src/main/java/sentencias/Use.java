package sentencias;

import clases.App;
import com.sun.tools.javac.Main;
import sentencias.clasePadre.Sentencia;

import java.io.*;

public class Use extends Sentencia {
    String consulta;
    String[] consultaSeparada;
    boolean valida;
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
        valida = true;
        System.out.println("MICHAEL JACKSON");
    }

    public void accionSentencia() {
        //asginar a la variable "ruta" de main el valor de "ruta" de esta funcion
    }
}
