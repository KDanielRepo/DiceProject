import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public abstract class AbstractDice extends Button {
    protected int width;
    protected int height;
    protected int sides;
    protected boolean dots;
    protected int random;
    public abstract int random();
    public void drawSides(GraphicsContext gc,int sides, int random){
        gc.setFill(Color.CYAN);
        gc.setStroke(Color.VIOLET);
        gc.setLineWidth(5);
        int x=0;
        int y=-50;
        if(sides == 6){
            gc.strokeRect(0,0,width,height);
            gc.fillRect(0,0,width,height);
            gc.setFill(Color.GRAY);
            for(int i = 0; i < random; i++){
                if(i%2==0){
                    y+=((height/6)+50);
                    System.out.println(i);
                    System.out.println(y);
                    x=width/4-25;
                }
                x+=((width/2*(i%2)));
                gc.strokeOval(x,y,50,50);
                gc.fillOval(x,y,50,50);
            }
        }else if(sides == 4){
            gc.strokeLine(0,height,width,height);
            gc.strokeLine(0,height,width/2,0);
            gc.strokeLine(width/2,0,width,height);
            double[] a = new double[]{0.0,(double)width/2,0.0};
            double[] b = new double[]{(double)height,0.0,(double)height};
            gc.fillPolygon(a,b,3);
        }
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

}
