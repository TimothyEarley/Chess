package de.earley.piece;

import de.earley.Player;

/**
 * Created by timmy on 20/01/16.
 */
public class Queen extends Piece {


	public Queen(Player player) {
		super(player, "Queen Black.png", "Queen White.png");
	}

	@Override
	public boolean isValidMove(int ox, int oy, int dx, int dy, Piece[][] pieces, Player player) {

		int absX = Math.abs(ox - dx);
		int absY = Math.abs(oy - dy);
		boolean diagonal = absX == absY;
		boolean straight = absX == 0 || absY == 0;

		if (!diagonal && !straight) return false;

		return checkPath(ox, oy, dx, dy, pieces);
	}
}
