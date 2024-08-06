package sentencias;

import excepciones.InvalidSentenceException;
import sentencias.clasePadre.Sentencia;
import java.io.File;

public class Update extends Sentencia{

    public Update (String[] consultaSeparada, File ruta) {
        super(consultaSeparada, ruta);
    }

    public void comprobarSintaxis() {

        //Aqui se comprueba que el nombre de la tabla ingresada sea existente dentro de la base de datos

        if (!consultaSeparada[2].equalsIgnoreCase("SET")) {
            throw new InvalidSentenceException();
        }

        //Se comprueba que las columnas ingresadas sean existentes

        //Se comprueba que el WHERE esté bien implementado

        //Condicion del WHERE
    }

    public void accionSentencia() {
        System.out.println("AccionSentencia Update");
        //Se actualiza la columna requerida
    }
}
