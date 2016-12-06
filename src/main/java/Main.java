import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Created by Rustam on 02.12.16.
 */
public class Main {
    public static void main(String[] args) {
        boolean isLeft = false;


        try {
            Robot robot = new Robot();
            Color bedColor = robot.getPixelColor(328, 173);//картинка 335 179
            Color left;
            Color rigth;
            while (true) {
                try {
                    Thread.sleep(300);


                    while (isLeft) {
                        left = robot.getPixelColor(1146, 260);//левая сторона 1146 263
                        if (left.equals(bedColor)) {//if (bedColor(bedColor, true)){
                            isLeft = false;
                        }
                        else{
                            robot.keyPress(KeyEvent.VK_LEFT);
                            Thread.sleep(300);
                        }

                    }

                    while (!isLeft) {
                        rigth = robot.getPixelColor(1265, 262);//правая сторона 1261 264
                        if (rigth.equals(bedColor)) {//if (bedColor(bedColor, false)){
                            isLeft = true;
                        }
                        else{
                            robot.keyPress(KeyEvent.VK_RIGHT);
                            Thread.sleep(300);
                        }

                    }




//                    robot.mousePress(InputEvent.BUTTON1_MASK);
//                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
//            // Simulate a key press
//
//            robot.keyPress(KeyEvent.VK_A);
//
//            robot.keyRelease(KeyEvent.VK_A);

                Point location = MouseInfo.getPointerInfo().getLocation();
                double x = location.getX();
                double y = location.getY();

                System.out.println("x = " + x);
                System.out.println("y = " + y);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static boolean bedColor(Color bedColor, boolean isLeft){
        Color color;
        Robot robot = null;
        try {
            robot = new Robot();


        if(isLeft){
            if(robot.getPixelColor(1146, 260) == bedColor || robot.getPixelColor(1146, 265) == bedColor || robot.getPixelColor(1146, 270) == bedColor||
                    robot.getPixelColor(1146, 255) == bedColor || robot.getPixelColor(1146, 250) == bedColor){
                return true;
            }
            else {
                return false;
            }
        }
        if(!isLeft){
            if(robot.getPixelColor(1265, 262) == bedColor || robot.getPixelColor(1265, 267) == bedColor || robot.getPixelColor(1265, 272) == bedColor||
                    robot.getPixelColor(1265, 257) == bedColor || robot.getPixelColor(1265, 252) == bedColor){
                return true;
            }
            else {
                return false;
            }

        }
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return true;
    }

}
