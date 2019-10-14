import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DiceUI extends Application {
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(800,600);
        Dice dice = new Dice(100,100,"test",6);
        borderPane.getChildren().add(dice);
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
