package ca.cmpt213.asn4.tictactoe.game;

import ca.cmpt213.asn4.tictactoe.ui.UserInterface;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * This is the main class where the application will start
 * @author Dennis Huynh
 * @author 3013279204
 */

public class TicTacToe extends Application {

    private static final int MAX_ROW=4;
    private static final int MAX_COL=4;
    private static GridData[][] gameBoard = new GridData[MAX_ROW][MAX_COL];

    @Override
    public void start(Stage primaryStage) throws Exception{

        UserInterface user = new UserInterface();
        GridPane grid = user.createGrid();
        Button button = user.createButton();
        Label label = user.createResultsLabel();

        VBox vBox = new VBox(20,user.createTitle(),grid,label,button);
        vBox.setAlignment(Pos.CENTER);


        Controller con = new Controller();
        con.initGameBoard(gameBoard);
        con.playGame(grid,gameBoard,label);
        con.newGame(button,grid,gameBoard,label);

        primaryStage.setTitle("TicTacToe");
        Scene scene = new Scene(vBox,400,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
