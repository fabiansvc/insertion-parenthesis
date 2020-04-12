package model;

import view.AlertBox;
import view.IAlertBox;

/**
 *
 * @author Fabián Stiven Valencia Córdoba
 */
public class AlgoritmoVoraz {

    private String[] cadena;
    private int lengthFinal = 0;

    /**
     * Constructor de la calse algoritmo voraz
     */
    public AlgoritmoVoraz(String[] cadena) {
        this.cadena = cadena;
    }

    public void resolver() {
        if (buscarC(cadena)) {
            if (lengthFinal == 1) {
                if ("a".equals(getResultado(cadena[0] + "c"))) {
                    showResultado("Si");
                } else {
                    showResultado("No");
                }
            } else {
                if (buscarA(cadena, lengthFinal)) {
                    showResultado("Si");
                } else {
                    showResultado("No");
                }

            }
        } else {
            showResultado("No");
        }

    }

    private boolean buscarC(String cadena[]) {
        String resultado = getResultado(cadena[cadena.length - 2] + cadena[cadena.length - 1]);
        if (resultado.equals("c")) {
            lengthFinal = cadena.length - 2;
            return true;
        } else {
            for (int i = cadena.length - 3; i > 0; i--) {
                resultado = getResultado(cadena[i] + resultado);
                if (resultado.equals("c")) {
                    lengthFinal = i;
                    return true;
                }
            }
        }
        if (cadena[0] == "c" && resultado == "a") {
            showResultado("Si");
        }

        return false;
    }

    private boolean buscarA(String[] cadena, int tam) {
        String resultado = getResultado(cadena[0] + cadena[1]);
        if (resultado.equals("a")) {
            return true;
        } else {
            for (int i = 2; i <= tam; i++) {
                resultado = getResultado(resultado + cadena[i]);
                if (resultado.equals("a")) {
                    return true;
                }
            }
        }
        if (resultado == "b") {
            showResultado("Si");
        }
        return false;
    }

    private boolean buscarABC(String[] cadena) {
        return false;
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

    private void showResultado(String msg) {
        IAlertBox alert = new AlertBox();
        alert.showAlert("Inserción en parentesis", "Resultado", msg);
    }
}
