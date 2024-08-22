package clases;

import excepciones.*;
import sentencias.*;
import sentencias.clasePadre.Sentencia;

import java.io.File;

public class SentenciaPorIdentificar {

    String consulta;
    String tipo;
    File ruta;
    String[] consultaSeparada;

    static String[] sentencias = {
            "INSERT",
            "UPDATE",
            "SELECT",
            "DELETE",
            "CREATE",
            "DROP",
            "USE",
            "SHOW"
    };

    static String[] palabrasReservadas = {
            "WHERE",
            "FROM",
            "SET",
            "VALUES"
    };

    static String[] operadores = {
            "AND",
            "OR"
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
        Sentencia sentenciaIdentificada = null;
        switch (tipo) {
            case "INSERT":
                sentenciaIdentificada = new Insert(consultaSeparada, ruta);
                break;
            case "UPDATE":
                sentenciaIdentificada = new Update(consultaSeparada, ruta);
                break;
            case "SELECT":
                sentenciaIdentificada = new Select(consultaSeparada, ruta);
                break;
            case "DELETE":
                sentenciaIdentificada = new Delete(consultaSeparada, ruta);
                break;
            case "CREATE":
                sentenciaIdentificada = new CreateTable(consultaSeparada, ruta);
                break;
            case "DROP":
                sentenciaIdentificada = new DropTable(consultaSeparada, ruta);
                break;
            case "USE":
                sentenciaIdentificada = new Use(consultaSeparada, ruta);
                break;
            case "SHOW":
                sentenciaIdentificada = new ShowTables(consultaSeparada, ruta);
        }
        return sentenciaIdentificada;
    }
}