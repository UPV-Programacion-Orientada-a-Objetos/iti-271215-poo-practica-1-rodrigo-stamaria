package sentencias;

import sentencias.clasePadre.Sentencia;

import java.io.FileNotFoundException;

import excepciones.InvalidSentenceException;
import java.io.File;

public class Insert extends Sentencia {

    public Insert (String[] consultaSeparada, File ruta) {
        super(consultaSeparada, ruta);
    }

    public void comprobarSintaxis() throws FileNotFoundException {
        if (!consultaSeparada[1].equalsIgnoreCase("INTO")) {
            throw new InvalidSentenceException();
        }
        //Aqui se comprueba que la tabla ingresada por el usuario exista dentro de la base dadatos
        for (int i=3; i < consultaSeparada.length; i++) {
            if (consultaSeparada[i].startsWith("(")) {
                for (int j=i; j < consultaSeparada.length; j++) {
                    System.out.println(consultaSeparada[j]);
                    //Validacion de cada una de las columnas (?)
                    //Probablemente tambien deban guardarse las columnas dentro de un array para poder meterlo al csv
                    if (consultaSeparada[i].endsWith(")")) { break; }
                }
                break;
            }
        }
    }

    public void accionSentencia() {
        //Se modifica el archivo CSV para que se inserte una nueva linea
    }
}
