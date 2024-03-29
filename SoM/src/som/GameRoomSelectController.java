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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author makogenq
 */
public class GameRoomSelectController implements Initializable {

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	public void handleButtonAction(ActionEvent event) throws IOException {
		GameScreenController.audio.playClips(8);
		System.out.println("You clicked me!");
		// label.setText("Hello World!");
		Parent game_room_parent = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
		Scene game_room_scene = new Scene(game_room_parent);
		game_room_scene.getStylesheets().add(getClass().getResource("som.css").toExternalForm());
		Stage a_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		a_stage.setScene(game_room_scene);
		a_stage.setResizable(false);

		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		a_stage.setX((primaryScreenBounds.getWidth() - a_stage.getWidth()) / 2);
		a_stage.setY((primaryScreenBounds.getHeight() - a_stage.getHeight()) / 2);

		a_stage.show();
	}

}
