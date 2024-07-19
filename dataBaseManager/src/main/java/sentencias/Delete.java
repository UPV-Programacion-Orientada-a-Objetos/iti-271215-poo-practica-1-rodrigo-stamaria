package sentencias;
import excepciones.InvalidSentenceException;
import sentencias.clasePadre.Sentencia;

import java.io.FileNotFoundException;

public class Delete extends Sentencia{

    public Delete (String[] consultaSeparada) {
        super(consultaSeparada);
    }

    //(!) PROBABLEMENTE SE TENGA QUE CAMBUIAR EL NOMBRE DE EXCEPCION CUANDO LA SINTAXIS NO ES CORRECTA
    public void comprobarSintaxis() throws FileNotFoundException {
        if (!consultaSeparada[1].equalsIgnoreCase("FROM")) {
            throw new InvalidSentenceException();
        }
        //Aqui se comprueba que la tabla que ingrese el usuario se encuentre en existencia
        if (!consultaSeparada[3].equalsIgnoreCase("WHERE")) {
            throw new InvalidSentenceException();
        }
        //Aqui va la condicion que se debe cumplir para que la fila sea eliminada
    }

    public void accionSentencia() {
        super.accionSentencia();
    }
}
