import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.Setter;


public abstract class AbstractDice extends Button {
    protected int width;
    protected int height;
    protected int dotWidth;
    protected int dotHeight;
    protected int sides;
    protected boolean dots;
    protected int random;
    protected Color sideColor;
    protected Color lineColor;
    protected Color dotColor;
    public abstract int random();
    abstract void drawSides(GraphicsContext gc, int sides, int random);

    public Color getLineColor() {
        return lineColor;
    }
    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }
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
    public Color getSideColor() {
        return sideColor;
    }
    public void setSideColor(Color sideColor) {
        this.sideColor = sideColor;
    }
    public Color getDotColor() {
        return dotColor;
    }
    public void setDotColor(Color dotColor) {
        this.dotColor = dotColor;
    }
    public int getDotWidth() {
        return dotWidth;
    }

    public void setDotWidth(int dotWidth) {
        this.dotWidth = dotWidth;
    }

    public int getDotHeight() {
        return dotHeight;
    }

    public void setDotHeight(int dotHeight) {
        this.dotHeight = dotHeight;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    public boolean isDots() {
        return dots;
    }
}
