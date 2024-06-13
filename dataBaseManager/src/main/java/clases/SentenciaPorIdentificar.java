package clases;

import excepciones.*;
import sentencias.*;
import sentencias.clasePadre.Sentencia;

public class SentenciaPorIdentificar {

    String consulta;
    String[] consultaSeparada;
    String tipo;

    static String[] sentencias = {
            "INSERT",
            "UPDATE",
            "SELECT",
            "DELETE",
            "CREATE",
            "DROP",
            "USE"
    };

    static String[] comandos = {
            "show",
            "tables"
    };

    static String[] palabrasReservadas = {
            "WHERE",
            "FROM",
            "SET",
            "VALUES"
    };

    static String[] operadores = {
            "and",
            "or"
    };

    /*
    Funcion dedicada a identificar la sentencia de la ingresion del usuario, si esta no es valida se arroja la excepcion
     */
    public void identificarSentencia() {
        boolean sentenciaValida = false;
        for (int i = 0; i < sentencias.length; i++) {
            if (sentencias[i].equals(consultaSeparada[0].toUpperCase())) {
                tipo = sentencias[i].toUpperCase();
                sentenciaValida = true;
                break;
            }
        }
        if (!sentenciaValida) {
            throw new InvalidSentenceException();
        }
    }

    /*
    Funcion dedicada a crear un objeto dependiendo del tipo de sentencia que el usuario este realizando
     */
    public Sentencia crearObjetoDeSentencia() {
        Sentencia sentenciaIdentificada = new Sentencia();
        switch (tipo) {
            case "INSERT":
                break;
            case "UPDATE":
                break;
            case "SELECT":
                break;
            case "DELETE":
                break;
            case "CREATE":
                sentenciaIdentificada = new CreateTable();
                break;
            case "DROP":
                sentenciaIdentificada = new Drop();
                break;
            case "USE":
                sentenciaIdentificada = new Use(consulta, consultaSeparada);
                break;
        }
        return sentenciaIdentificada;
    }
}