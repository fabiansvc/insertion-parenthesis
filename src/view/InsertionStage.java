package view;
/**
 *
 * @author Fabián Stiven Valencia Córdoba
 */
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class InsertionStage extends Stage {

    private FXMLLoader loader;
    /**
     * Constructor de InsertionStage
     */
    public InsertionStage() {
        try {
            loader = new FXMLLoader(getClass().getResource("/view/Insertion.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            setScene(scene);
            setTitle("Inserción en parentesis");
            getIcons().add(new Image("/recursos/imagenes/icon.png"));
            setResizable(false);
            show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que cierra el Stage del de Insertion<br>
     * y borra su instancia
     */
    public static void deleteInstance() {
        InsertionStageHolder.INSTANCE.close();
        InsertionStageHolder.INSTANCE = null;
    }

    /**
     * Método que por medio de una clase estatica retorna<br>
     * una instancia de la clase InsertionStage     *
     * @return
     */
    public static InsertionStage getInstance() {
        return InsertionStageHolder.INSTANCE = new InsertionStage();
    }

    /**
     * Clase estatica que contiene una instancia de la<br>
     * clase InsertionStage
     */
    private static class InsertionStageHolder {
        private static InsertionStage INSTANCE;
    }
    
}
