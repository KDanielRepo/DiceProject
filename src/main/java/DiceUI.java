import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DiceUI extends Application {
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(100,800);

        FlowPane flowPane = new FlowPane();

        Dice dice = new Dice(400,400,4);

        borderPane.setCenter(dice);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DiceProject");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(DiceUI.class,args);
    }
}
