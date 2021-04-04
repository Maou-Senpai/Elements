import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Elements - An Offline Periodic Table");
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MainWindow.fxml"))));
        primaryStage.setMinWidth(1140);
        primaryStage.setMinHeight(696);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}