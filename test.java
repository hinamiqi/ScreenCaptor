import java.util.Scanner;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

// import screen.screen.*;


public class test {
    static int wsize = 600;
    static int hsize = 400;

    public static void main(String[] args) throws Exception {
        Rectangle rectangle = getScrSize(); //узнает размер экрана
        prtSize(rectangle);
        // String filename = captureScr2(rectangle, System.currentTimeMillis()+"."+"png");
        String filename = captureScr2(rectangle, "screenshot"+"."+"png");
        //captureScr(rectangle);
        System.out.println("Screenshot saved as: " + filename);
        ImageDemo(getImgIcon(filename));
    }

    static void userInput() { //выводит на экран пользовательский ввод
        Scanner newInput = new Scanner(System.in);
        System.out.println(newInput.nextLine());
    }

    static Rectangle getScrSize() { //возвращаеет объект Rectangle размером польз. экрана
        Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit()
            .getScreenSize());
        return(rectangle);
    }

    static void prtSize(Rectangle rectangle){ //выводит размеры переданного объекта Rectangle
        int[] result = {rectangle.height, rectangle.width};
        System.out.println(result[0] + "x" + result[1]);
    }

//делает снимок экрана размером переданного Rectangle и сохраняет как filename в PNG
    static String captureScr2(Rectangle rectangle, String filename) throws Exception {
        /*Robot robot = new Robot();
        BufferedImage img = robot.createScreenCapture(rectangle);*/

        BufferedImage img = new Robot().createScreenCapture(rectangle);
        ImageIO.write(img, "png", new File(filename));
        return(filename);
    }

//считывает изображение из filename и возвращает иконку width х height
    static ImageIcon getImgIcon(String filename) throws Exception{
        BufferedImage image = null;
        try
        {
          image = ImageIO.read(new File(filename));
        }
        catch (Exception e)
        {
          e.printStackTrace();
          System.exit(1);
        }
        ImageIcon imageIcon = new ImageIcon(image);
        int width = 600;
        int height = 400;
        Image img = imageIcon.getImage().getScaledInstance(width,height,java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);

        return scaledIcon;
    }
//рисует форму с иконкой картинки, полученной из filename
    static void ImageDemo(ImageIcon icon) throws Exception{

        MyFrame frame = new MyFrame("Testing...", wsize, hsize);
        frame.setVisible(true);
        frame.setImage(icon);
        frame.pack();

      }

}
