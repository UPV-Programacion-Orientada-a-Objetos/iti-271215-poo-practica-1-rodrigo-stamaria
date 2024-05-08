package edu.upvictoria.fpoo;

//Confirmar mediante uni testing
//Un jar autoejecutable
//Programar mi propio framework de excepciones
//Cada tabla es cada archivo

public class App 
{
    public static void main( String[] args )
    {
        /*
        Definicion inicial de mis palabras reservadas y de la cadena en la que el usuario hará el input
         */
        String consulta = "";
        consulta = ManipularStrings.encontrarCaracter(consulta);
        String[] consultaSeparada = ManipularStrings.separarConsulta(consulta);

        for (int i = 0; i < consultaSeparada.length; i++) {
            System.out.print(consultaSeparada[i]);
            System.out.print("|");
        }

        try {
            System.out.println(PalabrasReservadas.identificarSentencia(consultaSeparada));
        } catch (Exception IncompleteSenteceException) {
            System.out.println("Sentencia incompleta :(");
        }
    }
}
