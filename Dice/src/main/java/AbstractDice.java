import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.Skinnable;
import javafx.scene.paint.Color;

public abstract class AbstractDice extends Button {
    private int width;
    private int height;
    private int sides;
    public abstract int random();
    public void drawSides(GraphicsContext gc){
        gc.setFill(Color.CYAN);
        gc.setStroke(Color.VIOLET);
        gc.setLineWidth(5);
        gc.strokeRect(0,0,50,50);
    }

}
