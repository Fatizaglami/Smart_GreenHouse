package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import com.jfoenix.animation.alert.JFXAlertAnimation;
import com.jfoenix.controls.JFXButton;

import models.Panier;
import models.StockCapteur;
import application.ConnexionMysql;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.Date;

public class MyCartController implements Initializable {
	Connection cnx;
public	String concat="";
	public PreparedStatement st;
	public PreparedStatement st1;
	public PreparedStatement st2;
	public PreparedStatement st3;
   
	public ResultSet result;
	public ResultSet result1;
	public ResultSet result2;
	public ResultSet result3;
	public int id_C;
	public  LocalDateTime date;
	
	
	@FXML
    private JFXButton buyNowButton;

    @FXML
    private TableView<Panier> productsTable;
    @FXML
    private TableColumn<Panier, Integer> id_clientT;

    @FXML
    private TableColumn<Panier, Integer> id_paT;

    @FXML
    private TableColumn<Panier, String> nameT;

    @FXML
    private TableColumn<Panier, String> prixT;
    @FXML
    private TextField coutTextField;


    

    @FXML
    private TableColumn<Panier, Integer> quantiteT;
    public ObservableList<Panier> data = FXCollections.observableArrayList();


    @FXML
    void buyNowAction(ActionEvent event) throws SQLException {
    	date=LocalDateTime.now();
    	
    String	sql="SELECT * From panier";
    st=cnx.prepareStatement(sql);
     result=st.executeQuery();
    if(result.next()) {
    	id_C=result.getInt("id_C");
    	
    }
    String sql1=" INSERT INTO commande(id_C) VALUES(?)";
    
    st1=cnx.prepareStatement(sql1);
    st1.setInt(1,id_C);
    
    st1.execute();
    
    String sql2="DELETE panier FROM panier";
    st2=cnx.prepareStatement(sql2);
    st2.execute();
    
    Alert alert = new Alert(AlertType.CONFIRMATION,"Votre commande à bien été effectuer, notre technicien vous contactera dans les jours qui arrivent!!",javafx.scene.control.ButtonType.OK);
	alert.showAndWait();
	showproducts();
      
      
    	

    }
	
	
	public void showproducts() throws SQLException {
		productsTable.getItems().clear();
		String sql = "SELECT * FROM panier";
		st=cnx.prepareStatement(sql);
		result=st.executeQuery();
		while(result.next()) {
			data.add(new Panier(result.getInt("id_panier"),result.getInt("id_C"),result.getString("type_product"),result.getString("prix"),result.getInt("quantite")));
			 id_paT.setCellValueFactory(new PropertyValueFactory<Panier, Integer>("id_panier"));
			 id_clientT.setCellValueFactory(new PropertyValueFactory<Panier, Integer>("id_c"));
			 nameT.setCellValueFactory(new PropertyValueFactory<Panier, String>("product_type"));
			 prixT.setCellValueFactory(new PropertyValueFactory<Panier, String>("prix"));
			 quantiteT.setCellValueFactory(new PropertyValueFactory<Panier, Integer>("Quantite"));
			 
			


			productsTable.setItems(data);
			}
       
		
	}
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		cnx=ConnexionMysql.connexionDB();
		try {
			showproducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
