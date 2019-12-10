import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.concurrent.ThreadLocalRandom;

public class Dice extends AbstractDice {
    public Dice() {
        width = 500;
        height = 500;
        dotWidth = width/20;
        dotHeight = height/20;
        sides = 6;
    }

    public Dice(int width, int height ,int sides) {
        this.width = width;
        this.height = height;
        this.sides = sides;
        dotWidth = width/20;
        dotHeight = height/20;
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

    @Override
    void drawSides(GraphicsContext gc, int sides, int random) {
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

                a = new double[]{0.0,width-1,(double)width/2-1};
                b = new double[]{(double)height-height/4-1,height-height/4-1,0.0};
                gc.fillPolygon(a,b,3);

                gc.setFill(Color.DARKCYAN);
                a = new double[]{1.0,1.0,width/2};
                b = new double[]{(height/4)*3,height/4,0.0};
                gc.fillPolygon(a,b,3);

                a = new double[]{width-1,width-1,width/2-1};
                b = new double[]{(height/4)*3,height/4,0.0};
                gc.fillPolygon(a,b,3);

                a = new double[]{1.0,width,width/2};
                b = new double[]{(height/4)*3,(height/4)*3,height};
                gc.fillPolygon(a,b,3);

                gc.setFill(Color.GRAY);
                for(int i = 0; i < random; i++){
                    if(i==0){
                        x = width/2-dotWidth/2;
                        y = height/4;
                    }else if(i<4){
                        x = (width/4-dotWidth/4)*i;
                        y = height/2-dotHeight;
                    }else{
                        x = (width/4-dotWidth/2)*(i-3)-dotWidth*2;
                        y = height/2+dotHeight*2;
                    }
                    gc.strokeOval(x,y,dotWidth,dotHeight);
                    gc.fillOval(x,y,dotWidth,dotHeight);
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

                gc.setFill(Color.CYAN);
                a = new double[]{width/6,width/2,(width/6)*5,width/2};
                b = new double[]{height/2,0.0,height/2,(height/4)*3};
                gc.fillPolygon(a,b,4);

                gc.setFill(Color.DARKCYAN);
                a = new double[]{1.0,1.0,width/6,width/2};
                b = new double[]{height/3,height/2,height/2,1.0};
                gc.fillPolygon(a,b,4);

                a = new double[]{width-1,width-1,(width/6)*5,width/2};
                b = new double[]{height/3,height/2,height/2,1.0};
                gc.fillPolygon(a,b,4);

                a = new double[]{1.0,width/6,width/2,(width/6)*5,width-1,width/2};
                b = new double[]{height/2+2,height/2+2,(height/4)*3+2,height/2+2,height/2+2,height-1};
                gc.fillPolygon(a,b,6);

                gc.setFill(Color.GRAY);
                for(int i = 0; i < random; i++) {
                    if (i == 0) {
                        x = width / 2 - dotWidth / 2;
                        y = dotHeight*2;
                    } else if (i < 3) {
                        x = (width / 6 - dotWidth / 6) * 2*i;
                        y = dotHeight*6;
                    } else if(i<7){
                        x = (width / 6 - dotWidth / 6) * (i-2) + dotWidth +dotWidth/2;
                        y = height / 2 - dotHeight/2;
                    }else {

                    }
                    gc.strokeOval(x, y, dotWidth, dotHeight);
                    gc.fillOval(x, y, dotWidth, dotHeight);
                }
                break;
            case 12 :
                //double[] xx = new double[]{width/20*4,width/20*4,width/20*5,width/2,width/20*15,width/20*16,width/20*16,width/20*15,width/2,width/20*5};
                //double[] yy = new double[]{height/20*8,height/20*6,height/20*4,height/20*2,height/20*4,height/20*6,height/20*8,height/20*10,height/20*12,height/20*10};
                a = new double[]{width/2,width/20*4,width/20*2,width/20*2,width/20*4,width/2,width/20*16,width/20*18,width/20*18,width/20*16};
                b = new double[]{height/20*18,height/20*16,height/20*12,height/20*8,height/20*5,height/20*2,height/20*5,height/20*8,height/20*12,height/20*16};
                gc.strokePolygon(a,b,10);

                a = new double[]{width/2,width/20*5,width/20*5,width/2,width/20*15,width/20*15};
                b = new double[]{height/20*15,height/20*12,height/20*8,height/20*5,height/20*8,height/20*12};

                gc.strokePolygon(a,b,6);
                /*gc.strokeLine(width/20*6,height/20*7,width/2,height/20*4);
                gc.strokeLine(width/20*6,height/20*7,width/20*8,height/20*11);
                gc.strokeLine(width/2,height/20*4,width/20*14,height/20*7);
                gc.strokeLine(width/20*14,height/20*7,width/20*12,height/20*11);
                gc.strokeLine(width/20*8,height/20*11,width/20*12,height/20*11);*/
                break;
            case 20 :
                break;
        }
    }
}
