package Controllers;

import TaskResources.Task;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_EditTaskScene implements Initializable {
    private Task task;
    private Scene mainScene;
    @FXML
    private Button BtnBack;

    @FXML
    private TextField TaskName;

    @FXML
    private TextArea TaskDescription;

    @FXML
    private Button BtnDelete;

    Controller_EditTaskScene(Scene mainScene) {
        this.mainScene = mainScene;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TaskName.setText(task.getName());
        TaskDescription.setText(task.getDescription());
    }
    @FXML
    void BtnBackPress(ActionEvent event) throws IOException {
        Node source = (Node)event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.setScene(mainScene);
    }

    void initData(Task task) {
        this.task = task;
    }

}