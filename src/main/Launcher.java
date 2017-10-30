package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;

import javax.swing.JFrame;

import creatures.BouncingCreature;
import creatures.visual.CreatureSimulator;
import creatures.visual.CreatureVisualizer;

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
		simulator.getCreatures().add(new BouncingCreature(simulator, new Point2D.Double(0, 0), 3, 0, Color.BLUE));
		simulator.start();
	}
	
	public static void main(String args[]) {
		Launcher launcher = new Launcher();
		launcher.init();
		launcher.setVisible(true);
	}

}
