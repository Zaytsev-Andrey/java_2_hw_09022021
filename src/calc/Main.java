package calc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("calc.fxml"));
        primaryStage.setScene(new Scene(root, 300, 300));

        // Заголовок окна
        primaryStage.setTitle("Calculator");

        // Иконка окна
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/img/calc_icon.png")));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
