package TicTac;

public class Board {
    private char[][] field = { { '+', '+', '+' }, { '+', '+', '+' }, { '+', '+', '+' } };

    public void displayField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();

        }
    }

    public boolean setField(int x, int y, char player) {
        if (x > 4 || x < 1 || y > 4 || y < 1) {
            return false;
        } else {
            for (int i = 1; i < field.length + 1; i++) {
                for (int j = 1; j < field[i - 1].length + 1; j++) {
                    if (((i == y) && (j == x) && field[i - 1][j - 1] == '+')) {
                        field[i - 1][j - 1] = player;
                        return true;
                    }
                }
            }
            return false;
        }

    }

    public char checkGame() {
        char winner = ' ';

        for (int i = 0; i < 3; i++) {
            if (field[i][0] == field[i][1] && field[i][1] == field[i][2] && field[i][0] != '+') {
                winner = field[i][0];
                break;
            }
        }

        if (winner == ' ') {
            for (int i = 0; i < 3; i++) {
                if (field[0][i] == field[1][i] && field[1][i] == field[2][i] && field[0][i] != '+') {
                    winner = field[0][i];
                    break;
                }
            }
        }

        if (winner == ' ') {
            if (field[0][0] == field[1][1] && field[1][1] == field[2][2] && field[0][0] != '+') {
                winner = field[0][0];
            }
        }

        if (winner == ' ') {
            if (field[0][2] == field[1][1] && field[1][1] == field[2][0] && field[0][2] != '+') {
                winner = field[0][2];
            }
        }
        return winner;
    }

    public boolean canMove() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == '+') {
                    return true;
                }

            }

        }
        return false;
    }

    public void clearBoard() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = '+';

            }

        }
    }

    public char[][] getField() {
        return field;
    }

    public void setBoard(char[][] save) {
        field = save;
    }
    
    public void CompMove(char player) {
        int x = (int) (Math.random() * 3), y = (int) (Math.random() * 3);
        while (field[x][y] == '0' || field[x][y] == 'x') {
            x = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);
        }
        field[x][y] = player;
    }

}
