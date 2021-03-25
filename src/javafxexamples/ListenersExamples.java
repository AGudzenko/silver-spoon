package javafxexamples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.ArrayList;

public class ListenersExamples extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("НАЖМИ НА КНОПКУ");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 360, 200));
        int c = 0;
        primaryStage.show();
    }

    private Parent createInterface() {

        ArrayList<String> sayButton = new ArrayList<String>();
        sayButton.add("Не нажимай на эту кнопку");
        sayButton.add("Я просил, не нажимай больше на эту кнопку");
        sayButton.add("Фуу ну зачем..");
        sayButton.add("Ну ты лох");
        sayButton.add("Я тебя предупреждал....");


        GridPane mainGridPain = new GridPane();
        VBox vb1 = new VBox();
        mainGridPain.add(vb1, 0, 0);

        Button b = new Button("Кнопка");
        Label l = new Label("");

        Image image = new Image("bum.gif");
        ImageView imageView = new ImageView();
        imageView.setImage(image);

        vb1.getChildren().addAll(
                b,
                l
        );

        b.addEventHandler(ActionEvent.ACTION, actionEvent -> {
            if(sayButton.size() != 0){
                l.setText(sayButton.get(0));
                sayButton.remove(0);
            }else{
                vb1.getChildren().remove(b);
                vb1.getChildren().remove(l);
                vb1.getChildren().addAll(
                        imageView
                );
            }


        });

        return mainGridPain;
    }
}