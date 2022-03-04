package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.ConnexionMysql;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Serre;

public class CrudSerreController implements Initializable{
	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	  @FXML
	    private TextField cin_client;

	    @FXML
	    private TableColumn<Serre, String> clt_cin;

	    @FXML
	    private TableColumn<Serre, Integer> clt_id;

	    @FXML
	    private TableColumn<Serre, Double> clt_metrage;

	    @FXML
	    private TableColumn<Serre, String> clt_nom;

	    @FXML
	    private TableColumn<Serre, String> clt_prenom;

	    @FXML
	    private TableColumn<Serre, String> clt_tel;

	    @FXML
	    private TextField id_rech;

	    @FXML
	    private TableView<Serre> table_Serre;

	    @FXML
	    private TextField txt_metrage;

	    @FXML
	    private TextField txt_nom;

	    @FXML
	    private TextField txt_prenom;

	    @FXML
	    private TextField txt_tel;

	    @FXML
	    void addSerre(MouseEvent event) throws SQLException {
	    	
	    	String cin=cin_client.getText();
	    	String metrage=txt_metrage.getText();
	    	
	    	String sql="INSERT INTO serre (id_C,metrage)  VALUES((select id_p from personne where CIN='"+cin_client.getText()+"'),?)";
	    	
	    	if( !cin.equals("")&& !metrage.equals("")) {
	    	try {
	    		
				st=cnx.prepareStatement(sql);
				
				st.setString(1, metrage);
				st.execute();
				
				cin_client.setText("");
				txt_nom.setText("");
				txt_prenom.setText("");
				txt_tel.setText("");
				txt_metrage.setText("");
				Alert alert = new Alert(AlertType.CONFIRMATION,"Serre ajoutée avec succés",javafx.scene.control.ButtonType.OK);
				alert.showAndWait();
				showSerre();
				
			} catch (SQLException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
	    	}else {
	    		Alert alert = new Alert(AlertType.WARNING,"Veuillez remplir tout les champs!!",javafx.scene.control.ButtonType.OK);
				alert.showAndWait();
	    	}
	    	

	    }

	    

	    @FXML
	    void deleteSerre(MouseEvent event) {
	    	String sql="DELETE serre FROM serre where id_serre='"+id_rech.getText()+"'";
	    	try {
				st=cnx.prepareStatement(sql);
				st.executeUpdate();
				Alert alert = new Alert(AlertType.CONFIRMATION,"Serre supprimée avec succés",javafx.scene.control.ButtonType.OK);
				alert.showAndWait();
				ClearAll();
				showSerre();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    @FXML
	    void editSerre(MouseEvent event) {
	    	String cin=cin_client.getText();
	    	String metrage=txt_metrage.getText();
	    	
	    	String sql="UPDATE serre SET metrage=? WHERE id_serre='"+id_rech.getText()+"'";
	    	
	    	if( !cin.equals("")&& !metrage.equals("")) {
	    	try {
	    		
				st=cnx.prepareStatement(sql);
				
				st.setString(1, metrage);
				st.execute();
				
				cin_client.setText("");
				txt_nom.setText("");
				txt_prenom.setText("");
				txt_tel.setText("");
				txt_metrage.setText("");
				Alert alert = new Alert(AlertType.CONFIRMATION,"Serre modifiée avec succés",javafx.scene.control.ButtonType.OK);
				alert.showAndWait();
				showSerre();
				
			} catch (SQLException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
	    	}else {
	    		Alert alert = new Alert(AlertType.WARNING,"Veuillez remplir tout les champs!!",javafx.scene.control.ButtonType.OK);
				alert.showAndWait();
	    	}
	    	

	    }
	    

	    @FXML
	    void rechercherSerre(ActionEvent event) {
	    	String sql = "SELECT nom,prenom,CIN,phone_number,metrage FROM serre INNER JOIN personne ON serre.id_C = personne.id_p where id_serre='"+id_rech.getText()+"'";
	    	
	    	int m=0;
	    	try {
				st=cnx.prepareStatement(sql);
				result=st.executeQuery();
				if(result.next()) {
					txt_nom.setText(result.getString("nom"));
					txt_prenom.setText(result.getString("prenom"));
					cin_client.setText(result.getString("CIN"));
					txt_tel.setText(result.getString("phone_number"));
					txt_metrage.setText(result.getString("metrage"));
					m=1;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           if(m==0) {
        	   Alert alert= new Alert(AlertType.ERROR,"Aucune serre trouvé avec l'identifiant"+" "+id_rech.getText()+"",javafx.scene.control.ButtonType.OK);
        	   alert.showAndWait();
           }
	    }
	    public ObservableList<Serre> data = FXCollections.observableArrayList();
	    public void showSerre() {
	    	table_Serre.getItems().clear();
	    	String sql = "SELECT * FROM serre INNER JOIN personne ON serre.id_C = personne.id_p";
	    	try {
				st=cnx.prepareStatement(sql);
				result=st.executeQuery();
				while(result.next()) {
					data.add(new Serre(result.getInt("id_serre"),result.getString("nom"),result.getString("prenom"),result.getString("CIN"),result.getString("phone_number"),result.getDouble("metrage")));
					clt_cin.setCellValueFactory(new PropertyValueFactory<Serre, String>("cin"));
					clt_id.setCellValueFactory(new PropertyValueFactory<Serre, Integer>("id"));
					clt_nom.setCellValueFactory(new PropertyValueFactory<Serre, String>("nom"));
					clt_prenom.setCellValueFactory(new PropertyValueFactory<Serre, String>("prenom"));
					clt_metrage.setCellValueFactory(new PropertyValueFactory<Serre, Double>("metrage"));
					clt_tel.setCellValueFactory(new PropertyValueFactory<Serre, String>("phoneNumber"));
					table_Serre.setItems(data);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    	
	    }
	    @FXML
	    void ClearAll() {
	    	cin_client.setText("");
			txt_nom.setText("");
			txt_prenom.setText("");
			txt_tel.setText("");
			txt_metrage.setText("");
			id_rech.setText("");
	    }



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		cnx=ConnexionMysql.connexionDB();
    	showSerre();
	}

	

}
