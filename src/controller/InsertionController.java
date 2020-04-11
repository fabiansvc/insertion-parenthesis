package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import model.AlgoritmoDinamico;
import model.AlgoritmoVoraz;
import view.AlertBox;
import view.IAlertBox;

/**
 *
 * @author Fabián Stiven Valencia Córdoba
 */
public class InsertionController implements Initializable {

    @FXML
    private TextArea cadenaTxt;
    private String[] cadena;
    @FXML
    private ComboBox<String> opcion;
    private final ObservableList list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadChoiceBox();
    }

    /**
     * Método que carga los valores del Choice Box.
     */
    private void loadChoiceBox() {
        list.removeAll(list);
        list.addAll( "Programación Dinámica", "Programación Voraz");
        opcion.getItems().addAll(list);
        opcion.getSelectionModel().selectFirst();
    }

    /**
     * Método que resuelve el alfabeto por medio de un metodo de programación.
     *
     * @param event
     */
    @FXML
    private void btnResolverPressed(ActionEvent event) {
        String metodo = opcion.getSelectionModel().getSelectedItem().toString();
        switch (metodo) {
            case "Programación Voraz":
                resolverProgramacionVoraz();
                break;
            case "Programación Dinámica":
                resolverProgramacionDinamica();
                break;
        }
    }

    /**
     * Método que resuelve por programación voraz.
     */
    private void resolverProgramacionVoraz() {
        cadena = (cadenaTxt.getText()).trim().toLowerCase().split("");
        AlgoritmoVoraz av = new AlgoritmoVoraz(cadena);

        if (cadena.length > 2) {
            av.resolver(2);
        } else if (cadena.length > 1) {
            String resultado = av.getResultado(cadena[0] + cadena[1]);
            if("a".equals(resultado)){
                IAlertBox alert = new AlertBox();
                alert.showAlert("Inserción en parentesis", "Resultado", "Si");
            }else{
                 IAlertBox alert = new AlertBox();
                alert.showAlert("Inserción en parentesis", "Resultado", "No");
            }
        } else {
            IAlertBox alert = new AlertBox();
            alert.showAlert("Inserción en parentesis", "Información", "Solo se admiten cadenas mayores o iguales de 2 digitos y sin espacios del alfabeto {a,b,c}");
        }
    }

    /**
     * Método que resuelve por medio de la programación dinámica.
     */
    private void resolverProgramacionDinamica() {
        cadena = (cadenaTxt.getText()).trim().toLowerCase().split("");
        AlgoritmoDinamico ad = new AlgoritmoDinamico(cadena);
        if (cadena.length > 2) {
            ad.resolver();
        } else if (cadena.length > 1) {
        } else {
            IAlertBox alert = new AlertBox();
            alert.showAlert("Inserción en parentesis", "Información", "Solo se admiten cadenas mayores o iguales de 2 digitos y sin espacios del alfabeto {a,b,c}");
        }
    }
}
