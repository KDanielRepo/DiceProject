import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

import java.util.concurrent.ThreadLocalRandom;

public class Dice extends AbstractDice {
    public Dice() {
        width = 500;
        height = 500;
        sides = 6;
    }

    public Dice(int width, int height ,int sides) {
        this.width = width;
        this.height = height;
        this.sides = sides;
        random();
        System.out.println(random);
        setOnAction(actionEvent ->{
            Canvas canvas = new Canvas(width,height);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            drawSides(gc,sides,random);
            Image image = canvas.snapshot(new SnapshotParameters(),new WritableImage(width,height));
            ImageView imageView = new ImageView(image);
            setGraphic(imageView);
            random();
        });
        fire();
        setPrefSize(width,height);
    }
    public int random(){
        random = ThreadLocalRandom.current().nextInt(1, sides+1);
        return random;
    }
}
