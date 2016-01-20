package de.earley;

import de.earley.piece.*;

import java.awt.*;

import static de.earley.Player.BLACK;
import static de.earley.Player.WHITE;

/**
 * Created by timmy on 20/01/16.
 */
public class Board {

	private static Color
			highlight = new Color(0xff, 0xff, 0xff, 0x99),
			valid = new Color(0x55, 0xff, 0x99, 0x99),
			tile1 = new Color(0xff, 167, 109, 0xff),
			tile2 = new Color(154, 90, 16, 0xff);

	private Piece[][] pieces = new Piece[8][8];

	private Player player;
	private boolean hasSelected;
	private int ox, oy;

	public Board() {
		pieces[0] = new Piece[]{
				new Rook(BLACK),
				new Knight(BLACK),
				new Bishop(BLACK),
				new Queen(BLACK),
				new King(BLACK),
				new Bishop(BLACK),
				new Knight(BLACK),
				new Rook(BLACK)};
		pieces[1] = new Piece[]{
				new Pawn(BLACK),
				new Pawn(BLACK),
				new Pawn(BLACK),
				new Pawn(BLACK),
				new Pawn(BLACK),
				new Pawn(BLACK),
				new Pawn(BLACK),
				new Pawn(BLACK),
		};
		pieces[7] = new Piece[]{
				new Rook(WHITE),
				new Knight(WHITE),
				new Bishop(WHITE),
				new King(WHITE),
				new Queen(WHITE),
				new Bishop(WHITE),
				new Knight(WHITE),
				new Rook(WHITE)};
		pieces[6] = new Piece[]{
				new Pawn(WHITE),
				new Pawn(WHITE),
				new Pawn(WHITE),
				new Pawn(WHITE),
				new Pawn(WHITE),
				new Pawn(WHITE),
				new Pawn(WHITE),
				new Pawn(WHITE),
		};


		player = WHITE;
		ox = oy = -1;
	}

	/**
	 * @param x in tiles
	 * @param y in tiles
	 */
	public void click(int x, int y) {
		if (isValid(x, y)) {
				// win condition
				// ...
				// move
				pieces[y][x] = getSelected();
				pieces[oy][ox] = null;
				hasSelected = false;
				ox = oy = -1;
				player = player.equals(Player.WHITE) ? BLACK : WHITE;
		} else {
			select(x, y);
		}


	}

	private void select(int x, int y) {
		if (pieces[y][x] != null && pieces[y][x].getPlayer().equals(player)) {
			ox = x;
			oy = y;
			hasSelected = true;
		} else {
			ox = oy = -1;
			hasSelected = false;
		}
	}

	public void paint(Graphics g, int width, int height) {
		int pieceWidth = width / 8;
		int pieceHeight = height / 8;
		for (int x = 0; x < pieces.length; x++) {
			int xa = x * pieceWidth;
			for (int y = 0; y < pieces[x].length; y++) {
				int ya = y * pieceHeight;
				// Background
				if (x % 2 != y % 2) g.setColor(tile1);
					// Normal
				else g.setColor(tile2);
				g.fillRect(xa, ya, pieceWidth, pieceHeight);

				// Piece
				if (pieces[y][x] != null)
					pieces[y][x].paint(g, xa, ya, pieceWidth, pieceHeight);

				// Highlight
				if (x == ox && y == oy) {
					g.setColor(highlight);
					g.fillRect(xa, ya, pieceWidth, pieceHeight);
				}

				// Valid
				g.setColor(valid);
				if (getSelected() != null) {
					if (isValid(x, y)) {
						g.fillRect(xa, ya, pieceWidth, pieceHeight);
					}
				}
				// DEBUG
//				g.setColor(Color.WHITE);
//				g.drawString(x + ", " + y, xa + pieceWidth/2, ya + pieceHeight/2);
			}
		}
	}

	private boolean isValid(int x, int y) {
		return
				hasSelected
						&& getSelected() != null
						&& (
						pieces[y][x] == null
						|| pieces[y][x].getPlayer() != getSelected().getPlayer()
						)
						&& pieces[oy][ox].isValidMove(ox, oy, x, y, pieces, player);
	}

	public Piece getSelected() {
		if (ox < 0 || oy < 0 || ox >= 8 || oy >= 8) return null;
		return pieces[oy][ox];
	}
}
