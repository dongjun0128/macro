import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.concurrent.TimeUnit;

class key implements KeyListener{
    @Override
    public void keyPressed(KeyEvent e2) {
    }

    @Override
    public void keyTyped(KeyEvent e2) {}
    public void keyReleased(KeyEvent e2){ }

}


public class Main extends JFrame {
    JFrame frame = new JFrame("매크로");
    Button btn1 = new Button("Start");
    Button btn2 = new Button("End");
    JPanel contentPane = new JPanel();

    ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
    	Image ximg=icon.getImage();
    	Image yimg=ximg.getScaledInstance(i,j,java.awt.Image.SCALE_SMOOTH);
    	ImageIcon xyimg = new ImageIcon(yimg);
    	return xyimg;
    }
    
    public void creatFrame(){
        frame.getContentPane().setLayout(null);

        btn1.setBounds(30,200,122,30);
        btn2.setBounds(182,200,122,30);

        contentPane = new JPanel();
        contentPane.setBackground(Color.white);
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        contentPane.add(btn1);
        contentPane.add(btn2);

        ImageIcon [] images = {new ImageIcon("images/picture1.png"), new ImageIcon("images/picture2.png")};
        
        images[0]=imageSetSize(images[0],135,135);
        
        JLabel imgLabel = new JLabel(images[0]);
        Container c = getContentPane();
        c.setLayout(getLayout());
        c.add(imgLabel);
        
        frame.setContentPane(contentPane);
        frame.setSize(350,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void buttonAction(Button btn1, Button btn2){
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Robot robot = new Robot();
                    int i = 0;
                    while(i<10){
                        i++;
                        robot.keyPress(32);
                        System.out.println("실행");
                        TimeUnit.SECONDS.sleep(1);
                    }
                }
                catch (Exception e1){
                    System.out.println(e1);
                }

            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("bnt2 눌림");
            }
        });

    }

    public static void main(String[] args) {
        Main mainFrame = new Main();
        mainFrame.creatFrame();
        mainFrame.buttonAction(mainFrame.btn1, mainFrame.btn2);
    }
}
