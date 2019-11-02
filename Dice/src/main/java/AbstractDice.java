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
        switch (sides){
            case 4 :
                gc.strokeLine(0,height,width,height);
                gc.strokeLine(0,height,width/2,0);
                gc.strokeLine(width/2,0,width,height);
                double[] a = new double[]{0.0,width,(double)width/2};
                double[] b = new double[]{(double)height,height,0.0};
                gc.fillPolygon(a,b,3);
                gc.setFill(Color.GRAY);
                for(int i = 0; i < random; i++){
                    if(i==0){
                        x = width/2-25;
                        y = height/4;
                    }else{
                        x = (width/4-10)*i;
                        y = height-75;
                    }
                    gc.strokeOval(x,y,50,50);
                    gc.fillOval(x,y,50,50);
                }
                break;
            case 6 :
                gc.strokeRect(0,0,width,height);
                gc.fillRect(0,0,width,height);
                gc.setFill(Color.GRAY);
                for(int i = 0; i < random; i++){
                    if(i%2==0){
                        y+=((height/6)+50);
                        x=width/4-25;
                    }
                    x+=((width/2*(i%2)));
                    gc.strokeOval(x,y,50,50);
                    gc.fillOval(x,y,50,50);
                }
                break;
            case 8 :
                gc.strokeLine(0,height-height/4,width,height-height/4);
                gc.strokeLine(0,height-height/4,width/2,0);
                gc.strokeLine(width/2,0,width,height-height/4);
                //lewy gorny trojkat
                gc.strokeLine(0,height-height/4,0,height/4);
                gc.strokeLine(0,height/4,width/2,0);
                //prawy gorny trojkat
                gc.strokeLine(width,height-height/4,width,height/4);
                gc.strokeLine(width,height/4,width/2,0);
                //
                gc.strokeLine(0,height-height/4,width/2,height);
                gc.strokeLine(width/2,height,width,height-height/4);

                a = new double[]{0.0,width,(double)width/2};
                b = new double[]{(double)height-height/4,height-height/4,0.0};
                gc.fillPolygon(a,b,3);

                gc.setFill(Color.GRAY);
                for(int i = 0; i < random; i++){
                    if(i==0){
                        x = width/2-25;
                        y = height/4;
                    }else{
                        x = (width/4-10)*i;
                        y = height-75;
                    }
                    gc.strokeOval(x,y,50,50);
                    gc.fillOval(x,y,50,50);
                }
                break;
            case 10 :
                gc.strokeLine(width/6,height/2,width/2,height-height/4);
                gc.strokeLine(width/6,height/2,width/2,0);
                gc.strokeLine(width/2,height-height/4,width-width/6,height/2);
                gc.strokeLine(width-width/6,height/2,width/2,0);
                //
                gc.strokeLine(width/6,height/2,0,height/2);
                gc.strokeLine(0,height/2,0,height/3);
                gc.strokeLine(0,height/3,width/2,0);
                //
                gc.strokeLine(width-width/6,height/2,width,height/2);
                gc.strokeLine(width,height/2,width,height/3);
                gc.strokeLine(width,height/3,width/2,0);
                //
                gc.strokeLine(0,height/2,width/2,height);
                gc.strokeLine(width,height/2,width/2,height);
                break;
            case 12 :
                gc.strokeLine(width/20*6,height/20*7,width/2,height/20*4);
                gc.strokeLine(width/20*6,height/20*7,width/20*8,height/20*11);
                gc.strokeLine(width/2,height/20*4,width/20*14,height/20*7);
                gc.strokeLine(width/20*14,height/20*7,width/20*12,height/20*11);
                gc.strokeLine(width/20*8,height/20*11,width/20*12,height/20*11);
                break;
            case 20 :
                break;
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
