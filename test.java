import java.util.Scanner;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;


public class test {
    public static void main(String[] args) throws Exception {
        Rectangle rectangle = getScrSize(); //узнает размер экрана
        prtSize(rectangle);
        String filename = captureScr2(rectangle, System.currentTimeMillis()+"."+"png");
        //captureScr(rectangle);
        System.out.println("Screenshot saved as: " + filename);
        ImageDemo(filename);
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
    static void ImageDemo(final String filename) throws Exception{
        JFrame editorFrame = new JFrame("Image Demo");
        editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel jLabel = new JLabel();
        jLabel.setIcon(getImgIcon(filename));
        editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);

        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);
        editorFrame.getContentPane().add(BorderLayout.NORTH, mb);

        editorFrame.pack();
        editorFrame.setLocationRelativeTo(null);
        editorFrame.setResizable(false);
        editorFrame.setVisible(true);
      }

}
