package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;

import javax.swing.JFrame;

import creatures.BouncingCreature;
import creatures.IEnvironment;
import creatures.visual.CreatureSimulator;
import creatures.visual.CreatureVisualizer;
import factory.AbstractCreatureFactory;
import factory.FactoryBouncingCreature;
import factory.FactorySmartCreature;
import factory.FactoryStupidCreature;

/**
 * Just a simple test of the simulator.
 * 
 */
@SuppressWarnings("serial")
public class Launcher extends JFrame {

	private final CreatureVisualizer visualizer;
	private final CreatureSimulator simulator;

	public Launcher() {
		simulator = new CreatureSimulator(new Dimension(640, 480));
		
		setName("Creature Simulator Test");
		setLayout(new BorderLayout());
		
		visualizer = new CreatureVisualizer(simulator);
		visualizer.setDebug(true);
		visualizer.setPreferredSize(simulator.getSize());
		add(visualizer, BorderLayout.CENTER);
		
		pack();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				exit(evt);
			}
		});
	}

	private void exit(WindowEvent evt) {
		System.exit(0);
	}

	public void init() {
		//simulator.getCreatures().add(new BouncingCreature(simulator, new Point2D.Double(0, 0), 3, 0, Color.BLUE));
		/* pattern Factory */
		//simulator.getCreatures().addAll(new FactorySmartCreature(simulator).createCreatures(simulator, new Point2D.Double(0, 0), 3, 0, Color.GREEN));
		//simulator.getCreatures().addAll(new FactoryStupidCreature(simulator).createCreatures(simulator, new Point2D.Double(0, 0), 6, 1, Color.GRAY));
		//simulator.getCreatures().addAll(new FactoryBouncingCreature(simulator).createCreatures(simulator, new Point2D.Double(0, 0), 9, 0, Color.BLUE));
		/* pattern Abstract Factory */
		simulator.getCreatures().addAll(new AbstractCreatureFactory(simulator).createCreatures(simulator, new Point2D.Double(0, 0), 9, 0));
		simulator.start();
	}
	
	public static void main(String args[]) {
		Launcher launcher = new Launcher();
		launcher.init();
		launcher.setVisible(true);
	}

}
