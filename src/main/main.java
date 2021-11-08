/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author Elizabeth Stiles
 */
public class main {
    private static ImageIcon resize(ImageIcon img) {
    int h = img.getIconHeight();
    int w = img.getIconWidth();
    double newHeight = 400/((double)w/(double)h);
    img.setImage(img.getImage().getScaledInstance(400,(int)newHeight , 0));  
    return img;
    }
    static public void createAndShowGUI(){
        final JFrame frame = new JFrame("Elizabeth Stiles");
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("icon.png").getImage());
        final int MAX_IMG_COUNT = 5;
        ImageIcon[] inputImage = new ImageIcon[MAX_IMG_COUNT];
        ImageIcon[] outputImage = new ImageIcon[MAX_IMG_COUNT];
        JLabel[] imgLabel = new JLabel[MAX_IMG_COUNT];
       
        inputImage[0] = new ImageIcon("spacegroovenasus.jpg");
        outputImage[0] = resize(inputImage[0]);
        inputImage[1] = new ImageIcon("spacegrooveblitzcrank.jpg");
        outputImage[1] = resize(inputImage[1]);        
        inputImage[2] = new ImageIcon("projectmordekaiser.jpg");
        outputImage[2] = resize(inputImage[2]);        
        inputImage[3] = new ImageIcon("spiritblossomyasuo.jpg");
        outputImage[3] = resize(inputImage[3]);
        inputImage[4] = new ImageIcon("darkcosmicjhin.jpg");
        outputImage[4] = resize(inputImage[4]);
        
        imgLabel[0] = new JLabel(outputImage[0]);
        imgLabel[1] = new JLabel(outputImage[1]);
        imgLabel[2] = new JLabel(outputImage[2]);
        imgLabel[3] = new JLabel(outputImage[3]);
        imgLabel[4] = new JLabel(outputImage[4]);
       
        
        JPanel imagePanel = new JPanel( new GridLayout(0, 1));
        imagePanel.setBackground(Color.red);
        for (JLabel imgLabel1 : imgLabel) {
            imagePanel.add(imgLabel1);
        }
        JScrollPane scrollPane = new JScrollPane(imagePanel,      
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
        @Override
        protected void configureScrollBarColors() {
            this.thumbColor = Color.YELLOW;
            this.trackColor = Color.PINK;
        }
            @Override
        protected JButton createDecreaseButton(int orientation) {
            JButton button = super.createDecreaseButton(orientation);
            button.setBackground(Color.BLUE);
            return button;
        }
        @Override
        protected JButton createIncreaseButton(int orientation) {
            JButton button = super.createIncreaseButton(orientation);
            button.setBackground(Color.GREEN);
            return button;
        }
    });
        frame.getContentPane().add(scrollPane);
        }  
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {  
  
            public void run() {  
                createAndShowGUI();  
            }  
        });  
    }   
}
