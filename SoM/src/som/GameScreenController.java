/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package som;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Polygon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;




/**
 * FXML Controller class
 *
 * @author makogenq
 */
public class GameScreenController implements Initializable {
    @FXML
    Pane gameLayer;
    
    @FXML
    Pane gameBoard;
    
    @FXML
    Pane playerGUI; 
    
    @FXML
    Pane popupDialog;
    
    @FXML 
    Text popUpText;
    
    //Circle selectedCircle=new HexVertex();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Parent game_screen_parent = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
        //Scene game_screen_scene = new Scene(game_screen_parent);
       // Stage a_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //a_stage.setScene(game_screen_scene);
        //playerGUI.setPickOnBounds(false);
        HexBoard board = new HexBoard();
        
        for(HexVertex v: board.vertexList)
        {
            v.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            if(!popupDialog.isVisible()){
                popupDialog.setVisible(true);
                
                popUpText.setText(v.getLayoutBounds().toString()+"\n"
                +popupDialog.getLayoutBounds().toString());
            }
                //popupDialog.setLayoutX(v.position.getX());
                //popupDialog.setLayoutY(v.position.getY());
                popupDialog.setLayoutX(v.getLayoutX());
                popupDialog.setLayoutY(v.getLayoutY());
            
            
            //selectedCircle.set(circle);
            //selectedLocation.set(new Point2D(x, y));
        });

        }
     
        
        gameBoard.getChildren().add(board.getBoardPane());
        
      
        
 
      
     
    
    }
    
    public void gameLoop(){
        int gameState=1;
       /* public enum {INIT,ROLL,P1TURN,P2TURN,P3TURN,P4TURN}}
            
        };
*/
    


         //get list of players
         //roll dice to find the first person's turn
         
         //first player's turn
         
         
            
            
        
        
    }
    
    
    
    public void handleButtonAction(ActionEvent event) throws IOException{
       
        
    }
   
     public void handleVertexButtonAction(ActionEvent event) throws IOException {
               String m=((RadioButton)event.getSource()).getText();
               System.out.println("This is a Vertex "+ m);

             
        //label.setText("Hello World!");

       
    } 
     public void handleEdgeButtonAction(ActionEvent event) throws IOException {
               String m=((RadioButton)event.getSource()).getText();
               System.out.println("This is an Edge:  "+ m);

             
        //label.setText("Hello World!");

       
    }
}