import javafx.scene.control.Labeled;

public abstract class AbstractDice extends Labeled {
    private int width;
    private int height;
    private int sides;
    public abstract int random();

}
