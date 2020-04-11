package app;

import javafx.application.Application;
import javafx.stage.Stage;
import view.InsertionStage;

/**
 *
 * @author Fabián Stiven Valencia Córdoba
 */
public class main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        InsertionStage.getInstance();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
