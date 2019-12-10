import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public abstract class AbstractDice extends Button {
    protected int width;
    protected int height;
    protected int dotWidth;
    protected int dotHeight;
    protected int sides;
    protected boolean dots;
    protected int random;
    public abstract int random();
    abstract void drawSides(GraphicsContext gc, int sides, int random);
    public void setDots(boolean dots){
        this.dots = dots;
    }
    public int getSides(){
        return sides;
    }
    public void setSides(int sides){
        this.sides = sides;
    }
    public int getRandom(){
        return random;
    }

}
