package model;

/**
 *
 * @author Fabián Stiven Valencia Córdoba
 */
import java.util.ArrayList;
import view.AlertBox;
import view.IAlertBox;

public class AlgoritmoVoraz {

    private ArrayList<String> temporal;
    private boolean estado;
    private String[] cadena;
    /**
     * Constructor de la clase AlgoritmoVoraz.
     * @param cadena 
     */
    public AlgoritmoVoraz(String[] cadena) {
        this.cadena = cadena;
        temporal = new ArrayList();
        estado = false;
    }

    public void resolver(int posInicial) {
        int recursivo = posInicial;
        int i = posInicial;
        String resultado = getResultado(cadena[i - 2] + cadena[i - 1]);
        System.out.println(cadena[i - 2] + cadena[i - 1] + "=>" + resultado);

        while (i < cadena.length) {
            System.out.print(resultado + cadena[i] + "=>");
            resultado = getResultado(resultado + cadena[i]);
            System.out.println(resultado);
            i++;
        }
        if (estado) {
            int j = temporal.size();
            while (j > 0) {
                System.out.print(temporal.get(j - 1) + resultado + "=>");
                resultado = getResultado(temporal.get(j - 1) + resultado);
                System.out.println(resultado);
                j--;
            }
        }
        if ("a".equals(resultado)) {
            IAlertBox alert = new AlertBox();
            alert.showAlert("Inserción en parentesis", "Resultado", "Si");

        } else if (recursivo < cadena.length) {
            temporal.add(cadena[posInicial - 2]);
            estado = true;
            resolver(recursivo += 1);
        } else {
            IAlertBox alert = new AlertBox();
            alert.showAlert("Inserción en parentesis", "Resultado", "No");

        }
    }

    /**
     * Método que se encarga de retornar el resultaado de un valor.
     */
    public String getResultado(String valor) {
        switch (valor) {
            case "aa":
                return "b";
            case "ab":
                return "b";
            case "ac":
                return "a";
            case "ba":
                return "c";
            case "bb":
                return "b";
            case "bc":
                return "a";
            case "ca":
                return "a";
            case "cb":
                return "c";
            case "cc":
                return "c";

        }
        return valor;
    }
}
