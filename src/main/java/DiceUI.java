import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DiceUI extends Application {
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(100,800);
        Dice dice = new Dice(400,400,6);
        FlowPane flowPane = new FlowPane();
        Button result = new Button("result");
        result.setOnAction(actionEvent ->{
            int a = 0;
            for(int i = 0; i<2;i++){
                dice.fire();
                a+=dice.getRandom();
                System.out.println(i+": "+dice.getRandom());
            }
            System.out.println(a);
        });
        flowPane.getChildren().add(result);

        borderPane.setCenter(dice);
        borderPane.setRight(flowPane);
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DiceProject");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(DiceUI.class,args);
    }
}
