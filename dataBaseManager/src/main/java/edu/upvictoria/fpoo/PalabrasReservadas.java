package edu.upvictoria.fpoo;

import edu.upvictoria.fpoo.exceptions.IncorrectUseOfSentenceException;
import edu.upvictoria.fpoo.exceptions.InvalidSentenceException;

public class PalabrasReservadas {

    static String[] sentencias = {
            "insert",
            "update",
            "select",
            "delete",
            "create",
            "drop",
            "use"
    };

    static String[] comandos = {
            "show tables"
    };

    static String[] palabrasReservadas = {
            "where",
            "from",
            "set",
            "values"
    };

    static String[] operadores = {
            "and",
            "or"
    };

    /*
    Funcion dedicada a identificar la sentencia de la ingresion del usuario
     */
    public static String identificarSentencia(String[] sentencia) throws IncorrectUseOfSentenceException {
        switch (sentencia[0]) {
            case "insert":
                if (sentencia[1].equals("into")) {
                    //validar si la tabla existe
                    //validar que las columnas existan
                    //validar que el numero de datos sea el mismo que el la cantidad de columnas
                    //Se realiza la sentencia insert
                    System.out.println("Realizando sentencia insert");
                }
                break;

            case "update":
                //sentencia update
                break;

            case "select":
                //sentencia select
                break;

            case "delete":
                //sentencia delete
                break;

            case "create":
                if (sentencia[1].equals("table")) {
                    //validar que el nombre de la tabla no esté repetido
                    //verificar que el primer caracter sea "("
                    //el nombre de la columna no se verifica
                    //validar el tipo de variable de la columna
                    //validar si es nula o no
                } else {
                    throw new IncorrectUseOfSentenceException("");
                }
                break;

            case "drop":
                if (!sentencia[1].equals("table")) {
                    throw new IncorrectUseOfSentenceException("");
                }
                break;

            case "use":
                sentenciaUse(sentencia[1]);
                break;

            default:
                throw new InvalidSentenceException("");
        }
        return "";
    }

    private static void sentenciaInsert() {

    }

    private static void sentenciaUpdate() {

    }

    private static void sentenciaSelect() {

    }

    private static void sentenciaDelete() {

    }

    private static void sentenciaCreate() {

    }

    private static void sentenciaDrop() {

    }

    private static void sentenciaUse(String ruta) {
        //buscar la ruta ingresada por el usuario
        //si esta no existe se crea el directorio
    }
}
