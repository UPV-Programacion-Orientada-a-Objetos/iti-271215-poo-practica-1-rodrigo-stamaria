package sentencias;

import excepciones.InvalidSentenceException;
import sentencias.clasePadre.Sentencia;

public class Update extends Sentencia{

    public Update (String[] consultaSeparada) {
        super(consultaSeparada);
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
