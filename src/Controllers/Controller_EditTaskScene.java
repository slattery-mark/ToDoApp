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

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_EditTaskScene implements Initializable {
    private Task task;
    @FXML
    private Button BtnBack;

    @FXML
    private TextField TaskName;

    @FXML
    private TextArea TaskDescription;

    @FXML
    private Button BtnDelete;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TaskName.setText(task.getName());
        TaskDescription.setText(task.getDescription());
    }

    void initData(Task task) {
        this.task = task;
    }

    @FXML
    public void BtnBackPress(ActionEvent event) throws java.io.IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/scene_main.fxml"));

        Scene scene = new Scene(root);
        Node source = (Node)event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setScene(scene);

    }

    @FXML
    private void BtnDeletePress(ActionEvent event){

    }

}