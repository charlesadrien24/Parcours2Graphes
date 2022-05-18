/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

import io.jbotsim.core.Color;
import io.jbotsim.core.Node;
import io.jbotsim.core.Topology;
import io.jbotsim.core.event.SelectionListener;
import io.jbotsim.ui.JTopology;
import io.jbotsim.ui.icons.Icons;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author clota
 */

public class MonApplication implements ActionListener, SelectionListener {
    Topology tp; // Objet qui contient le graphe
    JTopology jtp; // Composant graphique qui affiche le graphe
    Node source = null; 
    Node destination = null;
    public MonApplication() {
        // Création du graphe
        tp = new Topology();
        

        // Création de l'interface graphique (ci-dessous)
        creerInterfaceGraphique();
    }

    private void creerInterfaceGraphique() {
        // Création d'une fenêtre
        JFrame window = new JFrame("Mon application");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création du composant graphique qui affiche le graphe
        jtp = new JTopology(tp);
        window.add(jtp);

        // Création d'un bouton test
        JButton button = new JButton("Reset");
        window.add(button,BorderLayout.NORTH);
        
        // Céation d'un bouton
        JButton button2 = new JButton("Test2");
        window.add(button2, BorderLayout.SOUTH);

        // Abonnement aux évènements du bouton (clic, etc.)
        button.addActionListener(this);
        button2.addActionListener(this);
        tp.addSelectionListener(this);

        // Finalisation
        window.pack();
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Reset")) {
            JOptionPane.showMessageDialog(null, "Reset sélection sommet");
            source.setColor(null);
            source = null;
            destination.setIcon(null);
            destination = null;
            
            
        } else if(e.getActionCommand().equals("Test2")) {
            JOptionPane.showMessageDialog(null, "Bouton 2 cliqué");
        }
    }

    public static void main(String[] args) {
        new MonApplication();
    } 

    @Override
    public void onSelection(Node selectedNode) {
      if (source == null){
          source = selectedNode;
          source.setColor(Color.BLACK);
      } else if (destination == null) {
          destination = selectedNode;
          destination.setIcon(Icons.FLAG);
      }
    }
    
    public void ParcoursEnLargeur(Node UtilisateurNode, Topology Graphe) {

    }
}
