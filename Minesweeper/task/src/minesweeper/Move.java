package minesweeper;

import java.util.Scanner;

public class Move {

    private int x;
    private int y;
    private char moveSign = '*';
    Scanner scanner = new Scanner(System.in);
    private String str;

    void printOfferToMove() {

        System.out.print("Set/unset mines marks or claim a cell as free: ");
    }

    void inputCoordinate() {
        x = scanner.nextInt() - 1;
        y = scanner.nextInt() - 1;
    }

    void dataProcessing(PlayingField realField, PlayingField visibleField) {
        char inputCoordinate = visibleField.map[y][x];
        char inputCoordinateReal = realField.map[y][x];
        if (inputCoordinate > 48 && inputCoordinate < 57) { // если попадаем в числа
            System.out.println("There is a number here!");
        } else if (inputCoordinateReal == 'P') {
            visibleField.map[y][x] = visibleField.getEmpty();
            realField.map[y][x] = realField.getEmpty();
            visibleField.printMap();
        } else if (inputCoordinateReal == 'M') {
            visibleField.map[y][x] = moveSign;
            realField.map[y][x] = 'X';
            visibleField.printMap();
        } else {
            visibleField.map[y][x] = moveSign;
            realField.map[y][x] = 'P';
            visibleField.printMap();
        }
    }
}




