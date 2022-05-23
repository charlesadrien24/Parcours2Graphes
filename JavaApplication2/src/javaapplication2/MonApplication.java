/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

import io.jbotsim.ui.icons.Icons;
import io.jbotsim.core.Color;
import io.jbotsim.core.Node;
import io.jbotsim.core.Topology;
import io.jbotsim.core.event.SelectionListener;
import io.jbotsim.ui.JTopology;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author etd
 */
public class MonApplication implements ActionListener, SelectionListener{
    Topology tp; // Objet qui contient le graphe
    JTopology jtp;//composant graphique qui affiche le graphe
    Node source;
    Node destination;
    LinkedList<Node> cheminL;
    ArrayList<Node> obstacles;

    public MonApplication(){
        tp = new Topology(); // Composant graphique qui affiche le graphe
        tp.addSelectionListener(this);
        source = null;
        destination = null;
        cheminL = null;
        obstacles = new ArrayList<Node>();
        //creattion de l interface graphique
        creerInterfaceGraphique();
    }
    
    private void creerInterfaceGraphique(){
        //Création d une fenetre
        JFrame window = new JFrame("Mon application");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Création du composant graphique qui affiche le graphe
        jtp = new JTopology(tp);
        window.add(jtp);
        
        //Bouton visualisation parcours le plus cours
        JButton button = new JButton("Lance Parcours");
        window.add(button,BorderLayout.NORTH);
        
        //Bouton resr
        JButton button2 = new JButton("Reset");
        window.add(button2,BorderLayout.SOUTH);
        
        //Bouton visualisation de l'arbre
        JButton button3 = new JButton("Arbre");
        window.add(button3,BorderLayout.WEST);
        
        //Abonnement aux évènements du bouton
        button.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        
        //Finalisation
        window.pack();
        window.setVisible(true);
    
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MonApplication();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Lance Parcours")){
            JOptionPane.showMessageDialog(null, "Parcours lancé");
            if(source == null){
                JOptionPane.showMessageDialog(null, "!!! Pas de point source...");
            }
            else if(destination == null){
                JOptionPane.showMessageDialog(null, "!!! Pas de point de destination...");
            }
            else{
                HashMap<Node,Node> parcours = MonApplication.parcoursleplusrapide(tp, source, obstacles);
                cheminL = MonApplication.chemin(source, destination, parcours);
                if(cheminL != null){
                    cheminGras(cheminL,4);
                    JOptionPane.showMessageDialog(null, cheminInString(cheminL));
                }
                else{
                    JOptionPane.showMessageDialog(null, "!!! Le noeud source n'est pas connecté au graphe du noeud destination\n"
                            + "ou des obstacles empêchent de trouver la destination");
                }
                
            }
            
        }
        if (e.getActionCommand().equals("Arbre")){
            JOptionPane.showMessageDialog(null, "Visualisation de l'arbre");
            if(source == null){
                JOptionPane.showMessageDialog(null, "!!! Pas de point source...");
            }
            else if(destination == null){
                JOptionPane.showMessageDialog(null, "!!! Pas de point de destination...");
            }
            else{
            HashMap<Node,Node> parcours = MonApplication.parcoursEnLargeur(tp, source, obstacles);
            }
        }
        //Reset de la source et de la destination
        if(e.getActionCommand().equals("Reset")){
            //JOptionPane.showMessageDialog(null, "Ceci est un parcours en largeur");
            if(destination != null){
                destination.setIcon(Icons.DEFAULT_NODE_ICON);
                destination = null;
            }
            if(source != null){
                source.setColor(null);
                source = null;
            }
            if(cheminL != null){
                cheminGras(cheminL,1);
                cheminL = null;
            }
            for(Node n:obstacles){
                n.setIcon(Icons.DEFAULT_NODE_ICON);
            }
            for(Node n1:tp.getNodes()){
                for(Node n2:n1.getNeighbors()){
                    n1.getCommonLinkWith(n2).setWidth(1);
                }
            }
        }
    }
    /**
     * 
     * @param n 
     */
    @Override
    public void onSelection(Node n) {
        if(source == null){
            source = n;
            source.setColor(Color.black);
        }
        else if(destination == null){
            destination = n;
            destination.setIcon(Icons.FLAG);            
        }
        else
        {
            obstacles.add(n);
            n.setIcon(Icons.ROBOT);
        }
    }
    
    /**
     * Donne le tableau du parcours en largeur
     * 
     * @param Graphe le graphe
     * @param source le noeud source
     * @return HashMap<Node,Node> le tableau rempli
     * @author fvoneuw
     */
    static HashMap<Node,Node> parcoursEnLargeur(Topology Graphe, Node source, ArrayList<Node> obst){
        HashMap<Node,Node> parent = new HashMap<Node,Node>();
        LinkedList<Node> file= new LinkedList<Node>();
        file.add(source);
        parent.put(source, source);
        while(file.peek() != null){
            Node cnode = file.remove();
            for(Node nv:cnode.getNeighbors()){
                if(parent.get(nv) == null && !obst.contains(nv)){
                    parent.put(nv, cnode);
                    nv.getCommonLinkWith(parent.get(nv)).setWidth(4);
                    file.add(nv);
                }
            }
        }
        return parent;
        
    }
    /**
     * 
     * @param Graphe
     * @param source
     * @param obst
     * @return 
     */
    static HashMap<Node,Node> parcoursleplusrapide(Topology Graphe, Node source, ArrayList<Node> obst){
        HashMap<Node,Node> parent = new HashMap<Node,Node>();
        LinkedList<Node> file= new LinkedList<Node>();
        file.add(source);
        parent.put(source, source);
        while(file.peek() != null){
            Node cnode = file.remove();
            for(Node nv:cnode.getNeighbors()){
                if(parent.get(nv) == null && !obst.contains(nv)){
                    parent.put(nv, cnode);
                    file.add(nv);
                }
            }
        }
        return parent;
        
    }
    
    /**
     * Permet de trouver le chemin le plus cours d'un noeud source à destination
     * 
     * @param src le noeud source
     * @param dest le noeud destination
     * @param arbreLargeur le tableau avec le parcours en largeur
     * @return LinkedList<Node> la file comportant le chemin
     * @author fvoneuw
     */
    static LinkedList<Node> chemin(Node src, Node dest, HashMap<Node,Node> arbreLargeur){
        LinkedList<Node> cheminCourt = new LinkedList<Node>();
        cheminCourt.add(dest);
        Node cnode = dest;
        //faire le chemin de Source à Destination
        while(!cnode.equals(src)){
            Node child = cnode;
            cnode = arbreLargeur.get(cnode);
            cheminCourt.add(cnode);
            if(cnode == null){
                return null;
            }
        }
        return cheminCourt;
    }
    
    /**
     * Met le chemin du parcours en largeur à la taille width
     * 
     * @param chemin le chemin associé au parcours en largeur
     * @param width la taille donné aux arêtes du chemin
     * @author fvoneuw
     */
    private void cheminGras(LinkedList<Node> chemin, int width){
        int i = 0;
        while(!chemin.getLast().equals(chemin.get(i))){
            chemin.get(i).getCommonLinkWith(chemin.get(i+1)).setWidth(width);
            i++;
        }
    }
    
    /**
     * Permet de générer le texte associé aux noeuds reliés dans le chemin
     * 
     * @param chemin le chemin du parcours en largeur
     * @author fvoneuw
     */
    private String cheminInString(LinkedList<Node> chemin){
        String message = "";
        for(Node n:chemin){
            message = n.getID() + "; " + message;
        }
        return "Noeuds liés : \n" + message;
    }

    
    
}
