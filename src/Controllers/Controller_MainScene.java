package Controllers;

import TaskResources.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_MainScene implements Initializable {


    @FXML
    private MenuItem File_NewTask;

    @FXML
    private ListView<?> TaskList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // This is where the TaskList should be populated
        // And any other default attributes
    }

    @FXML
    public void NewTaskButtonPress(ActionEvent event) throws IOException {
        Parent newTaskScreenRoot = FXMLLoader.load(getClass().getResource("../Scenes/scene_newtask.fxml"));
        Scene newTaskScreen = new Scene(newTaskScreenRoot);
        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("Add a Task");
        secondaryStage.setScene(newTaskScreen);
        secondaryStage.show();
    }

}
