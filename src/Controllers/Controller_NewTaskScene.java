package Controllers;

import TaskResources.Task;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_NewTaskScene implements Initializable {

    @FXML
    private TextField TaskNameField;

    @FXML
    private TextField TaskDescriptionField;

    @FXML
    private Button AddTaskButton;

    @FXML
    private Button CancelButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Disable Add Task Button while there is no text in the Task Name Field
        AddTaskButton.setDisable(true);
        TaskNameField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(t1.equals(""))
                    AddTaskButton.setDisable(true);
                else
                    AddTaskButton.setDisable(false);
            }
        });
    }

    @FXML // Add Task button execution
    void AddTask(ActionEvent event) {
        if (!TaskNameField.getText().trim().isEmpty()) {
            // Create a task object
            Task task = new Task(TaskNameField.getText(), TaskDescriptionField.getText());
            // Store the task in the stage object, which can be accessed by the stage is was called from(?), then close the stage
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setUserData(task);
            stage.getOnCloseRequest();
            stage.close();
        }
    }

    @FXML
    public void CloseStage(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.getOnCloseRequest();
        stage.close();
    }

}

