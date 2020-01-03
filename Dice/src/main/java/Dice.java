import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Dice extends AbstractDice {
    public Dice() {
        width = 500;
        height = 500;
        dotWidth = width/20;
        dotHeight = height/20;
        sides = 6;
        sideColor = Color.CYAN;
        dotColor = Color.GRAY;
        lineColor = Color.VIOLET;
    }

    public Dice(int width, int height ,int sides) {
        this.width = width;
        this.height = height;
        this.sides = sides;
        dotWidth = width/20;
        dotHeight = height/20;
        random();
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
    public Dice(int width, int height, int sides, Color sideColor, Color dotColor, Color lineColor){
        this.width = width;
        this.height = height;
        this.sides = sides;
        this.sideColor = sideColor;
        this.dotColor = dotColor;
        this.lineColor = lineColor;
        dotWidth = width/20;
        dotHeight = height/20;
        random();
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
        gc.setFill(sideColor);
        gc.setStroke(lineColor);
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
                gc.setFill(dotColor);
                for(int i = 0; i < random; i++){
                    if(i==0){
                        x = width/2-dotWidth/2;
                        y = height/4;
                    }else{
                        x = (width/4)*i - dotWidth/2;
                        y = height-dotHeight * 2;
                    }
                    if(dots){
                        gc.strokeOval(x,y,dotWidth,dotHeight);
                        gc.fillOval(x,y,dotWidth,dotHeight);
                    }else{
                        gc.setFont(new Font(width/4));
                        gc.strokeText(Integer.toString(random),width/2-(gc.getFont().getSize()/4),height/2+(gc.getFont().getSize()/4));
                    }
                }
                break;
            case 6 :
                gc.strokeRect(0,0,width,height);
                gc.fillRect(0,0,width,height);
                gc.setFill(dotColor);
                for(int i = 0; i < random; i++){
                    if(i%2==0){
                        y+=dotHeight*6 + dotHeight;
                        x=(width/4)-(dotWidth/2);
                    }
                    x+=((width/2*(i%2)));
                    if(dots){
                        gc.strokeOval(x,y,dotWidth,dotHeight);
                        gc.fillOval(x,y,dotWidth,dotHeight);
                    }else{
                        gc.setFont(new Font(width/4));
                        gc.strokeText(Integer.toString(random),width/2-(gc.getFont().getSize()/4),height/2+(gc.getFont().getSize()/4));
                    }
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

                a = new double[]{3.0,width-3,(double)width/2};
                b = new double[]{(double)height-height/4,height-height/4,3.0};
                gc.fillPolygon(a,b,3);

                gc.setFill(sideColor);//zamien tu na ciemniejszy
                a = new double[]{0.0,3.0,width/2-3};
                b = new double[]{(height/4)*3,height/4,3.0};
                gc.fillPolygon(a,b,3);

                a = new double[]{width-3,width-3,width/2+3};
                b = new double[]{(height/4)*3-3,height/4-3,3.0};
                gc.fillPolygon(a,b,3);

                a = new double[]{3.0,width-3,width/2};
                b = new double[]{(height/4)*3+2,(height/4)*3+2,height-2};
                gc.fillPolygon(a,b,3);

                gc.setFill(dotColor);
                if(dots){
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
                }else{
                    gc.setFont(new Font(width/4));
                    gc.strokeText(Integer.toString(random),width/2-(gc.getFont().getSize()/4),height/2+(gc.getFont().getSize()/4));
                }
                break;
            case 10 :
                gc.strokeLine(width/6,height/2,width/2,height-height/4);
                gc.strokeLine(width/6,height/2,width/2,0);
                gc.strokeLine(width/2,height-height/4,width-width/6,height/2);
                gc.strokeLine((width/6)*5,height/2,width/2,0);
                //
                gc.strokeLine(width/6,height/2,0,height/2);
                gc.strokeLine(0,height/2,0,height/3);
                gc.strokeLine(0,height/3,width/2,0);
                //
                gc.strokeLine((width/6)*5,height/2,width,height/2);
                gc.strokeLine(width,height/2,width,height/3);
                gc.strokeLine(width,height/3,width/2,0);
                //
                gc.strokeLine(0,height/2,width/2,height);
                gc.strokeLine(width,height/2,width/2,height);

                gc.setFill(sideColor);
                a = new double[]{width/6+3,width/2,(width/6)*5,width/2};
                b = new double[]{height/2,3.0,height/2,(height/4)*3-2};
                gc.fillPolygon(a,b,4);

                gc.setFill(sideColor);
                a = new double[]{1.0,1.0,width/6,width/2};
                b = new double[]{height/3,height/2,height/2,1.0};
                gc.fillPolygon(a,b,4);

                a = new double[]{width-1,width-1,(width/6)*5,width/2};
                b = new double[]{height/3,height/2,height/2,1.0};
                gc.fillPolygon(a,b,4);

                a = new double[]{1.0,width/6,width/2,(width/6)*5,width-1,width/2};
                b = new double[]{height/2+2,height/2+2,(height/4)*3+2,height/2+2,height/2+2,height-1};
                gc.fillPolygon(a,b,6);

                gc.setFill(dotColor);
                if(dots){
                    for(int i = 0; i < random; i++) {
                        if (i == 0) {
                            x = width / 2 - dotWidth / 2;
                            y = dotHeight*2;
                        } else if (i < 4) {
                            x = (width / 6 - dotWidth / 6) * (i+1);
                            y = dotHeight*6;
                        } else if(i<8){
                            x = (width / 6 - dotWidth / 6) * (i-2) - dotWidth - dotWidth/2; //+ dotWidth +dotWidth/2;
                            y = height / 2 - dotHeight/2;
                        }else {
                            x = (width / 6 - dotWidth / 6) * (i-5) - dotWidth - dotWidth/2;
                            y = height/2 + dotHeight*2;
                        }
                        gc.strokeOval(x, y, dotWidth, dotHeight);
                        gc.fillOval(x, y, dotWidth, dotHeight);
                    }
                }else{
                    gc.setFont(new Font(width/4));
                    gc.strokeText(Integer.toString(random),width/2-(gc.getFont().getSize()/4),height/2+(gc.getFont().getSize()/4));
                }
                break;
            case 12 :
                a = new double[]{width/2,width/20*2,0,0,width/20*2,width/2,width/20*18,width,width,width/20*18,width/2};
                b = new double[]{0,height/20*4,height/20*8,height/20*12,height/20*16,height,height/20*16,height/20*12,height/20*8,height/20*4,0};
                gc.strokePolygon(a,b,10);
                gc.fillPolygon(a,b,10);

                a = new double[]{width/2,width/20*4,width/20*6,width/20*14,width/20*16,width/2};
                b = new double[]{height/20*3,height/20*7,height/20*14,height/20*14,height/20*7,height/20*3};

                gc.strokePolygon(a,b,6);

                gc.strokeLine(width/2,0,width/2,height/20*3);
                gc.strokeLine(0,height/20*8,width/20*4,height/20*7);
                gc.strokeLine(width,height/20*8,width/20*16,height/20*7);
                gc.strokeLine(width/20*2,height/20*16,width/20*6,height/20*14);
                gc.strokeLine(width/20*18,height/20*16,width/20*14,height/20*14);

                gc.setFill(dotColor);
                if(dots){
                    for(int i = 0; i < random; i++) {
                        if (i == 0) {
                            x = width / 2 - dotWidth / 2;
                            y = dotHeight*4;
                        } else if (i < 4) {
                            x = (dotWidth*5) + ((dotWidth *2) *i) + dotWidth/2;//x = (width / 6 - dotWidth / 6) * (i+1);
                            y = dotHeight*6;
                        } else if(i<8){
                            x = (dotWidth*6) + ((dotWidth*2) *(i-4)) + dotWidth/2;//x = (width / 6 - dotWidth / 6) * (i-2) - dotWidth - dotWidth/2; //+ dotWidth +dotWidth/2;
                            y = dotHeight*8;
                        }else{
                            x = (dotWidth*5) + ((dotWidth*2) *(i-7)) - dotWidth/2;
                            y = dotHeight * 10;
                        }
                        gc.strokeOval(x, y, dotWidth, dotHeight);
                        gc.fillOval(x, y, dotWidth, dotHeight);
                    }
                }else{
                    gc.setFont(new Font(width/4));
                    gc.strokeText(Integer.toString(random),width/2-(gc.getFont().getSize()/4),height/2+(gc.getFont().getSize()/4));
                }
                break;
            case 20 :
                a = new double[]{width/2,0,0,width/2,width,width,width/2};
                b = new double[]{0,height/20*6,height/20*14,height,height/20*14,height/20*6,0};
                gc.strokePolygon(a,b,7);
                gc.fillPolygon(a,b,7);

                a = new double[]{width/2,width/20*2,width/20*18,width/2};
                b = new double[]{height/20*6,height/20*14,height/20*14,height/20*6};

                gc.strokePolygon(a,b,4);

                gc.strokeLine(0,height/20*6,width,height/20*6);
                gc.strokeLine(0,height/20*6,width/20*2,height/20*14);
                gc.strokeLine(width,height/20*6,width/20*18,height/20*14);
                gc.strokeLine(width/2,height,width/20*2,height/20*14);
                gc.strokeLine(width/2,height,width/20*18,height/20*14);
                gc.strokeLine(0,height/20*14,width/20*2,height/20*14);
                gc.strokeLine(width,height/20*14,width/20*18,height/20*14);

                gc.setFill(dotColor);
                if(dots){
                    for(int i = 0; i < random; i++) {
                        if (i == 0) {
                            x = width / 2 - dotWidth / 2;
                            y = dotHeight*7;
                        } else if (i < 5) {
                            x = (dotWidth*6) + ((dotWidth + dotWidth/2) *i) - dotWidth/2;//x = (width / 6 - dotWidth / 6) * (i+1);
                            y = dotHeight*9;
                        } else if(i<12){
                            x = (dotWidth*4) + ((dotWidth + dotWidth/2) *(i-4)) - dotWidth/2;//x = (width / 6 - dotWidth / 6) * (i+1);
                            y = dotHeight*11;
                        }else{
                            x = (dotWidth*2) + ((dotWidth + dotWidth/2) *(i-11)) + dotWidth/2;//x = (width / 6 - dotWidth / 6) * (i+1);
                            y = dotHeight*12 + dotHeight/2;
                        }
                        gc.strokeOval(x, y, dotWidth, dotHeight);
                        gc.fillOval(x, y, dotWidth, dotHeight);
                    }
                }else{
                    gc.setFont(new Font(width/4));
                    gc.strokeText(Integer.toString(random),width/2-(gc.getFont().getSize()/2),height/2+(gc.getFont().getSize()/2));
                }
                break;
        }
    }
}
