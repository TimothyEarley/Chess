package de.earley.piece;

import de.earley.Player;

/**
 * Created by timmy on 20/01/16.
 */
public class Bishop extends Piece {

	public Bishop(Player player) {
		super(player, "Bishop Black.png", "Bishop White.png");
	}

	@Override
	public boolean isValidMove(int ox, int oy, int dx, int dy, Piece[][] pieces, Player player) {

		int absX = Math.abs(ox - dx);
		int absY = Math.abs(oy - dy);
		boolean diagonal = absX == absY;

		return diagonal && checkPath(ox, oy, dx, dy, pieces);
	}
}
