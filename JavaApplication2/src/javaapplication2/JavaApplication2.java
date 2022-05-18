/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;
import io.jbotsim.core.Topology;
import io.jbotsim.ui.JViewer;
/**
 *
 * @author clota
 */
public class JavaApplication2 {

  
    public static void main(String[] args){
        Topology tp = new Topology();
        new JViewer(tp);
        tp.start();
    }
}
