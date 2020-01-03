import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class DiceUI extends Application {
    public void start(Stage primaryStage) throws Exception {
        //odpal kilka instancji z roznymi parametrami
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(1200,1000);
        VBox vBox = new VBox();
        Dice dice = new Dice(200,200,4,Color.CYAN,Color.GRAY,Color.BLACK);
        Dice dice2 = new Dice(200,200,6, Color.DARKGREEN,Color.DARKMAGENTA,Color.BLACK);
        Dice dice3 = new Dice(200,200,10,Color.GREEN,Color.DARKORANGE,Color.BLACK);
        vBox.getChildren().addAll(dice,dice2,dice3);
        VBox vBox2 = new VBox();
        Dice dice4 = new Dice(200,200,12,Color.BLUE,Color.LIGHTGRAY,Color.BLACK);
        Dice dice5 = new Dice(200,200,20,Color.PURPLE,Color.WHITE,Color.BLACK);
        vBox2.getChildren().addAll(dice4,dice5);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(vBox,vBox2);

        VBox controls = new VBox();
        Label label = new Label("Wybierz kość: ");

        ComboBox dye = new ComboBox();
        List<Integer> number = new ArrayList<>();
        number.add(1);
        number.add(2);
        number.add(3);
        number.add(4);
        number.add(5);
        ObservableList<Integer> dyeNumber = FXCollections.observableArrayList(number);
        dye.setItems(dyeNumber);

        List<Color> colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.MAGENTA);
        colors.add(Color.GRAY);
        colors.add(Color.CYAN);
        colors.add(Color.DARKORANGE);
        colors.add(Color.DARKORANGE);
        colors.add(Color.BLACK);
        colors.add(Color.DARKMAGENTA);
        ObservableList<Color> colors1 = FXCollections.observableArrayList(colors);
        Label scLabel = new Label("wybierz kolor ścian: ");
        ComboBox sideColors = new ComboBox();
        sideColors.setItems(colors1);

        Label dcLabel = new Label("wybierz kolor Kropek: ");
        ComboBox dotColors = new ComboBox();
        dotColors.setItems(colors1);

        Label lcLabel = new Label("wybierz kolor Kresek: ");
        ComboBox lineColors = new ComboBox();
        lineColors.setItems(colors1);

        Button dots = new Button("numbers");
        dots.setOnAction(actionEvent->{
            if(dice.isDots()){
                dice.setDots(false);
                dice2.setDots(false);
                dice3.setDots(false);
                dice4.setDots(false);
                dice5.setDots(false);
                dots.setText("numbers");
            }else{
                dice.setDots(true);
                dice2.setDots(true);
                dice3.setDots(true);
                dice4.setDots(true);
                dice5.setDots(true);
                dots.setText("dots");
            }
        });

        controls.getChildren().addAll(label,dye,scLabel,sideColors,dcLabel,dotColors,lcLabel,lineColors,dots);

        Button result = new Button("result");
        result.setOnAction(actionEvent ->{
            int a = 0;
            for(int i = 0; i<2;i++){
                switch (dye.getSelectionModel().getSelectedIndex()){
                    case 0:
                        dice.fire();
                        dice.setSideColor((Color) sideColors.getSelectionModel().getSelectedItem());
                        dice.setDotColor((Color) dotColors.getSelectionModel().getSelectedItem());
                        dice.setLineColor((Color) lineColors.getSelectionModel().getSelectedItem());
                        break;
                    case 1:
                        dice2.fire();
                        dice2.setSideColor((Color) sideColors.getSelectionModel().getSelectedItem());
                        dice2.setDotColor((Color) dotColors.getSelectionModel().getSelectedItem());
                        dice2.setLineColor((Color) lineColors.getSelectionModel().getSelectedItem());
                        break;
                    case 2:
                        dice3.fire();
                        dice3.setSideColor((Color) sideColors.getSelectionModel().getSelectedItem());
                        dice3.setDotColor((Color) dotColors.getSelectionModel().getSelectedItem());
                        dice3.setLineColor((Color) lineColors.getSelectionModel().getSelectedItem());
                        break;
                    case 3:
                        dice4.fire();
                        dice4.setSideColor((Color) sideColors.getSelectionModel().getSelectedItem());
                        dice4.setDotColor((Color) dotColors.getSelectionModel().getSelectedItem());
                        dice4.setLineColor((Color) lineColors.getSelectionModel().getSelectedItem());
                        break;
                    case 4:
                        dice5.fire();
                        dice5.setSideColor((Color) sideColors.getSelectionModel().getSelectedItem());
                        dice5.setDotColor((Color) dotColors.getSelectionModel().getSelectedItem());
                        dice5.setLineColor((Color) lineColors.getSelectionModel().getSelectedItem());
                        break;
                }
            }
        });

        borderPane.setTop(result);
        borderPane.setRight(controls);
        //flowPane.getChildren().add(result);
        borderPane.setCenter(hBox);
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DiceProject");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(DiceUI.class,args);
    }
}
