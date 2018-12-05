
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

class MyFrame extends JFrame {

  JLabel imgLabel;

  // constructor
  MyFrame( String title, int wsize, int hsize ) {
    super( title );                      // invoke the JFrame constructor
    setSize( wsize, hsize );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    this.imgLabel = new JLabel();
    CreateMenuBar();
    pack(); //устанавливет размер jframe достаточный для расположения всех элементов
    setLocationRelativeTo(null);
    setResizable(false);
  }

  private void CreateMenuBar() {
      JMenuBar menuBar = new JMenuBar();
      JMenu m1 = new JMenu("FILE");
      JMenu m2 = new JMenu("Help");
      menuBar.add(m1);
      menuBar.add(m2);
      JMenuItem m11 = new JMenuItem("Open");
      JMenuItem m22 = new JMenuItem("Save as");
      m1.add(m11);
      m1.add(m22);
      this.getContentPane().add(BorderLayout.NORTH, menuBar);
  }

  public void setImage(ImageIcon icon) {
      try {
      this.imgLabel.setIcon(icon);
      this.getContentPane().add(this.imgLabel, BorderLayout.CENTER);
    }
    catch (Exception e) {
        System.out.println("Error:" + " " + e);
    }
  }

}
