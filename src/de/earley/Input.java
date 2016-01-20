package de.earley;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by timmy on 20/01/16.
 */
public class Input extends MouseAdapter implements ComponentListener {

	private Game game;

	public Input(Game game) {
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		game.click(e.getX(), e.getY());
	}

	@Override
	public void componentResized(ComponentEvent e) {
		game.resized(e.getComponent().getWidth(), e.getComponent().getHeight());
	}

	@Override
	public void componentMoved(ComponentEvent e) {

	}

	@Override
	public void componentShown(ComponentEvent e) {

	}

	@Override
	public void componentHidden(ComponentEvent e) {

	}
}
