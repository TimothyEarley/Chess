package de.earley.piece;

import de.earley.Player;

/**
 * Created by timmy on 20/01/16.
 */
public class King extends Piece {


	public King(Player player) {
		super(player, "King Black.png", "King White.png");
	}

	@Override
	public boolean isValidMove(int ox, int oy, int dx, int dy, Piece[][] pieces, Player player) {
		// TODO: castle kingside, sacrifice
		boolean inRange = Math.abs(ox - dx) <= 1 && Math.abs(oy - dy) <= 1;
		return inRange;
	}
}
