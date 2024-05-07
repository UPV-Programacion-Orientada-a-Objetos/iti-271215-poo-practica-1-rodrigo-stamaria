package edu.upvictoria.fpoo;

import java.util.HashMap;
import java.util.Map;

public class PalabrasReservadas {

    /*
    Hashmap de palabras reservadas de sql
     */
    public static void definirHashmap() {
        HashMap <String, String> palabrasReservadas = new HashMap<>();
        //ordenar alfabeticamente
        palabrasReservadas.put("table", "table");
        palabrasReservadas.put("tables", "tables");
        palabrasReservadas.put("create", "create");
        palabrasReservadas.put("insert", "insert");
        palabrasReservadas.put("into", "into");
        palabrasReservadas.put("update", "update");
        palabrasReservadas.put("set", "set");
        palabrasReservadas.put("select", "select");
        palabrasReservadas.put("delete", "delete");
        palabrasReservadas.put("drop", "drop");
        palabrasReservadas.put("show", "show");
        palabrasReservadas.put("values", "values");
        palabrasReservadas.put("where", "where");
        palabrasReservadas.put("and", "and");
        palabrasReservadas.put("or", "or");
        palabrasReservadas.put("from", "from");
    }

}
