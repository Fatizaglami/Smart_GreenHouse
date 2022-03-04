package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import application.ConnexionMysql;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Client;
import models.Commande;
import models.Personne;
import models.Serre;

public class CommandeController implements Initializable{
	Connection cnx;
	PreparedStatement st;
	public ResultSet result;

	 @FXML
	    private TableColumn<Commande, String> cin;

	    @FXML
	    private TableColumn<Commande, String> clt_tele;

	    @FXML
	    private TableColumn<Commande, Date> date;

	    @FXML
	    private TableColumn<Commande, Integer> id_com;

	    @FXML
	    private TableColumn<Commande, String> nom_cli;

	    @FXML
	    private TableColumn<Commande, String> prenom_cli;

	    @FXML
	    private JFXButton showButton;

	    @FXML
	    private TableView<Commande> tableSerres;
	    public  ObservableList<Commande> data =FXCollections.observableArrayList();
	    public void showClient() {
	    	tableSerres.getItems().clear();
	    	String sql = "SELECT * FROM commande INNER JOIN personne ON commande.id_C = personne.id_p";
	    	try {
				st=cnx.prepareStatement(sql);
				result=st.executeQuery();
				while(result.next()) {
					data.add(new Commande(result.getInt("num_commande"),result.getString("nom"),result.getString("prenom"),result.getString("CIN"),result.getString("phone_number"),result.getDate("date")));
					cin.setCellValueFactory(new PropertyValueFactory<Commande, String>("cin"));
					id_com.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("num_commande"));
					nom_cli.setCellValueFactory(new PropertyValueFactory<Commande, String>("nom"));
					prenom_cli.setCellValueFactory(new PropertyValueFactory<Commande, String>("prenom"));
					date.setCellValueFactory(new PropertyValueFactory<Commande, Date>("date_commande"));
					clt_tele.setCellValueFactory(new PropertyValueFactory<Commande, String>("phoneNumber"));
					tableSerres.setItems(data);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    	
	    }

	    @FXML
	    void confirmer(MouseEvent event) throws SQLException {
	    	String sql2="DELETE commande FROM commande";
	        PreparedStatement st2 = cnx.prepareStatement(sql2);
	        st2.execute();
	        
	        Alert alert = new Alert(AlertType.CONFIRMATION,"Commande bien confirmer!!",javafx.scene.control.ButtonType.OK);
	    	alert.showAndWait();
	    	showClient();
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			cnx=ConnexionMysql.connexionDB();
	    	showClient();
		}
}
