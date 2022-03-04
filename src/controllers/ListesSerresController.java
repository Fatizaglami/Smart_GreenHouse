package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import models.Personne;
import models.Serre;

import application.ConnexionMysql;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ListesSerresController implements Initializable{
	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;

    @FXML
    private TextField cinTextField;

    @FXML
    private TableColumn<Serre, String> clt_cin;

    @FXML
    private TableColumn<Serre, Integer> serre_id;

    @FXML
    private TableColumn<Serre, String> clt_nom;

    @FXML
    private TableColumn<Serre, String> clt_prenom;

    @FXML
    private TableColumn<Serre, String> clt_tele;
    @FXML
    private TableColumn<Serre, Double> metrageT;
    @FXML
    private TextField cin_txt;
    

    @FXML
    private TableView<Serre> tableSerres;
   public  ObservableList<Serre> data =FXCollections.observableArrayList();

   @FXML
   void showSerres(MouseEvent event) {
	   String cin=cin_txt.getText();
		
		//tableSerres.getItems().clear();
	String sql="SELECT * FROM serre INNER JOIN personne ON serre.id_C=personne.id_p WHERE CIN ='"+cin+"'";
	if(!cin.equals("")) {
	try {
		st=cnx.prepareStatement(sql);
		result =st.executeQuery();
		

				while(result.next()) {
					
				
					data.add(new Serre(result.getInt("id_serre"),result.getString("nom"),result.getString("prenom"),result.getString("CIN"),result.getString("phone_number"),result.getDouble("metrage")));
					clt_cin.setCellValueFactory(new PropertyValueFactory<Serre, String>("cin"));
					
					serre_id.setCellValueFactory(new PropertyValueFactory<Serre, Integer>("id"));
					clt_nom.setCellValueFactory(new PropertyValueFactory<Serre, String>("nom"));
					clt_prenom.setCellValueFactory(new PropertyValueFactory<Serre, String>("prenom"));
					metrageT.setCellValueFactory(new PropertyValueFactory<Serre, Double>("metrage"));
					clt_tele.setCellValueFactory(new PropertyValueFactory<Serre, String>("phoneNumber"));
					tableSerres.setItems(data);
					
				}
		
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}else {
		Alert alert = new Alert(AlertType.WARNING,"Veuillez entrer votre cin!!",javafx.scene.control.ButtonType.OK);
		alert.showAndWait();
	}
   }
   
	
  
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    	cnx=ConnexionMysql.connexionDB();
    	
		
	}
    
    }
    

