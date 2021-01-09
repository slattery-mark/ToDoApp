import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main {

    public static class ToDoApp extends Application {

        @Override
        public void init() throws Exception {
            // Initialization, code that runs before the start i.e., loading
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("Scenes/scene_main.fxml"));
            Scene mainScreen = new Scene(root);
            primaryStage.setTitle("To Do");
            primaryStage.setScene(mainScreen);
            primaryStage.show();
        }

        @Override
        public void stop() throws Exception {
            // Code the runs after the application is stopped
        }
    }

    public static void main(String[] args) {

        Application.launch(ToDoApp.class, args);

    }

}
