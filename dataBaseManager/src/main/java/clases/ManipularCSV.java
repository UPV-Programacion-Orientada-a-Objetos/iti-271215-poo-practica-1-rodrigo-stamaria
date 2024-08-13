package clases;

import java.io.*;

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
            System.err.println("Error al crear el archivo CSV: " + e.getMessage());
        }
    }

    public static void escribirCSV (String ruta, String nombreDeTabla, String linea) {

    }

    public static String leerPrimeraLinea (File rutaDeTabla) {
        String linea = "";
        String[] lineas;

        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaDeTabla));
            linea = br.readLine();
            //lineas = linea.split(",");
            br.close();
        } catch (Exception e) {
            System.out.println("Archivo no encontrado");
        }
        return linea;
    }
}
