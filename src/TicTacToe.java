public class TicTacToe {
    String[][] field;
    String nowPlayer;

    public TicTacToe() {

        newGame();
    }

    void newGame() {

        field = new String[][]{{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
        nowPlayer = "X";
    }

    String[][] getField() {
        return field;
    }

    String makeMove(int x, int y) {
        x -= 1;
        y -= 1;

        String check = this.checkGame();


        if (check != null) return "Game was ended";


        if (!field[x][y].equals("-")) return "Cell " + (x + 1) + ", " + (y + 1) + " is already occupied";


        field[x][y] = nowPlayer;
        check = checkGame();


        if (check != null) {
            if (check.equals("X")) return "Player X won";
            else if (check.equals("0")) return "Player 0 won";
            else return "Draw";
        }


        nowPlayer = nowPlayer.equals("X") ? "0" : "X";
        return "Move completed";
    }

    String checkGame() {

        for (int i = 0; i < 3; i++) {
            boolean check = true;
            for (int j = 0; j < 3; j++) {
                if (field[i][j].equals("0") || field[i][j].equals("-")) check = false;
            }
            if (check) return "X";
        }

        for (int i = 0; i < 3; i++) {
            boolean check = true;
            for (int j = 0; j < 3; j++) {
                if (field[i][j].equals("X") || field[i][j].equals("-")) check = false;
            }
            if (check) return "0";
        }


        for (int i = 0; i < 3; i++) {
            boolean check = true;
            for (int j = 0; j < 3; j++) {
                if (field[j][i].equals("0") || field[j][i].equals("-")) check = false;
            }
            if (check) return "X";
        }

        for (int i = 0; i < 3; i++) {
            boolean check = true;
            for (int j = 0; j < 3; j++) {
                if (field[j][i].equals("X") || field[j][i].equals("-")) check = false;
            }
            if (check) return "0";
        }



        String[] diagonal = {field[0][0], field[1][1], field[2][2]};
        String[] diagonal2 = {field[0][2], field[1][1], field[2][0]};

        boolean check = true;
        for (int i = 0; i < 3; i++) {
            if (diagonal[i].equals("0") || diagonal[i].equals("-")) check = false;
        }
        if (check) return "X";
        else {
            check = true;
            for (int i = 0; i < 3; i++) {
                if (diagonal[i].equals("X") || diagonal[i].equals("-")) check = false;
            }
            if (check) return "0";
        }


        check = true;
        for (int i = 0; i < 3; i++) {
            if (diagonal2[i].equals("0") || diagonal2[i].equals("-")) check = false;
        }
        if (check) return "X";
        else {
            check = true;
            for (int i = 0; i < 3; i++) {
                if (diagonal2[i].equals("X") || diagonal2[i].equals("-")) check = false;
            }
            if (check) return "0";
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j].equals("-")) return null;
            }
        }
        return "D";
    }
}