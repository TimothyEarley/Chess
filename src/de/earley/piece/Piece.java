package de.earley.piece;

import de.earley.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by timmy on 20/01/16.
 */
public abstract class Piece {

	protected Player player;
	protected BufferedImage image;

	public Piece(Player player, String black, String white) {
		this.player = player;

		String file = "res/pieces/" + ((player.equals(Player.BLACK)) ? black : white);
		try {
			image = ImageIO.read(new File(file));
		} catch (IOException e) {
			System.err.println("File: " + file);
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Checks the given move
	 * @param ox from this x
	 * @param oy from this y
	 * @param dx to this x
	 * @param dy to this y
	 * @param pieces with these pieces on the board
	 * @param player the belonging player
	 * @return true, if move is valid
	 */
	public abstract boolean isValidMove(int ox, int oy, int dx, int dy, Piece[][] pieces, Player player);

	public Player getPlayer() {
		return player;
	}

	public void paint(Graphics g, int x, int y, int width, int height) {
		int imageWidth = image.getWidth();
		int imageHeight = image.getHeight();
		float scale = width / (float) height < imageWidth / (float) imageHeight ? width / (float) imageWidth : height / (float) imageHeight;
		int scaledWidth = (int) (imageWidth * scale);
		int scaledHeight = (int) (imageHeight * scale);
		g.drawImage(image, x + (width - scaledWidth) / 2, y + (height - scaledHeight) / 2, scaledWidth, scaledHeight, null);
	}

	protected boolean checkPath(int ox, int oy, int dx, int dy, Piece[][] pieces) {
		int dirX = (int) Math.signum(dx - ox), dirY = (int) Math.signum(dy - oy);
		// check for collisions
		for (int xa = ox + dirX, ya = oy + dirY; xa != dx || ya != dy; xa += dirX, ya += dirY) {
			if (pieces[ya][xa] != null) {
				return false;
			}
		}
		return true;
	}
}
