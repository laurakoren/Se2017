package com.madn.game.gameLogic;

/**
 * The internal representation for the game board.
 */
public class GameLogic {
    private LinkedFieldCircle boardPath;

    public GameLogic() {
        this.boardPath = new LinkedFieldCircle();
        boardPath.getFirst().setFigure(new Figure());
    }

    // TODO: spiellogik bauen

    /**
     * Moves a figure for a given distance over the board. Returns true if the move is valid and was executed and returns false else. If false is returned, the board remains unchanged.
     *
     * @param figure   the piece to move
     * @param distance the distance to move it
     * @return true on success, false on failure
     */
    public boolean draw(Figure figure, int distance) {
        if (figure == null || distance < 0)
            return false;

        // TODO: züge ermöglichen
        // TODO: collision detection

        return true;
    }
}
