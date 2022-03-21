package minesweeper;

public class Main {


    public static void main(String[] args) {

        play();

    }

    private static void play() {
        PlayingField visibleField = new PlayingField();
        PlayingField realField = new PlayingField();
        Mine mine = new Mine();
        Move move = new Move();

        fieldPreparation(visibleField, realField, mine);

        gameProcess(visibleField, realField, move);
    }


    private static void fieldPreparation(PlayingField visibleField, PlayingField realField, Mine mine) {
        mine.inputNumberOfMines(); // вводим количество мин
        visibleField.initMap(); // инициализируем поле
        realField.initMap();
        mine.initMines(visibleField, realField); // расставляем мины
        visibleField.countingTheNumberMines(visibleField);// выводим подсказки
        visibleField.hideMine(); // прячем мины
        visibleField.printMap(); // выводим игровое поле
    }

    private static void gameProcess(PlayingField visibleField, PlayingField realField, Move move) {
        while (checkForVictory(realField)) {
            move.printOfferToMove(); // предлагаем ввести координаты
            move.inputCoordinate(); // вводим координаты
            move.dataProcessing(realField, visibleField);
        }
        System.out.println("Congratulations! You found all mines!");
    }

    private static boolean checkForVictory(PlayingField realField) {
        for (int i = 0; i < realField.getRow(); i++) {
            for (int j = 0; j < realField.getColumn(); j++) {
                if (realField.map[i][j] == 'M' || realField.map[i][j] == 'P') {
                    return true;
                }
            }
        }
        return false;
    }
}
