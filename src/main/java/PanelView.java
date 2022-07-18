//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.ColumnConstraints;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//
///**
// * Created by bnbur on 29.03.2022.
// */
//public class PanelView extends Application {
//    @Override
//    public void start(Stage primarySudoku) throws Exception {
//
//        GridPane siatka = new GridPane();
//        Scene sudoku = new Scene(siatka, 450, 450);
//
//        for (int boxRow = 0; boxRow <= 9; boxRow++){
//            for (int row = 0; row <9; row++) {
//                siatka.add(new TextField(), boxRow, row);;
//                siatka.getColumnConstraints().add(new ColumnConstraints());
//            }
//            boxRow++;
//        }
//        primarySudoku.setScene(sudoku);
//        primarySudoku.setTitle("Sudoku");
//        primarySudoku.show();
//    }
//}
//
