package javafxexamples;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Messenger extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Messenger");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 640, 480));
        primaryStage.show();
    }
    private Parent createInterface() {
        GridPane mainGridPain = new GridPane();

        TextField textField = new TextField();
        TextArea textArea = new TextArea();
        Button button = new Button("Послать");
        Label lab = new Label("Контакты");
        ListView<String> listView = new ListView<String>();

        VBox vb1 = new VBox();
        VBox vb2 = new VBox();
        HBox hb1 = new HBox();

        hb1.getChildren().addAll(textField, button);

        vb1.getChildren().addAll(textArea, hb1);
        vb2.getChildren().addAll(lab, listView);


        textArea.setMinHeight(350);

        textField.setMaxHeight(Double.MAX_VALUE);
        textField.setMaxWidth(Double.MAX_VALUE);
        textField.setMinWidth(380);
        textField.setAlignment(Pos.BOTTOM_LEFT);

        button.setMaxHeight(Double.MAX_VALUE);
        button.setMaxWidth(Double.MAX_VALUE);
        hb1.setMinHeight(130);
        vb1.setMaxWidth(440);
        vb2.setMaxWidth(150);
        listView.setMaxHeight(Double.MAX_VALUE);

        HBox hb = new HBox();
        hb.getChildren().addAll(vb1, vb2);

        hb.setMaxHeight(430);

        hb1.setAlignment(Pos.BOTTOM_RIGHT);
        hb1.setMaxHeight(200);

        mainGridPain.add(hb, 0, 0);

        return mainGridPain;
        }

    }
