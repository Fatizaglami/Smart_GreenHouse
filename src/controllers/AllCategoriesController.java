package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;

import models.StockCapteur;
import application.ConnexionMysql;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AllCategoriesController  implements Initializable{
	public Parent fxml;
	Stage home=new Stage();
	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	 @FXML
	    private JFXButton air_button;

	    @FXML
	    private JFXButton light_button;

	    @FXML
	    private JFXButton sol_button;

	    @FXML
	    private JFXButton tem_button;
	    @FXML
	    private AnchorPane allcatAnch;
	    @FXML
	    private TableColumn<StockCapteur,String> cap_desc;

	    @FXML
	    private TableColumn<StockCapteur,Integer> cap_id;

	    @FXML
	    private TableColumn<StockCapteur,String> cap_prix;

	    @FXML
	    private TableColumn<StockCapteur,String> cap_type;
	    @FXML
	    private TableColumn<StockCapteur,Integer> cap_quantite;
	    @FXML
	    private TextField typeTextField;
	    @FXML 
	    private JFXButton afficheButton;

	    @FXML
	    private TableView<StockCapteur> tableCapteurs;
	    @FXML
	    private JFXTextArea desc_textArea;

	    @FXML
	    private ImageView imageView;

	    @FXML
	    private Label prix_label;

	    @FXML
	    private Label quantite_label;

	    @FXML
	    private Label type_label;
	    @FXML
	    private JFXButton temperatureButton;
        
	    @FXML 
	    private JFXButton airButton;
	    
	    @FXML
	    private JFXButton solButton;
	    
	    @FXML
	    private JFXButton lightButton;
	    @FXML
	    private Label air_label;
	    
	    @FXML
	    private Label sol_label;
	    @FXML
	    private Label temp_label;
	    
	    @FXML
	    private Label light_label;




	    
	    @FXML
	
	 			public void showInfosTemperature() {
	 			try {
	 				fxml=FXMLLoader.load(getClass().getResource("/interfaces/TemperatureInfos.fxml"));
	 				home.setTitle("informations");
	 				home.setScene(new Scene(fxml));
	 				home.show();
	 				
	 			}catch(Exception e ) {e.printStackTrace();
	 				
	 			}
	 			 
	           }
	    @FXML
	    public void showInfosAir() throws SQLException {
	    	
	 			try {
	 				fxml=FXMLLoader.load(getClass().getResource("/interfaces/AirHumidityInfos.fxml"));
	 				home.setTitle("informations");
	 				home.setScene(new Scene(fxml));
	 				home.show();
	 				
	 			}catch(Exception e ) {e.printStackTrace();
	 				
	 			}
	 			 
	     		
	     		
	     	}
	    	
	     		
	    	
	    	
	    	
	    @FXML
      public void showInfosSol() throws SQLException {
    	  
	 			try {
	 				fxml=FXMLLoader.load(getClass().getResource("/interfaces/SolHumidityInfos.fxml"));
	 				home.setTitle("informations");
	 				home.setScene(new Scene(fxml));
	 				home.show();
	 				
	 			}catch(Exception e ) {e.printStackTrace();
	 				
	 			}
	 			 
	     		
	     		
	     	}
	    	
	    	
	    	
	    @FXML
	    
      public void showInfosLight() throws SQLException {
    	 
	 			try {
	 				fxml=FXMLLoader.load(getClass().getResource("/interfaces/LightInfos.fxml"));
	 				home.setTitle("informations");
	 				home.setScene(new Scene(fxml));
	 				home.show();
	 				
	 			}catch(Exception e ) {e.printStackTrace();
	 				
	 			}
	 			 
	     		
	     		
	     	}
	    	
	    	
	    	
	    



	    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		cnx=ConnexionMysql.connexionDB();
		
	}

}