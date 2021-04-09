package ca.cmpt213.asn4.tictactoe.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * This class handles the logic of the game and the event handlers for the Nodes
 * @author Dennis Huynh
 * @author 3013279204
 */


public class Controller {
    private int turn=0;

    public void initGameBoard(GridData[][] board){
        for (int i =0;i<4;i++){
            for(int j=0;j<4;j++){
                board[i][j] =GridData.EMPTY;
            }
        }

    }

    public void newGame(Button button, GridPane g, GridData[][] resetBoard,Label label){
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for (Node node: g.getChildren()){
                    ((ImageView)node).setImage(new Image("file:images/Emptyimg.jpg"));
                     node.setDisable(false);
                     initGameBoard(resetBoard);
                     turn =0;
                     label.setText("It is X's turn!");
                }
            }
        });
    }

    public void playGame(GridPane g, GridData[][] board, Label label){
        for(Node node: g.getChildren()){
            node.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if(turn ==0){
                        ((ImageView)mouseEvent.getSource()).setImage(new Image("file:images/Ximg.jpg"));
                        ((ImageView)mouseEvent.getSource()).setDisable(true);
                        board[GridPane.getRowIndex(node)][GridPane.getColumnIndex(node)] = GridData.X;

                        if(checkWinner(board)){
                            label.setText("X is the Winner");
                            for(Node node: g.getChildren()){
                                node.setDisable(true);
                            }
                        }else {
                            label.setText("It is O's turn!");
                        }

                        if(draw(board)){
                            label.setText("Draw!");
                        }

                        turn=1;
                    }else {
                        ((ImageView)mouseEvent.getSource()).setImage(new Image("file:images/Oimg.jpg"));
                        ((ImageView)mouseEvent.getSource()).setDisable(true);
                        board[GridPane.getRowIndex(node)][GridPane.getColumnIndex(node)] = GridData.O;

                        if(checkWinner(board)){
                            label.setText("O is the Winner");
                            for(Node node: g.getChildren()){
                                node.setDisable(true);
                            }
                        }else {
                            label.setText("It is X's turn!");
                        }

                        if(draw(board)){
                            label.setText("Draw!");
                        }

                        turn = 0;
                    }

                }
            });
        }


    }

    public Boolean checkWinner(GridData[][] board){
        GridData temp;

        for (int i=0;i<4;i++){
            temp = board[i][0];

            for(int j=1;j<4;j++){
                if(temp != board[i][j] || temp==GridData.EMPTY){
                    break;
                }else {
                    if(j==3){
                        return true;
                    }
                }
                temp = board[i][j];
            }
        }

        for (int i=0;i<4;i++){
            temp = board[0][i];

            for(int j=1;j<4;j++){
                if(temp != board[j][i] || temp==GridData.EMPTY){
                    break;
                }else {
                    if(j==3){
                        return true;
                    }
                }
                temp = board[j][i];
            }
        }
        temp = board[0][0];
        for (int i= 1;i<4;i++){
            if(temp != board[i][i] || temp==GridData.EMPTY){
                break;
            }else {
                if(i==3){
                    return true;
                }
            }
            temp = board[i][i];

        }

        int ind=1;
        temp = board[0][3];
        for (int i=2;i>-1;i--){

            if(temp != board[ind][i] || temp==GridData.EMPTY){
                break;
            }else {
                if(i==0){
                    return true;
                }
            }
            temp = board[ind][i];
            ind++;

        }



        return false;

    }

    public boolean draw(GridData[][]board){
        for (int i =0;i<4;i++){
            for(int j=0;j<4;j++){
                if( board[i][j] == GridData.EMPTY ){
                    return false;
                }
            }
        }
        return true;
    }







}


