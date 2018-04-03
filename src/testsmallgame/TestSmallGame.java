/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsmallgame;
import javax.swing.JFrame;
import javax.swing.*;
/**
 *
 * @author teodora
 */
public class TestSmallGame extends JFrame{

   
    public static void main(String[] args) {
        JFrame gameboard = new JFrame("Tank Game");
        gameboard.setSize(500, 500);
        gameboard.setResizable(false);
        gameboard.setVisible(true);
        //f.setBackground(gray);
        //f.setContentPane(new JavaGame());
        gameboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
}
