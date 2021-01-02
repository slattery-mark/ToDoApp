package Controllers;

import TaskResources.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller_NewTaskScene {

    @FXML
    private TextField TaskNameField;

    @FXML
    private TextField TaskDescriptionField;

    @FXML
    private Button AddTaskButton;

    @FXML
    private Button CancelButton;

    @FXML // Add Task button execution
    void AddTask(ActionEvent event) {
        // create popup if task name field is empty? or find way to disable "Add Task" button
        if (TaskNameField.getText().trim().isEmpty()) {

        }
        else {
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
