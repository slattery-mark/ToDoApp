package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class Controller_MainScreen {

    @FXML
    private MenuItem File_NewTask;

    @FXML
    private ListView<?> TaskList;

    private Controller_NewTaskScreen newTaskScreenController;

    @FXML
    void NewTaskButtonPress(ActionEvent event) throws Exception {
        Parent newTaskScreenRoot = FXMLLoader.load(getClass().getResource("Screens/newtaskscreen.fxml"));
        Scene mainScreen = new Scene(newTaskScreenRoot);
        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("To Do");
        secondaryStage.setScene(mainScreen);
        secondaryStage.show();
    }

}
