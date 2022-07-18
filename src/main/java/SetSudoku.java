import java.util.ArrayList;
import java.util.Random;

/**
 * Created by bnbur on 23.05.2022.
 */
public class SetSudoku {
    public static void main(String[] args) {

        int counter = 0;
        int[][] sudokuToComplite = zeroSudoku();

        int x = indexX(counter);
        int y = indexY(counter);
        int sudoku[][];

        comparison(boxRange(x, y, sudokuToComplite), rowRange(y,
                sudokuToComplite), columnRange(x, sudokuToComplite));

        for (int i = 0; i <= 80; i++) {

            sudoku = addRNrToSudoku(x, y, sudokuToComplite);
            counter++;
            x = indexX(counter);
            y = indexY(counter);
            sudokuToComplite = sudoku;
        }

        for (int tx[] : sudokuToComplite) {
            for (int ty : tx) {
                System.out.print(ty + " ");
            }
            System.out.println();
        }
    }


    static int[][] zeroSudoku() {
        int[][] zeroSudoku = new int[9][9];
        return zeroSudoku;
    }

    static int indexX(int counter) {
        int x = counter % 9;
        return x;
    }

    static int indexY(int counter) {
        int y = counter / 9;
        return y;
    }

    static int[] index(int index) {
        int[] indexRange = new int[2];

        if (index <= 2) {
            indexRange[0] = 0;
            indexRange[1] = 2;
        } else if (index > 2 && index <= 5) {
            indexRange[0] = 3;
            indexRange[1] = 5;
        } else if (index > 5 && index <= 8) {
            indexRange[0] = 6;
            indexRange[1] = 8;
        }
        return indexRange;
    }

    static ArrayList<Integer> boxRange(int indexX, int indexY, int[][] sudokuToComplite) {
        ArrayList<Integer> boxList = new ArrayList<>();

        int[] rangex = index(indexX);
        int[] rangey = index(indexY);

        for (int x = rangex[0]; x <= rangex[1]; x++) {
            for (int y = rangey[0]; y <= rangey[1]; y++) {
                int value = sudokuToComplite[x][y];
                boxList.add(value);
            }
        }
        return boxList;
    }

    static ArrayList<Integer> columnRange(int indexX, int[][] sudokuToComplite) {
        ArrayList<Integer> columnList = new ArrayList<>();

        for (int y = 0; y <= 8; y++) {
            columnList.add(sudokuToComplite[indexX][y]);

        }
        return columnList;
    }

    static ArrayList<Integer> rowRange(int indexY, int[][] sudokuToComplite) {
        ArrayList<Integer> rowList = new ArrayList<>();

        for (int x = 0; x <= 8; x++) {
            rowList.add(sudokuToComplite[x][indexY]);
        }
        return rowList;
    }

    static int comparison(ArrayList<Integer> columnRange, ArrayList<Integer> boxRange,
                          ArrayList<Integer> rowRange) {

        int randomNumber;
        ArrayList<Integer> randomList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 1; i <= 9; i++) {
            randomList.add(i);
        }

        do {
            int randomElementList = randomList.get(rand.nextInt(randomList.size()));
            randomNumber = randomElementList;
            randomList.remove(randomList.indexOf(randomElementList));
            if (randomList.size() == 0) {
                break;
            }
        } while (columnRange.contains(randomNumber) || boxRange.contains(randomNumber) || rowRange.contains(randomNumber));

        return randomNumber;
    }

    static int[][] addRNrToSudoku(int indexX, int indexY, int[][] sudokuToComplite) {
        int numberToProvide = comparison(boxRange(indexX, indexY, sudokuToComplite), rowRange(indexY,
                sudokuToComplite), columnRange(indexX, sudokuToComplite));
        sudokuToComplite[indexX][indexY] = numberToProvide;
        return sudokuToComplite;
    }
}