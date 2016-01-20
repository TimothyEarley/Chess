package de.earley.piece;

import de.earley.Player;

/**
 * Created by timmy on 20/01/16.
 */
public class Pawn extends Piece {


	public Pawn(Player player) {
		super(player, "Pawn Black.png", "Pawn White.png");
	}

	@Override
	public boolean isValidMove(int ox, int oy, int dx, int dy, Piece[][] pieces, Player player) {
		float dir = 0, firstDir = 0;

		if (player.equals(Player.BLACK)) {
			dir = -1;
			firstDir = oy == 1 ? 2 * dir : dir;
		} else {
			dir = 1;
			firstDir = oy == 6 ? 2 * dir : dir;
		}

		boolean straight = (ox - dx == 0) && Math.signum(oy - dy) == Math.signum(firstDir) && Math.abs(oy - dy) <= Math.abs(firstDir);

		if (straight) {
			return pieces[dy][dx] == null && (oy - dir == dy || pieces[((int) (oy - dir))][dx] == null);
		}

		boolean oneToSide = Math.abs(ox - dx) == 1 && oy - dy == dir;
		return oneToSide && pieces[dy][dx] != null;


		//TODO: en passant

	}
}
