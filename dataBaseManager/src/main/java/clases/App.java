package clases;
import sentencias.clasePadre.Sentencia;

//Confirmar mediante uni testing

public class App {
    public static void main( String[] args ) {

        /*
        Definicion de mis variables iniciales:
        consulta inicializa el String que guardará, como su nombre lo indica, la consulta del usuario
        sentenciaPorIdentificar es una variable tipo SentenciaIdentificada, esta se encargará de manejar e identificar la sentencia del usuario
        sentenciaIdentificada es cuando ya sabemos que tipo de sentencia tenemos y por lo tanto se crea un objeto de esta
         */
        String consulta = "";
        SentenciaPorIdentificar sentenciaPorIdentificar = new SentenciaPorIdentificar();

        /*
        Llamada dedicada a identificar que tipo de consulta es la que ingresó el usuario
         */
        consulta = ManejarStrings.encontrarPuntoYcoma(consulta);
        sentenciaPorIdentificar.consulta = consulta;
        sentenciaPorIdentificar.consultaSeparada = ManejarStrings.separarConsulta(consulta);

        /*
        Se intenta identificar la sentencia, si existe se asigna el tipo a la variable tipo sentenciaPoridentificar, si no se lanza una excepcion
        se asigna un valor a sentenciaIdentificada dependiendo del resultado de la función crearObjetoDeSentencia
         */
        sentenciaPorIdentificar.identificarSentencia();
        Sentencia sentenciaIdentificada = sentenciaPorIdentificar.crearObjetoDeSentencia();

        sentenciaIdentificada.comprobarSintaxis();
    }
}
