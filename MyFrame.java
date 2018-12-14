
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MyFrame extends JFrame {

  JLabel imgLabel;
  // JButton captureBtn;

  // constructor
  MyFrame( String title, int wsize, int hsize ) {
    super( title );                      // invoke the JFrame constructor
    MyWindowListener listener = new MyWindowListener();
    addWindowListener(listener);
    // addWindowListener(new WindowAdapter() {
    //     @Override
    //     public void windowClosing(WindowEvent e) {
    //             // Dispose the window after the close button is clicked.
    //             System.out.println("Closing...");
    //             dispose();
    //             System.out.println("Closed.");
    //             // Ask for confirmation before terminating the program.
    //             // int option = JOptionPane.showConfirmDialog(
    //             //         this,
    //             //         "Are you sure you want to close the application?",
    //             //         "Close Confirmation",
    //             //         JOptionPane.YES_NO_OPTION,
    //             //         JOptionPane.QUESTION_MESSAGE);
    //             // if (option == JOptionPane.YES_OPTION) {
    //             //         dispose();
    //             // }
    //
    //             }
    // });

    setSize( wsize, hsize );
    // setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    imgLabel = new JLabel();


    CreateMenuBar();
    CreateButtonBar();
    pack(); //устанавливет размер jframe достаточный для расположения всех элементов
    setLocationRelativeTo(null);
    setResizable(false);

  }

  class MyWindowListener extends WindowAdapter {
      // overrides only one method:
      public void windowClosing(WindowEvent event) {
          System.out.println("About to close the window");
          dispose();
      }
  }

  public class TestActionListener implements ActionListener {
            JFrame frame;
            TestActionListener (JFrame frame) {
                this.frame = frame;
            }
            public void actionPerformed(ActionEvent e) {
                // textField.setText(e.getActionCommand());
                String cmd = e.getActionCommand();

                switch (cmd) {
                    case "capture": System.out.println(cmd);
                                    break;

                    // case "exit": JOptionPane.showMessageDialog(this.frame, "Are yo sure? ");
                    case "exit":
                    int result = JOptionPane.showConfirmDialog(this.frame, "Are yo sure? ", "Exit?", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION)
                                frame.dispose();
                                break;
                }

            }
       }


  private void CreateButtonBar() {
      JPanel buttonBar = new JPanel();
      JButton captureBtn = new JButton("Capture");
      JButton exitBtn = new JButton("Exit");
      buttonBar.add(captureBtn);
      buttonBar.add(exitBtn);

      getContentPane().add(BorderLayout.SOUTH, buttonBar);

      captureBtn.setActionCommand("capture");
      exitBtn.setActionCommand("exit");


      ActionListener actionListener = new TestActionListener(this);
      captureBtn.addActionListener(actionListener);
      exitBtn.addActionListener(actionListener);


      // captureBtn.addActionListener(new ActionListener() {
      //
		// 	@Override
		// 	public void actionPerformed(ActionEvent arg0) {
		// 			System.out.println("Capture button pressed");
		// 	}
	  //     });
      // exitBtn.addActionListener(new ActionListener() {
      //
		// 	@Override
		// 	public void actionPerformed(ActionEvent arg0) {
		// 			System.out.println("Exit button pressed");
      //               // dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		// 	}
	  //     });
  }

  private void CreateMenuBar() {
      JMenuBar menuBar = new JMenuBar();
      JMenu m1 = new JMenu("File");
      JMenu m2 = new JMenu("Help");
      menuBar.add(m1);
      menuBar.add(m2);
      JMenuItem m11 = new JMenuItem("Open");
      JMenuItem m22 = new JMenuItem("Save as");
      m1.add(m11);
      m1.add(m22);
      getContentPane().add(BorderLayout.NORTH, menuBar);
  }

  public void setImage(ImageIcon icon) {
      try {
      imgLabel.setIcon(icon);
      getContentPane().add(imgLabel, BorderLayout.CENTER);
    }
    catch (Exception e) {
        System.out.println("Error:" + " " + e);
    }
  }

}
