/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package javaapplication2;

import io.jbotsim.core.Node;
import io.jbotsim.core.Topology;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author clota
 */
public class MonApplicationTest {
    
    public MonApplicationTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class MonApplication.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MonApplication.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class MonApplication.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        MonApplication instance = new MonApplication();
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onSelection method, of class MonApplication.
     */
    @Test
    public void testOnSelection() {
        System.out.println("onSelection");
        Node n = null;
        MonApplication instance = new MonApplication();
        instance.onSelection(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parcoursEnLargeur method, of class MonApplication.
     */
    @Test
    public void testParcoursEnLargeur() {
        System.out.println("parcoursEnLargeur");
        Topology Graphe = null;
        Node source = null;
        ArrayList<Node> obst = null;
        HashMap<Node, Node> expResult = null;
        HashMap<Node, Node> result = MonApplication.parcoursEnLargeur(Graphe, source, obst);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parcoursleplusrapide method, of class MonApplication.
     */
    @Test
    public void testParcoursleplusrapide() {
        System.out.println("parcoursleplusrapide");
        Topology Graphe = null;
        Node source = null;
        ArrayList<Node> obst = null;
        HashMap<Node, Node> expResult = null;
        HashMap<Node, Node> result = MonApplication.parcoursleplusrapide(Graphe, source, obst);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chemin method, of class MonApplication.
     */
    @Test
    public void testChemin() {
        System.out.println("chemin");
        Node src = null;
        Node dest = null;
        HashMap<Node, Node> arbreLargeur = null;
        LinkedList<Node> expResult = null;
        LinkedList<Node> result = MonApplication.chemin(src, dest, arbreLargeur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
