package controllers;


import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.ConnexionMysql;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AcceuilAdminController implements Initializable {
	
	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	public String nom;
	public String prenom;
	 @FXML
	    private TextField id_serre;

	  @FXML
	    private ComboBox<String> SelCapteur;


	  @FXML
	    private TextField cin_client;

	    @FXML
	    private TextField type_cap;

	    @FXML
	    void voirGraph() throws IOException, SQLException  {
     
          
    // String f ="D:\\MIOLA\\smartgreen_house\\file.txt";
	    	String cin=cin_client.getText();
	    	String id=id_serre.getText();
	    	String sql="select * from personne where CIN='"+cin+"'";
			st=cnx.prepareStatement(sql);
			result=st.executeQuery();
			 if(result.next()) {
	    		   nom=result.getString("nom");
	    		   prenom=result.getString("prenom");

	    	  }
     Stage home=new Stage() ;
     if(!cin.equals("") || !id.equals("") ) {
     if((String)SelCapteur.getValue()=="temperature") {
			

			try {
			
				Parent fxml = FXMLLoader.load(getClass().getResource("/interfaces/GraphTemp.fxml"));
				Scene scene = new Scene(fxml);
				home.setScene(scene);
				home.show();
				Alert alert = new Alert(AlertType.CONFIRMATION,"serre du client "+" "+nom+" "+prenom+"!",javafx.scene.control.ButtonType.OK);
				alert.showAndWait();
				
			}catch(Exception e) {e.printStackTrace();}
	            
        
	    }else if((String)SelCapteur.getValue()=="humiditySol") {
	    	try {
				
				Parent fxml = FXMLLoader.load(getClass().getResource("/interfaces/GraphHumiditySol.fxml"));
				Scene scene = new Scene(fxml);
				home.setScene(scene);
				home.show();
				Alert alert = new Alert(AlertType.CONFIRMATION,"serre du client "+" "+nom+" "+prenom+"!",javafx.scene.control.ButtonType.OK);
				alert.showAndWait();
			}catch(Exception e) {e.printStackTrace();}
	    }else if((String)SelCapteur.getValue()=="humidityAir") {
	    	try {
				
				Parent fxml = FXMLLoader.load(getClass().getResource("/interfaces/GraphHumidityAir.fxml"));
				Scene scene = new Scene(fxml);
				home.setScene(scene);
				home.show();
				Alert alert = new Alert(AlertType.CONFIRMATION,"serre du client "+" "+nom+" "+prenom+"!",javafx.scene.control.ButtonType.OK);
				alert.showAndWait();
				
			}catch(Exception e) {e.printStackTrace();}
	    	
	    }}else {
	    	Alert alert = new Alert(AlertType.WARNING,"Veuillez remplir tout les champs!!",javafx.scene.control.ButtonType.OK);
			alert.showAndWait();
	    }
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			cnx=ConnexionMysql.connexionDB();

			// TODO Auto-generated method stub
			SelCapteur.getItems().add("temperature");
			SelCapteur.getItems().add("humiditySol");
			SelCapteur.getItems().add("humidityAir");
			
			 
			SelCapteur.setPromptText("Capteur");
		}
}


