
import java.awt.*;
import java.awt.event.KeyEvent;

class Main{
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            // Step1 opening start menu
            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.keyRelease(KeyEvent.VK_WINDOWS);
            delay(1000); // half milli-second break to open stnuart me

            // Step2 open notepad
            typeString(robot, "notepad");
            pressEnter(robot);
            delay(1000); // enough time for notepad to open

            // Step3 typing "hello world" in notepad
            typeString(robot, "hello world");



        }catch (AWTException e){
            e.printStackTrace();
        }
    }




    public static void delay(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void typeString(Robot robot, String text){
        for(char c : text.toCharArray()){
            if(Character.isLetterOrDigit(c) || Character.isWhitespace(c)){
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
                delay(50);
            }
        }

    }

    public static void pressEnter(Robot robot){
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
