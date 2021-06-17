package javafxexamples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

public class Exam extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Exam");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 600, 300));
        primaryStage.show();
    }
    private Parent createInterface() {
        GridPane mainGrid = new GridPane();

        Button button = new Button("Добавить");

        button.setPrefWidth(150);
        button.setMinWidth(150);

        Label[] lab = {new Label("синий"), new Label("желтый"), new Label("фиолетовый"), new Label("черный"), new Label("красный"), new Label("зеленый"), new Label("оранжевый")};
        String[] colors = {"green;", "blue;", "black;", "yellow;", "purple;", "red;", "orange;"};
        VBox left = new VBox();

        lab[0].setTextFill(Color.PURPLE);
        lab[1].setTextFill(Color.GREEN);
        lab[2].setTextFill(Color.ORANGE);
        lab[3].setTextFill(Color.RED);
        Rectangle rec1 = new Rectangle(100, 20);
        rec1.setFill(Color.BLUE);
        Rectangle rec2 = new Rectangle(100, 20);
        rec2.setFill(Color.PURPLE);

        left.setAlignment(Pos.CENTER);
        button.setAlignment(Pos.TOP_RIGHT);
        left.setPrefWidth(300);
        left.getChildren().addAll(lab[0], lab[1], lab[2], rec1, lab[3], rec2);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        mainGrid.getColumnConstraints().addAll(col1);

        mainGrid.setStyle("-fx-font-size: 24px;");
        mainGrid.add(left, 0, 0);
        mainGrid.add(button, 1, 0);
        mainGrid.setValignment(button, VPos.TOP);

        Random rand = new Random();
        button.addEventHandler(ActionEvent.ACTION, actionEvent -> {
            boolean value = rand.nextBoolean();
            if(value){
                Label newLabel = new Label(lab[rand.nextInt(7)].getText());
                newLabel.setStyle("-fx-text-fill: " + colors[rand.nextInt(7)]);
                left.getChildren().addAll(newLabel);
            } else {
                Rectangle newRec = new Rectangle(100, 20);
                newRec.setStyle("-fx-fill: " + colors[rand.nextInt(7)]);
                left.getChildren().addAll(newRec);
            }
            if(left.getChildren().size() == 11){
                left.getChildren().remove(0);
            }

        });
        return mainGrid;
    }

}