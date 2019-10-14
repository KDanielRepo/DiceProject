import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Labeled;

import java.util.concurrent.ThreadLocalRandom;

public class Dice extends AbstractDice {
    private int width;
    private int height;
    private int sides;

    public Dice() {
        width = 100;
        height = 100;
        sides = 6;
    }

    public Dice(int width, int height, String text,int sides) {
        this.width = width;
        this.height = height;
        setText(text);
        this.sides = sides;
        getStylesheets().add(getClass().getResource("diceskin.css").toExternalForm());
        getStyleClass().setAll("CustomSkin");
        //zoverriduj getStyleClass i getUserAgentStylesheet
    }
    public int random(){
        int random = ThreadLocalRandom.current().nextInt(1, sides+1);
        return random;
    }
}
