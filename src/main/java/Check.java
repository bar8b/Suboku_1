import java.util.ArrayList;


//klasa:
// określa zakres sprawdzanego obszaru sudoku np linia, kolumna, box,
//sprawdza czy randomowa liczba znajduje się w kolumnie linii boxie
//

public class Check {

    protected boolean containValue(ArrayList<Integer> defineRange, int checkedValue) {

        boolean ifContain = false;

        if (defineRange.contains(checkedValue)) {
            ifContain = true;
        }
        return ifContain;
    }

    protected void addToList(ArrayList<Integer> defineRange, int checkedValue) {
        if (containValue(defineRange, checkedValue) == false) {
            defineRange.add(checkedValue);
        }
    }

}

