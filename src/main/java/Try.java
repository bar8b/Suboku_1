import java.util.ArrayList;
import java.util.Random;

/**
 * Created by bnbur on 19.04.2022.
 */
public class Try {
    public static void main(String[] args) {

        int y = 0;
        int jockersudoku[][] = new int[9][9];
        jockersudoku[0][0] = 7;

        int workInt;
        ArrayList<Integer> defineRange = new ArrayList<>();
        for (int i = 8; i >=0; i--) {
            workInt = jockersudoku[i][y];
            defineRange.add(y, workInt);
        }
        System.out.println(defineRange);

    }
}
