package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import application.ConnexionMysql;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ClientDashboardController implements Initializable {
	private Parent fxml;
	Connection cnx;
	  @FXML
	    private Text user_lab;

	    @FXML
	    private Text user_lab1;


	@FXML
	private AnchorPane root;
      
	  @FXML
	    private JFXButton allCategoriesButton;

	    @FXML
	    private JFXButton cartButton;

	    @FXML
	    private JFXButton serresButton;
	    @FXML
	    private JFXButton logoutbtn;
	   
       
        @FXML
        void myCart(MouseEvent event) {
        	try {
	 			fxml = FXMLLoader.load(getClass().getResource("/interfaces/MyCart.fxml"));
	 			root.getChildren().removeAll();
	 			root.getChildren().setAll(fxml);
	 		} catch (IOException e) {
	 			
	 			e.printStackTrace();
	 		}
        }

        @FXML
        void showAll(MouseEvent event) {
        	try {
	 			fxml = FXMLLoader.load(getClass().getResource("/interfaces/AllCategories.fxml"));
	 			root.getChildren().removeAll();
	 			root.getChildren().setAll(fxml);
	 		} catch (IOException e) {
	 			
	 			e.printStackTrace();
	 		}
        }
	    @FXML
	    void ListeSerres(MouseEvent event) {
	    	try {
	 			fxml = FXMLLoader.load(getClass().getResource("/interfaces/ListesSerres.fxml"));
	 			root.getChildren().removeAll();
	 			root.getChildren().setAll(fxml);
	 		} catch (IOException e) {
	 			
	 			e.printStackTrace();
	 		}
	    }

	    	
	    	  @FXML
	    	    void logout(MouseEvent event) {
	    		  Stage home=new Stage() ;
	  			try {
	  				logoutbtn.getScene().getWindow().hide();
	  				fxml= FXMLLoader.load(getClass().getResource("/interfaces/login.fxml"));
	  				
	  				Scene scene = new Scene(fxml);
	  				home.setScene(scene);
	  				home.show();
	  				
	  				
	  			}catch(Exception e) {e.printStackTrace();}
	    	    }
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			try {
	   			fxml = FXMLLoader.load(getClass().getResource("/interfaces/AllCategories.fxml"));
	   			root.getChildren().removeAll();
	   			root.getChildren().setAll(fxml);
	   		} catch (IOException e) {
	   			
	   			e.printStackTrace();
	   		}    
			
		}
	    
	    
}