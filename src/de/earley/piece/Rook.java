package de.earley.piece;

import de.earley.Player;

/**
 * Created by timmy on 20/01/16.
 */
public class Rook extends Piece {


	public Rook(Player player) {
		super(player, "Rook Black.png", "Rook White.png");
	}
	@Override
	public boolean isValidMove(int ox, int oy, int dx, int dy, Piece[][] pieces, Player player) {

		int absX = Math.abs(ox - dx);
		int absY = Math.abs(oy - dy);
		boolean straight = absX == 0 || absY == 0;

		return straight && checkPath(ox, oy, dx, dy, pieces);
	}
}
