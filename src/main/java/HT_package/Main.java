/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package HT_package;
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
     Main_frame Main_f = new Main_frame();
      Login_f.setVisible(true);
      Boolean  b = true ,blast =true ;
      while(b ){
       
      if(!Login_f.isDisplayable()){
       Main_f.setVisible(true);
      b=false;}
      blast = Login_f.isDisplayable();
    }
    
}

}