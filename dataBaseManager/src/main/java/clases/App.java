package clases;
import excepciones.InvalidSentenceException;
import sentencias.CreateTable;
import sentencias.Use;
import sentencias.clasePadre.Sentencia;
import java.io.FileNotFoundException;
import java.io.File;

//Confirmar mediante uni testing

public class App {
    public static void main(String[] args ) {

        /*
        Definicion de mis variables iniciales:
        consulta inicializa el String que guardará, como su nombre lo indica, la consulta del usuario
        sentenciaPorIdentificar es una variable tipo SentenciaIdentificada, esta se encargará de manejar e identificar la sentencia del usuario
        sentenciaIdentificada es cuando ya sabemos que tipo de sentencia tenemos y por lo tanto se crea un objeto de esta
        ruta almacena la ruta en la que el usuario se encuentra trabajando
         */
        String consulta;
        boolean salir = false;
        SentenciaPorIdentificar sentenciaPorIdentificar;
        Sentencia sentenciaIdentificada;
        File ruta = null;

        //(!) PARSEAR LOS CSV PARA METERLOS DENTRO DEL PROGRAMA

        do {
            /*
            Se inicializar la variable de la sentencia que se vaya a identificar
             */
            sentenciaPorIdentificar = new SentenciaPorIdentificar();
            /*
            Llamada dedicada a identificar que tipo de consulta es la que ingresó el usuario
             */
            consulta = ManejarStrings.encontrarPuntoYcoma();
            sentenciaPorIdentificar.consulta = consulta;
            sentenciaPorIdentificar.consultaSeparada = ManejarStrings.separarConsulta(consulta);

            /*
            Se intenta identificar la sentencia, si existe, el atributo tipo del objeto sentenciaPorIdentificar ahora tiene un valor y el flujo del programa sigue
             */
            try {
                sentenciaPorIdentificar.identificarSentencia();
            } catch (InvalidSentenceException e) {
                System.out.println(e.getClass());
                break;
            }
            /*
            Encontrar una forma en la que esto solo se haga si la sentencia es valida ??
             */
            sentenciaIdentificada = sentenciaPorIdentificar.crearObjetoDeSentencia();
            if (sentenciaIdentificada.getClass() == CreateTable.class) {
                ((CreateTable) sentenciaIdentificada).setRuta(ruta);
            }

            /*
            Se comprueba la sintaxis de la sentencia una vez ha sido identificada
             */
            try {
                sentenciaIdentificada.comprobarSintaxis();
            } catch (FileNotFoundException e) {
                System.out.println(e.getClass());
                break;
            } catch (InvalidSentenceException e) {
                System.out.println(e.getClass());
                break;
            }

            /*
            Se realiza la ccion de la sentencia
             */
            try {
                sentenciaIdentificada.accionSentencia();
                if (sentenciaIdentificada.getClass() == Use.class) {
                    ruta = ((Use) sentenciaIdentificada).getRuta();
                }
            } catch (Exception e) {
                //se maneja la excepcion
            }
        } while (!salir);
    }
}
