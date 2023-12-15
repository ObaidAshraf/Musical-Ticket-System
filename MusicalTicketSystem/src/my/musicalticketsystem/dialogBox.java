/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.musicalticketsystem;
import javax.swing.JOptionPane;

/**
 * @brief A class to show Dialogbox
 * @author Administrator
 */
public class dialogBox {
    
    /**
     * @biref Method to display dialogbox
     * @param msg 
     */
    public void show_dialog(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error", 1);
    }
}
