package minesweeper;

public class PlayingField {

    private final int row = 9;
    private final int column = 9;
    private final char mine = 'X';
    private final char empty = '.';
    char[][] map = new char[row][column];

    public void setMap(char[][] map) {
        this.map = map;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getMine() {
        return mine;
    }

    public char getEmpty() {
        return empty;
    }

    void initMap() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                map[i][j] = empty;
            }
        }
    }


    void printMap() {
        printHeaderMap();
        for (int i = 0; i < row; i++) {
            char n = (char) (i + 49);
            System.out.print(n + "|");
            for (int j = 0; j < column; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("|");
        }
        turningField();
    }

    private void printHeaderMap() {
        System.out.print(" |");
        for (int i = 0; i < column; i++) {
            printNumberMap(i);
        }
        System.out.print("| \n");
        turningField();
    }

    private void printNumberMap(int i) {

        System.out.print(i + 1);
    }

    private void turningField() {
        System.out.println("-|---------|");
    }

    void countingTheNumberMines(PlayingField field) {
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (field.map[i][j] == empty) {
                    cellProcessing(field, i, j, count);
                }
            }
        }
    }

    private void cellProcessing(PlayingField field, int i, int j, int count) {
        for (int k = i - 1; k <= i + 1 && k < 9; k++) {
            for (int l = j - 1; l <= j + 1 && l < 9; l++) {
                if (k < 0 || l < 0) {
                    continue;
                } else if (field.map[k][l] == mine) {
                    count++;
                }
            }
        }
        if (count != 0) {
            field.map[i][j] = (char) (count + 48);
        }
    }

    void hideMine() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j] == mine) {
                    map[i][j] = empty;
                }
            }

        }
    }
}



