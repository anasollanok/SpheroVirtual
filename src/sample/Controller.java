package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
@FXML
Button testBTN;


    public void SEHIZOCLICK(ActionEvent actionEvent) {

      // Button temp= (Button) actionEvent.getSource();
    //    temp.setText("yup");
        testBTN.setText("YEEEEAH");
        System.out.print("tesst");

    }
}
