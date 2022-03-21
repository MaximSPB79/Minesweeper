package minesweeper;

import java.util.Random;
import java.util.Scanner;

public class Mine {

    private int numberOfMines;
    private int countMines = 0;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    void inputNumberOfMines() {
        System.out.print("How many mines do you want on the field? ");
        numberOfMines = scanner.nextInt();
    }
    void initMines(PlayingField visibleField,PlayingField realField) {

        while (numberOfMines > countMines) {
            int rowInit = random.nextInt(visibleField.getRow());
            int columnInit = random.nextInt(visibleField.getColumn());
            if (visibleField.map[rowInit][columnInit] == visibleField.getEmpty()) {
                visibleField.map[rowInit][columnInit] = visibleField.getMine();
                countMines++;
                realField.map[rowInit][columnInit] = 'M';
            }
        }
    }

}
