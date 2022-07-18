//import java.util.ArrayList;
//import java.util.Random;
//
//public class ListSudoku extends Check {
//
//    public static void main(String[] args) {
//
//        int[][] jockersudoku;
//        jockersudoku = emptySudoku2D();
//        int randomNumber = randomNumber();
//
//        addValueToSudoku(jockersudoku, randomNumber);
//
////wyświetlanie sudoku
//
//        for (int[] y : jockersudoku) {
//            for (int x : y) {
//                System.out.print(x + " ");
//            }
//            System.out.println();
//        }
//
//    }
//
////metoda addValueToSudoku rekurencja
//
//    private static void addValueToSudoku(int[][] sudoku, int randomNumber) {
//        for (int j = 8; j >= 0; j--) {
//            for (int i = 8; i >= 0; i--) {
//                if (checkingAllAssertsContainValue(i, j, sudoku, randomNumber)) {
//                    addValueToSudoku(sudoku, randomNumber);
//                    sudoku[i][j] = randomNumber;
//                }
//            }
//        }
//    }
//
//
//    //sprawdzanie i dodawanie zmiennych do Arraylist
//    private static boolean checkingAllAssertsContainValue(int i, int j, int[][] jockersudoku, int randomNumber) {
//        LBox LBox = new LBox(i, j, jockersudoku, randomNumber);
//        LRow LRow = new LRow(i, jockersudoku, randomNumber);
//        LColumn LColumn = new LColumn(j, jockersudoku, randomNumber);
//
//        if (!LBox.containValue()) {
//            if (!LRow.containValue()) {
//                if (!LColumn.containValue()) {
//                    LBox.addToList();
//                    LRow.addToList();
//                    LColumn.addToList();
//                } else {
//                    return true;
//                }
//            } else {
//                return true;
//            }
//        } else {
//            return true;
//        }
//        return false;
//    }
//
//    public static int randomNumber() {
//        Random random = new Random();
//        int min = 1;
//        int max = 9;
//        int x = random.nextInt(max) + min;
//        return x;
//    }
//
//
//    private static int[][] emptySudoku2D() {
//        int[][] box = new int[9][9];
//
//        for (int x = 0; x <= 8; x++) {
//
//            for (int y = 0; y <= 8; y++) {
//                box[x][y] = 0;
//            }
//        }
//        return box;
//    }
//
//}
//
//class LBox extends Check {
//    int x;
//    int y;
//    int[][] jockersudoku;
//    int checkedValue;
//
//    public LBox(int x, int y, int[][] jockersudoku, int checkedValue) {
//        this.x = x;
//        this.y = y;
//        this.jockersudoku = jockersudoku;
//        this.checkedValue = checkedValue;
//    }
//
//    public static int[] rangeIndexY(int y) {
//        int[] indexY;
//        if (y <= 2) {
//            indexY = new int[]{0, 1, 2};
//        } else if (2 < y || y == 5) {
//            indexY = new int[]{3, 4, 5};
//        } else {
//            indexY = new int[]{6, 7, 8};
//        }
//        return indexY;
//    }
//
//    public static int[] rangeIndexX(int x) {
//        int[] indexX;
//        if (x <= 2) {
//            indexX = new int[]{0, 1, 2};
//        } else if (2 < x || x == 5) {
//            indexX = new int[]{3, 4, 5};
//        } else {
//            indexX = new int[]{6, 7, 8};
//        }
//        return indexX;
//    }
//
//    public static ArrayList<Integer> defineRange(int x, int y, int[][] jockersudoku) {
//
//        int[][] sudoku;
//        sudoku = jockersudoku;
//        int[] indexX, indexY;
//        indexX = rangeIndexX(x);
//        int ix0 = indexX[0];
//        int ix1 = indexX[1];
//        int ix2 = indexX[2];
//        indexY = rangeIndexY(y);
//        int iy0 = indexY[0];
//        int iy1 = indexY[1];
//        int iy2 = indexY[2];
//        ArrayList<Integer> xIndex = new ArrayList<>();
//        xIndex.add(0, ix0);
//        xIndex.add(1, ix1);
//        xIndex.add(2, ix2);
//        ArrayList<Integer> yIndey = new ArrayList<>();
//        yIndey.add(0, iy0);
//        yIndey.add(1, iy1);
//        yIndey.add(2, iy2);
//
//        ArrayList<Integer> box = new ArrayList<>();
//
//        int a, b;
//        for (int j = 0; j < 3; j++) {
//            for (int i = 0; i < 3; i++) {
//                a = xIndex.get(i);
//                b = yIndey.get(j);
//
//                int v = sudoku[a][b];
//                box.add(v);
//            }
//        }
//        return box;
//    }
//
//    public boolean containValue() {
//        return super.containValue(defineRange(x, y, jockersudoku), checkedValue);
//    }
//
//    public void addToList() {
//        super.addToList(defineRange(x, y, jockersudoku), checkedValue);
//    }
//
//}
//
//class LRow extends Check {
//    int x;
//    int[][] jockersudoku;
//    int checkedValue;
//    ArrayList<Integer> defineRange = new ArrayList<>();
//
//    public LRow(int x, int[][] jockersudoku, int checkedValue) {
//        this.x = x;
//        this.jockersudoku = jockersudoku;
//        this.checkedValue = checkedValue;
//    }
//
//    public ArrayList<Integer> defineRange(int x) {
//        this.x = x;
//        int workInt;
//
//        for (int i = 8; i == 0; i--) {
//            workInt = jockersudoku[x][i];
//            defineRange.add(x, workInt);
//        }
//        return defineRange;
//    }
//
//    public boolean containValue() {
//        return super.containValue(defineRange(x), checkedValue);
//
//    }
//
//    public void addToList() {
//        super.addToList(defineRange(x), checkedValue);
//    }
//
//}
//
//class LColumn extends Check {
//    int y;
//    int[][] jockersudoku;
//    int checkedValue;
//    ArrayList<Integer> defineRange = new ArrayList<>();
//
//    public LColumn(int y, int[][] jockersudoku, int checkedValue) {
//        this.y = y;
//        this.jockersudoku = jockersudoku;
//        this.checkedValue = checkedValue;
//    }
//
//    //To tu jest problem
//    public ArrayList<Integer> defineRange(int y) {
//        this.y = y;
//        int workInt;
//
//        for (int i = 8; i == 0; i--) {
//            workInt = jockersudoku[i][y];
//            defineRange.add(y, workInt);
//        }
//        return defineRange;
//    }
//
//    public boolean containValue() {
//        return super.containValue(defineRange(y), checkedValue);
//    }
//
//    public void addToList() {
//        super.addToList(defineRange(y), checkedValue);
//    }
//
//}