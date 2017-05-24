// ConnectServerController.java
package som;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ConnectServerController implements Initializable {
	@FXML
	private TextField ip, port;
    protected ObjectClient client;
	

	@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    	// Press enter jump to next TextField until reaching to Conncet
        ip.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent e){
        		port.requestFocus();
        	}
        });

        port.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent e){
        		try{
	        		handleConnectServer(e);
	        	}
	        	catch (IOException ioe){
	        		ioe.printStackTrace();
	        	}
        	}
        });
    }    
	
	public void handleConnectServer(ActionEvent e) throws IOException {
		ip.setText((ip.getText().trim().isEmpty()) ? "localhost" : ip.getText());
        port.setText((port.getText().trim().isEmpty()) ? "8888" : port.getText());
        client = new ObjectClient(ip.getText().trim(), Integer.parseInt(port.getText().trim()));
        System.out.println(ip.getText().trim() + ": " + port.getText().trim());

    }
}