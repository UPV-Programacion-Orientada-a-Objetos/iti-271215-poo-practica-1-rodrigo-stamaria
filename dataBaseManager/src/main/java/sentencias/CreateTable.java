package sentencias;
import excepciones.InvalidSentenceException;
import sentencias.clasePadre.Sentencia;

import java.io.File;

public class CreateTable extends Sentencia {
    String consulta;
    String datosDeTabla = "";
    File ruta;

    public CreateTable(String[] consultaSeparada, String consulta) {
        super(consultaSeparada);
        this.consulta = consulta;
    }

    public void setRuta(File ruta) { this.ruta = ruta; }

    public void comprobarSintaxis() {
        if (!consultaSeparada[1].equalsIgnoreCase("TABLE")) {
            throw new InvalidSentenceException();
        }

        //Aqui se debe comprobar que el nomnbre de la tabla no esté repetido
        //Mediante un ciclo for recorrer mi array de tablas

        for (int i=3; i<consultaSeparada.length; i++) {
            datosDeTabla = datosDeTabla.concat(consultaSeparada[i] + " ");
        }

        String[] separacionPorParentesis = datosDeTabla.split(",");

        if (!(separacionPorParentesis[0].startsWith("(") &&
              separacionPorParentesis[separacionPorParentesis.length-1].trim().endsWith(")"))) {
            throw new InvalidSentenceException();
        }

        for (int i=0; i<separacionPorParentesis.length; i++) {
            //En esta seccion se debe comprobar la sintaxis de cada una de las columnas de la tabla
        }
    }

    public void accionSentencia() {
        //Se crea la tabla en formato csv
    }
}
