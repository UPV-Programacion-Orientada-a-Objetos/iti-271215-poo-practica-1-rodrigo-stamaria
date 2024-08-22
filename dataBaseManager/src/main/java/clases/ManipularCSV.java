package clases;

import java.io.*;
import java.util.ArrayList;

public class ManipularCSV {
    /*
    Definicion de variables iniciales de la clase ManipularCSV
    "br" se encarga de leer el archivo
    "linea" se encarga de almacenar linea por línea la información del archivo
    "lineas" es un arreglo que almacenará cada línea que sea leída del archivo
     */
    private BufferedReader br;
    private String linea;
    private String[] lineas;

    /*
    "leerCSV"
     */
    public static void leerCSV (File rutaDeTabla) {
        String linea;
        String[] lineas;
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaDeTabla));
            while ((linea = br.readLine()) != null) {
                lineas = linea.split(",");
                for (int i=0; i<lineas.length; i++) {
                    System.out.print(lineas[i]);
                }
                System.out.println();
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Archivo no encontrado");
        }
    }

    public static void crearCSV (String ruta, String nombreDeTabla, String cabecera) {
        File archivo = new File(ruta + "/" + nombreDeTabla.toUpperCase() + ".csv");

        try (FileWriter fw = new FileWriter(archivo)) {
            fw.write(cabecera);
        } catch (IOException e) {
            System.err.println("Error al crear el archivo CSV");
        }
    }

    public static String leerPrimeraLinea (File rutaDeTabla) {
        String linea = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaDeTabla));
            linea = br.readLine();
            br.close();
        } catch (Exception e) {
            System.out.println("Archivo no encontrado");
        }
        return linea;
    }

    public static void escribirNuevaLinea (String ruta, String nombreDeTabla, String nuevaLinea) {
        File archivo = new File(ruta + "/" + nombreDeTabla.toUpperCase() + ".csv");

        try (FileWriter fw = new FileWriter(archivo, true)){
            fw.append("\n" + nuevaLinea);
        } catch (Exception e) {
            System.out.println("Error al insertar nueva linea");
        }
    }

    public static void imprimirColumna (File rutaDeTabla, String nombreDeTabla, String columna) {
        File FileNombreDeTabla = new File(rutaDeTabla + "/" + nombreDeTabla.toUpperCase() + ".csv");
        String linea;
        String[] lineas;
        int indicadorColumnas = 0, indicadorSeleccion = 0;
        int contadorAuxiliar = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(FileNombreDeTabla));
            while ((linea = br.readLine()) != null) {
                lineas = linea.split(",");
                for (int i=0; i<lineas.length; i++) {
                    if (lineas[i].trim().equals(columna)) {
                        indicadorColumnas = i;
                        break;
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Archivo no encontrado");
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(FileNombreDeTabla));
            while ((linea = br.readLine()) != null) {
                lineas = linea.split(",");
                if (contadorAuxiliar != 0) {
                    System.out.print(lineas[indicadorColumnas] + "||");
                }
                contadorAuxiliar++;
                System.out.println();
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Archivo no encontrado");
        }
    }

    public static void encontrarLineaSelect (File rutaDeTabla, String nombreDeTabla, String columna, String busqueda, String operador, String seleccion) {
        File FileNombreDeTabla = new File(rutaDeTabla + "/" + nombreDeTabla.toUpperCase() + ".csv");
        String linea;
        String[] lineas;
        String cadenaSuplente = "";
        String lecturaPrimeraLinea = leerPrimeraLinea(FileNombreDeTabla);
        Boolean condicionCumplida = false;
        int indicadorColumnas = 0, contadorValores = 0, indicadorSeleccion = 0;
        int contadorAuxiliar = 0;

        if (seleccion.equals("*")){
            try {
                BufferedReader br = new BufferedReader(new FileReader(FileNombreDeTabla));
                while ((linea = br.readLine()) != null) {
                    lineas = linea.split(",");
                    for (int i=0; i<lineas.length; i++) {
                        if (lineas[i].trim().equals(columna)) {
                            indicadorColumnas = i;
                            break;
                        }
                        System.out.println();
                    }
                }
                br.close();
            } catch (Exception e) {
                System.out.println("Archivo no encontrado");
            }

            try {
                BufferedReader br = new BufferedReader(new FileReader(FileNombreDeTabla));
                while ((linea = br.readLine()) != null) {
                    lineas = linea.split(",");
                    if (contadorAuxiliar != 0) {
                        switch (operador) {
                            case "=":
                                for (int i=0; i<lineas.length; i++) {
                                    if (lineas[i].trim().equals(busqueda)) {
                                        for (int j=0; j<lineas.length; j++) {
                                            System.out.print(lineas[j] + "||");
                                        }
                                    }
                                }

                                break;

                            case ">":
                                    if (Integer.parseInt(lineas[indicadorColumnas].trim()) > Integer.parseInt(busqueda)) {
                                        for (int j=0; j<lineas.length; j++) {
                                            System.out.print(lineas[j] + "||");
                                        }
                                    }
                                break;

                            case ">=":
                                if (Integer.parseInt(lineas[indicadorColumnas].trim()) >= Integer.parseInt(busqueda)) {
                                    for (int j=0; j<lineas.length; j++) {
                                        System.out.print(lineas[j] + "||");
                                    }
                                }
                                break;

                            case "<":
                                if (Integer.parseInt(lineas[indicadorColumnas].trim()) < Integer.parseInt(busqueda)) {
                                    for (int j=0; j<lineas.length; j++) {
                                        System.out.print(lineas[j] + "||");
                                    }
                                }
                                break;

                            case "<=":
                                if (Integer.parseInt(lineas[indicadorColumnas].trim()) <= Integer.parseInt(busqueda)) {
                                    for (int j=0; j<lineas.length; j++) {
                                        System.out.print(lineas[j] + "||");
                                    }
                                }
                                break;

                            case "<>", "!=":
                                if (Integer.parseInt(lineas[indicadorColumnas].trim()) != Integer.parseInt(busqueda)) {
                                    for (int j=0; j<lineas.length; j++) {
                                        System.out.print(lineas[j] + "||");
                                    }
                                }
                                break;
                        }
                        System.out.println();
                    }
                    contadorAuxiliar++;
                }
                br.close();
            } catch (Exception e) {
                System.out.println("Archivo no encontrado");
            }
        } else {
            try {
                BufferedReader br = new BufferedReader(new FileReader(FileNombreDeTabla));
                while ((linea = br.readLine()) != null) {
                    lineas = linea.split(",");
                    for (int i=0; i<lineas.length; i++) {
                        if (lineas[i].trim().equals(columna)) {
                            indicadorColumnas = i;
                            break;
                        }
                    }
                }
                br.close();
            } catch (Exception e) {
                System.out.println("Archivo no encontrado");
            }
            try {
                BufferedReader br = new BufferedReader(new FileReader(FileNombreDeTabla));
                while ((linea = br.readLine()) != null) {
                    lineas = linea.split(",");
                    for (int i=0; i<lineas.length; i++) {
                        if (lineas[i].trim().equals(seleccion)) {
                            indicadorSeleccion = i;
                            break;
                        }
                    }
                }
                br.close();
            } catch (Exception e) {
                System.out.println("Archivo no encontrado");
            }

            try {
                BufferedReader br = new BufferedReader(new FileReader(FileNombreDeTabla));
                while ((linea = br.readLine()) != null) {
                    lineas = linea.split(",");
                    if (contadorAuxiliar != 0) {
                        switch (operador) {
                            case "=":
                                for (int i=0; i<lineas.length; i++) {
                                    if (lineas[i].trim().equals(busqueda)) {
                                        System.out.println(lineas[indicadorSeleccion]);
                                    }
                                }
                                break;

                            case ">":
                                if (Integer.parseInt(lineas[indicadorColumnas].trim()) > Integer.parseInt(busqueda)) {
                                    System.out.println(lineas[indicadorSeleccion]);
                                }
                                break;

                            case ">=":
                                if (Integer.parseInt(lineas[indicadorColumnas].trim()) >= Integer.parseInt(busqueda)) {
                                    for (int j=0; j<lineas.length; j++) {
                                        System.out.print(lineas[j] + "||");
                                    }
                                }
                                break;

                            case "<":
                                if (Integer.parseInt(lineas[indicadorColumnas].trim()) < Integer.parseInt(busqueda)) {
                                    for (int j=0; j<lineas.length; j++) {
                                        System.out.print(lineas[j] + "||");
                                    }
                                }
                                break;

                            case "<=":
                                if (Integer.parseInt(lineas[indicadorColumnas].trim()) <= Integer.parseInt(busqueda)) {
                                    for (int j=0; j<lineas.length; j++) {
                                        System.out.print(lineas[j] + "||");
                                    }
                                }
                                break;

                            case "<>", "!=":
                                if (Integer.parseInt(lineas[indicadorColumnas].trim()) != Integer.parseInt(busqueda)) {
                                    for (int j=0; j<lineas.length; j++) {
                                        System.out.print(lineas[j] + "||");
                                    }
                                }
                                break;
                        }
                    }
                    System.out.println();
                    contadorAuxiliar++;
                }
                br.close();
            } catch (Exception e) {
                System.out.println("Archivo no encontrado");
            }
        }
    }

    public static void encontrarLineaDelete (File rutaDeTabla, String nombreDeTabla, String columna, String busqueda) {
        
    }
}
