package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_EditTaskScene implements Initializable {

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

    }

    @FXML
    public void BtnBackPress(ActionEvent event){

    }

    @FXML
    public void BtnDeletePress(ActionEvent event){

    }

}