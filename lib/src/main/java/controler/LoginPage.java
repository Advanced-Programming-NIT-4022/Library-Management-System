package controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginPage {

        @FXML
        private RadioButton btnAdmin;

        @FXML
        private RadioButton btnNormal;

        @FXML
        private Button btnSign;

        @FXML
        private Button btnSignUp;

        @FXML
        private PasswordField txtPassword;

        @FXML
        private TextField txtUsername;

        @FXML
        void pressSignUp(ActionEvent event) {

        }

        @FXML
        void pressSignin(ActionEvent event) {
            if(btnAdmin.isSelected()){
                System.out.println("you are admin");
            }
            Stage stage=(Stage) btnSign.getScene().getWindow();
            stage.close();

        }

    public void pressRadioNormal(ActionEvent event) {
            if(btnNormal.isSelected()==true){
                btnAdmin.setDisable(true);
            }
            else{
                btnAdmin.setDisable(false);
            }

    }

    public void pressRadioAdmin(ActionEvent event) {
        if(btnAdmin.isSelected()==true){
            btnNormal.setDisable(true);
        }
        else{
            btnNormal.setDisable(false);
        }
    }
}


