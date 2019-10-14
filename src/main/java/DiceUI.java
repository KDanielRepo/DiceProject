import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DiceUI extends Application {
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(800,600);
        //FlowPane flowPane = new FlowPane();
        //flowPane.setPrefSize(borderPane.getWidth()/4,borderPane.getHeight()/5*4);
        Dice dice = new Dice(400,400,6);
        //flowPane.getChildren().add(dice);
        //borderPane.setCenter(flowPane);
        borderPane.setCenter(dice);
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DiceProject");
        primaryStage.show();
        for(int i = 0; i<100; i++){
            System.out.println(dice.random());
        }
    }

    public static void main(String[] args) {
        launch(DiceUI.class,args);
    }
}
