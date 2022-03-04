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
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class AdminBoardController implements Initializable{
	   
	  private Parent fxml;
	  Connection cnx;
	  @FXML
	    private Text user_lab;
    
	   @FXML
	    private AnchorPane root;
	   @FXML
	    private Text user_lab1;
	   @FXML
	    private JFXButton logoutbtn;

	    @FXML
	    void capteurs(MouseEvent event) {
	    	 try {
	 			fxml = FXMLLoader.load(getClass().getResource("/interfaces/CrudCapteur.fxml"));
	 			root.getChildren().removeAll();
	 			root.getChildren().setAll(fxml);
	 		} catch (IOException e) {
	 			
	 			e.printStackTrace();
	 		}
	            
	            
	    }

	    @FXML
	    void Commande(MouseEvent event) {
	    	 try {
		 			fxml = FXMLLoader.load(getClass().getResource("/interfaces/Commande.fxml"));
		 			root.getChildren().removeAll();
		 			root.getChildren().setAll(fxml);
		 		} catch (IOException e) {
		 			
		 			e.printStackTrace();
		 		}
	    }
	    @FXML
	    void clients(MouseEvent event) {
           try {
			fxml = FXMLLoader.load(getClass().getResource("/interfaces/CrudClients.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
           
	    }

	    @FXML
	    void dashboard(MouseEvent event) {
	    	   try {
	   			fxml = FXMLLoader.load(getClass().getResource("/interfaces/AcceuilAdmin.fxml"));
	   			root.getChildren().removeAll();
	   			root.getChildren().setAll(fxml);
	   		} catch (IOException e) {
	   			
	   			e.printStackTrace();
	   		}    
	    }

	    @FXML
	    void serres(MouseEvent event) {
	    	 try {
	 			fxml = FXMLLoader.load(getClass().getResource("/interfaces/CrudSerres.fxml"));
	 			root.getChildren().removeAll();
	 			root.getChildren().setAll(fxml);
	 		} catch (IOException e) {
	 			
	 			e.printStackTrace();
	 		}
	            
	    }

	    @FXML
	    void techniciens(MouseEvent event) {
	    	 try {
	 			fxml = FXMLLoader.load(getClass().getResource("/interfaces/CrudTechniciens.fxml"));
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
			cnx=ConnexionMysql.connexionDB();
			String sql="select login,nom,prenom from personne where id_p=(select MAX(id_p) from personne)";
			try {
				PreparedStatement st = cnx.prepareStatement(sql);
				ResultSet result = st.executeQuery();
				if(result.next()) {
					user_lab.setText(result.getString("login"));
					user_lab1.setText(result.getString("nom")+" "+result.getString("prenom"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
		   			fxml = FXMLLoader.load(getClass().getResource("/interfaces/AcceuilAdmin.fxml"));
		   			root.getChildren().removeAll();
		   			root.getChildren().setAll(fxml);
		   		} catch (IOException e) {
		   			
		   			e.printStackTrace();
		   		}    
		}
	

}
