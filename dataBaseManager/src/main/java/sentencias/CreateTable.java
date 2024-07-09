package sentencias;
import sentencias.clasePadre.Sentencia;

public class CreateTable extends Sentencia {
    String[] consultaSeparada;

    public CreateTable(String[] consultaSeparada) { super(consultaSeparada); }

    public void comprobarSintaxis() {

        System.out.println("POR FAVOR FUNCIONA");
    }

    public void accionSentencia() {
        //Se crea la tabla en formato csv
    }
}
