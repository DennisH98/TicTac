package ca.cmpt213.asn4.tictactoe.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * This class handles a majority of the user interface
 * @author Dennis Huynh
 * @author 3013279204
 */

public class UserInterface {
    public GridPane createGrid(){
        GridPane grid = new GridPane();


        for(int i =0;i<4;i++){

            for (int j=0 ;j<4; j++){
                grid.add(new ImageView(new Image("file:images/Emptyimg.jpg")),i,j);
            }

        }
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10));
        grid.setAlignment(Pos.CENTER);



        return grid;

    }

    public Button createButton(){

       Button newGame = new Button("New Game");
       return newGame;
    }

    public Label createResultsLabel(){
        Label label = new Label("It is X's turn!");
        return label;
    }

    public Label createTitle(){
        Label label = new Label("TIC TAC TOE GAME \n by Dennis Huynh");
        return label;
    }




}
