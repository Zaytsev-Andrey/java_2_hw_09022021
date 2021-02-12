package chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
    private final static double WIDTH = 250;
    private final static double MIN_HEIGHT = 350;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("chat.fxml"));
        primaryStage.setScene(new Scene(root));

        // Заголовок окна
        primaryStage.setTitle("Simple Chat");

        // Иконка окна
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/img/chat_icon.png")));

        // Получаем размеры активеного окна
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        // Ширина не изменяется, высота на весь активный экран
        primaryStage.setMinWidth(WIDTH);
        primaryStage.setMaxWidth(WIDTH);
        primaryStage.setMinHeight(MIN_HEIGHT);
        primaryStage.setHeight(bounds.getHeight());

        // Расположение в правом верхнем углу и поверх всех окон
        primaryStage.setX(bounds.getWidth() - WIDTH);
        primaryStage.setY(0);
        primaryStage.setAlwaysOnTop(true);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
