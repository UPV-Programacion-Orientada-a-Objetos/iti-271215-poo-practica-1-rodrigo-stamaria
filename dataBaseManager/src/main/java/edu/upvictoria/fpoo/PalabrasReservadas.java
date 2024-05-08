package edu.upvictoria.fpoo;

import edu.upvictoria.fpoo.exceptions.IncompleteSentenceException;

public class PalabrasReservadas {

    static String[] sentencias = {
            "insert",
            "update",
            "select",
            "delete",
            "create",
            "drop"
            //"table"
    };

    static String[] comandos = {
            "use",
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
    public static String identificarSentencia(String[] sentencia) throws IncompleteSentenceException {

        for (int i = 0; i < 5; i++) {
            if (sentencias[i].equals(sentencia[0]))
            {
                switch (sentencia[0]) {
                    case "insert":
                        if (sentencia[1].equals("into")) {
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
                        if (!sentencia[1].equals("table")) {
                            throw new IncompleteSentenceException("");
                        }
                        break;

                    case "drop":
                        if (!sentencia[1].equals("table")) {
                            throw new IncompleteSentenceException("");
                        }
                        break;
                }
            }
        }


        return "";
    }
}
