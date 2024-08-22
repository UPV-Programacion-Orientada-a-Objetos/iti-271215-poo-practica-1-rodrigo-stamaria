package sentencias;

import clases.ManipularCSV;
import sentencias.clasePadre.Sentencia;

import java.io.File;

public class Where extends Sentencia {
    String tipo, busqueda, columna, condicion = "", operador;

    public Where(String[] consultaSeparada, File ruta, String tipo) {
        super(consultaSeparada, ruta);
        this.tipo = tipo;
    }

    public void comprobarSintaxis() {
        //ESTO CAMBIA DEPENDIENDO DE LA SENTENCIA
        if (tipo.equals("DELETE")) {
            for (int i=4; i<consultaSeparada.length; i++) {
                condicion = condicion.concat(consultaSeparada[i] + " ");
            }
        }
        if (tipo.equals("SELECT")) {
            for (int i=5; i<consultaSeparada.length; i++) {
                condicion = condicion.concat(consultaSeparada[i] + " ");
            }
        }
        condicion = condicion.replace("(", "").replace(")", "");
        if (condicion.contains("=")) {
            columna = condicion.substring(0, condicion.indexOf("=")).trim();
            busqueda = condicion.substring(condicion.indexOf("=")+1, condicion.length()-1).trim();
            operador = "=";
        }
        if (condicion.contains(">")) {
            columna = condicion.substring(0, condicion.indexOf(">")).trim();
            busqueda = condicion.substring(condicion.indexOf(">")+1, condicion.length()-1).trim();
            operador = ">";
        }
        if (condicion.contains(">=")) {
            columna = condicion.substring(0, condicion.indexOf(">=")).trim();
            busqueda = condicion.substring(condicion.indexOf("=")+1, condicion.length()-1).trim();
            operador = ">=";
        }
        if (condicion.contains("<")) {
            columna = condicion.substring(0, condicion.indexOf("<")).trim();
            busqueda = condicion.substring(condicion.indexOf("<")+1, condicion.length()-1).trim();
            operador = "<";
        }
        if (condicion.contains("<=")) {
            columna = condicion.substring(0, condicion.indexOf("<=")).trim();
            busqueda = condicion.substring(condicion.indexOf("=")+1, condicion.length()-1).trim();
            operador = "<=";
        }
        if (condicion.contains("<>")) {
            columna = condicion.substring(0, condicion.indexOf("<>")).trim();
            busqueda = condicion.substring(condicion.indexOf(">")+1, condicion.length()-1).trim();
            operador = "<>";
        }
        if (condicion.contains("!=")) {
            columna = condicion.substring(0, condicion.indexOf("!=")).trim();
            busqueda = condicion.substring(condicion.indexOf("=")+1, condicion.length()-1).trim();
            operador = "!=";
        }

        switch (tipo) {
            case "DELETE":
                //ManipularCSV.encontrarLineaDelete(ruta, consultaSeparada[2], columna, busqueda, operador);
                break;

            case "UPDATE":
                break;

            case "SELECT":
                break;
        }
    }

    public void accionSentencia() {
        //Leer todo el csv
        //ManipularCSV.encontrarLinea(ruta, consultaSeparada[3], );
        //Encontrar una concidencia con el valor ingresado por el usuario en la columna que este desea

        switch (tipo) {
            case "DELETE":
                break;

            case "UPDATE":
                break;

            case "SELECT":
                ManipularCSV.encontrarLineaSelect(ruta, consultaSeparada[3], columna, busqueda, operador, consultaSeparada[1]);
                break;
        }
    }
}
