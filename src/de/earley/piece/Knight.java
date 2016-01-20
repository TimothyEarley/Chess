package de.earley.piece;

import de.earley.Player;

/**
 * Created by timmy on 20/01/16.
 */
public class Knight extends Piece {


	public Knight(Player player) {
		super(player, "Knight Black.png", "Knight White.png");
	}

	@Override
	public boolean isValidMove(int ox, int oy, int dx, int dy, Piece[][] pieces, Player player) {

		int absX = Math.abs(ox - dx);
		int absY = Math.abs(oy - dy);

		return (absX == 1 && absY == 2) || (absX == 2 && absY == 1);
	}
}
