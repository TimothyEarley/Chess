package de.earley;

import javax.swing.*;
import java.awt.*;

/**
 * Created by timmy on 20/01/16.
 */
public class Game extends Canvas {

	private int width, height;
	private JFrame frame;
	private Board board;

	public Game(int width, int height) {

		this.width = width;
		this.height = height;

		this.board = new Board();
		setupFrame();

	}

	private void setupFrame() {
		frame = new JFrame("Chess");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);

		Input in = new Input(this);
		this.addMouseListener(in);
		this.addComponentListener(in);

		frame.add(this);
	}

	public void start() {
		frame.setVisible(true);
		int bar = frame.getInsets().top;
		frame.setSize(width, height + bar);
		System.out.println("Bar: " + bar); //TODO remove syso
		this.repaint();
	}

	public void click(int x, int y) {
		board.click(x * 8 / width, y * 8/ height);
		this.repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		board.paint(g, width, height);
	}

	public void resized(int width, int height) {
		this.width = width;
		this.height = height;
	}
}
