import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Labeled;
import javafx.scene.image.ImageView;

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

    public Dice(int width, int height ,int sides) {
        this.width = width;
        this.height = height;
        this.sides = sides;
        setPrefSize(width,height);
        Canvas canvas = new Canvas(width,height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //ImageView imageView = new ImageView(canvas);
        drawSides(gc);
        //zoverriduj getStyleClass i getUserAgentStylesheet
    }
    public int random(){
        int random = ThreadLocalRandom.current().nextInt(1, sides+1);
        return random;
    }
}
