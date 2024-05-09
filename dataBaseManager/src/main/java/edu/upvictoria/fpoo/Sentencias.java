package edu.upvictoria.fpoo;

import edu.upvictoria.fpoo.exceptions.IncorrectUseOfSentenceException;
import edu.upvictoria.fpoo.exceptions.InvalidIngresionException;
import edu.upvictoria.fpoo.exceptions.InvalidSentenceException;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystemAlreadyExistsException;
import java.util.ArrayList;

public class Sentencias {

    /*
    Variable que establece el directorio en el que se realizarán las modificaciones y arrays con las palabras reservadas,
    los arrays probablemente sean eliminados en el futuro, actualmente se encuentran aquí para más que nada ayuda visual.
     */
    File directorio = new File("/home/rodrigo-santamaria/Escritorio/Escuela/6to/POO/Unidad 1/iti-271215-poo-practica-1-rodrigo-stamaria/dataBaseManager/src/main/java/edu/upvictoria/fpoo/dataBase");

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
    public String identificarSentencia(String[] sentencia) throws FileNotFoundException {
        switch (sentencia[0].toLowerCase()) {
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
                if (sentencia[1].toLowerCase().equals("table")) {
                    sentencia[2] = sentencia[2].toUpperCase();
                    sentenciaCreate(sentencia[2], sentencia);
                } else {
                    throw new IncorrectUseOfSentenceException();
                }
                break;

            case "drop":
                if (sentencia[1].toLowerCase().equals("table")) {
                    sentenciaDrop();
                } else {
                    throw new IncorrectUseOfSentenceException();
                }
                break;

            case "use":
                sentenciaUse(sentencia[1]);
                break;

            case "show":
                if (sentencia[1].toLowerCase().equals("tables")) {
                    sentenciaShow();
                } else {
                    throw new IncorrectUseOfSentenceException();
                }
                break;

            default:
                throw new InvalidSentenceException("");
        }
        return "";
    }

    private void sentenciaInsert() {

    }

    private void sentenciaUpdate() {

    }

    private void sentenciaSelect() {

    }

    private void sentenciaDelete() {

    }

    /*
    Funcion dedicada a crear una tabla
     */
    private void sentenciaCreate(String nombreDeTabla, String[] sentencia) {
        //el nombre de la columna no se verifica
        //validar el tipo de variable de la columna
        //validar si es nula o no
        if (ManejarStrings.diferenteAabecedario(nombreDeTabla) == false) {
            for (File archivo : directorio.listFiles()) {
                if (!archivo.getName().equals(nombreDeTabla + ".csv")) {
                    //verificar con comas
                    if (sentencia[3].startsWith("(") && sentencia[sentencia.length-1].endsWith(")")) {
                        int contador = 3;
                        ArrayList<String> nombreDeColumnas= new ArrayList<>();
                        ArrayList<String> tiposDeDato= new ArrayList<>();
                        ArrayList<String> nuloOno= new ArrayList<>();
                        ArrayList<String> llaves= new ArrayList<>();
                        do {
                            nombreDeColumnas.add(sentencia[contador]);
                            contador++;
                            tiposDeDato.add(sentencia[contador]);
                            contador++;
                            if (sentencia[contador].toLowerCase().equals("not")) {
                                nuloOno.add("NOT NULL");
                                contador=+2;
                            } else if (sentencia[contador].toLowerCase().equals("null")) {
                                nuloOno.add("NULL");
                                contador++;
                            }
                            //definicion de llaves
                        } while (contador < sentencia.length);
                        System.out.println("Funciona!");
                    } else {
                        throw new InvalidIngresionException();
                    }
                } else {
                    throw new FileSystemAlreadyExistsException();
                }
            }
        } else {
            throw new InvalidIngresionException(); //(?) realizar una excepcion extendida de esta en la que se especifique que el nombre de la tabla no es valido
        }
    }

    private void sentenciaDrop() {

    }

    /*
    Funcion dedicada a buscar la ruta ingresada por el usuario
     */
    private void sentenciaUse(String ruta) throws FileNotFoundException{
        directorio = new File(ruta);
        if (directorio.exists()) {
            //this.directorio = directorio;
            System.out.println("\nDUA LIPA");
        } else {
            throw new FileNotFoundException();
        }
    }

    /*
    Funcion dedicada a mostrar todas las tablas de la base de datos
     */
    private void sentenciaShow() throws FileNotFoundException {
        boolean directorioVacio = true;
        for (File archivo : directorio.listFiles()) {
            System.out.println(archivo.getName());
            directorioVacio = false;
        }
        if (directorioVacio) {
            throw new FileNotFoundException();
        }
    }
}
