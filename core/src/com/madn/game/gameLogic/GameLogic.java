package com.madn.game.gameLogic;

/**
 * The internal representation for the game board.
 */
@SuppressWarnings("WeakerAccess")
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

    //checks whether a field already has a figure on it, sets that figure to its starting point and the new figure on the field
    public void kick (Figure figure, Field field){
        if(field.hasFigure()){
            field.getFigure().setField(null);   // TODO: Startfeld bestimmen
            figure.setField(field);
        }else{
            figure.setField(field);
        }
    }
}
