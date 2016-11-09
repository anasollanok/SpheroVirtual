package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Controller {
@FXML
    Button Boton;
    @FXML
    Pane Panel;

    @FXML
    javafx.scene.canvas.Canvas Canvas;


    public void SEHIZOCLICK(ActionEvent actionEvent) {

      // Button temp= (Button) actionEvent.getSource();
    //    temp.setText("yup");
        Boton.setText("YEEEEAH");

        drawStuff();


    }

    private void moveCanvas(Canvas canvas, int x, int y) {
        canvas.setTranslateX(x);
        canvas.setTranslateY(y);
    }

    private void drawStuff() {

        moveCanvas(Canvas, 0, 0); //centramos en 0,0
     //   Canvas canvas = new Canvas(300, 300);
        final GraphicsContext gc = Canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, Canvas.getWidth(), Canvas.getHeight());

       // gc.setFill(Color.GOLDENROD);
      //  gc.setFont(Font.getDefault());
      //  gc.fillText("hello   world!", 15, 50);

        gc.setLineWidth(5);
        gc.setStroke(Color.PURPLE);

        gc.setFill(Color.BURLYWOOD);
        gc.fillRect(0, 0, Canvas.getWidth(), Canvas.getHeight());

        for (int x=100; x<Canvas.getWidth(); x++) {
            for (int y=100; y<Canvas.getHeight(); y++) {
                gc.setFill(Color.rgb(x % 255, y%255, 0));
                gc.fillRect(x, y, 1, 1);
            }
        }

        gc.strokeOval(10, 20, 30, 30);
       // gc.strokeOval(60, 60, 30, 30);
      //  gc.strokeRect(30, 100, 40, 40);

      //  gc.setStroke(Color.RED);
      //  gc.beginPath();
        //gc.moveTo(100,100);
       // gc.lineTo(15,22);
       // gc.closePath();

        gc.beginPath();
        gc.setFill(Color.BLACK);
        gc.moveTo(10, 10);
        gc.lineTo(100,100);
        gc.stroke();
        gc.closePath();


    }
}
