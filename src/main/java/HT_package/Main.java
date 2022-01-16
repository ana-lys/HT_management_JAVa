/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package HT_package;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author AnaLys
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Login_frame Login_f = new Login_frame();
      Color nblue= new Color (150,250,250);
      Login_f.getContentPane().setBackground(nblue);
      Login_f.setVisible(true);
    
}

}