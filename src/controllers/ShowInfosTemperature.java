package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;

import application.ConnexionMysql;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ShowInfosTemperature implements Initializable{
	public int id_c;
	public Parent fxml;
	Stage home=new Stage();
	Connection cnx;
	public PreparedStatement st;
	public PreparedStatement st1;
	public PreparedStatement st2;
	public ResultSet result;
	public ResultSet result1;
	public ResultSet result2;
	public int quantitee;
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
	    private Label temp_label;
	    @FXML
	    private TextField qtTextField;
    
	    @FXML
	    private TextField cinTextField;
	    @FXML
	
	 public void showinfos() throws SQLException {
		 
		 String sql = "SELECT * FROM stockcapteur WHERE type_capteur='temperature'";
	    	st=cnx.prepareStatement(sql);
	     	result=st.executeQuery();
	     	while(result.next()) {
	     		String type=result.getString("type_capteur");
	     		String prix=result.getString("prix_capteur");
	     		String desc=result.getString("description");
	     		int qt= result.getInt("qté");
	     		
	     		type_label.setText(type);
	 			 prix_label.setText(prix);
	 			 desc_textArea.setText(desc);
	 			quantite_label.setText(Integer.toString(qt));
	 			
	 }
	     	
	 }
	 @FXML
	public void addToCart() throws SQLException {
	String 	sql1=" select id_p from personne where CIN='"+cinTextField.getText()+"'";
	  st1=cnx.prepareStatement(sql1);
	  result1=st1.executeQuery();
	  if(result1.next()) {
		   id_c=result1.getInt("id_p");
	  }
	  
	
	
		String type=type_label.getText();
		String prix=prix_label.getText();
		int quantite= Integer.parseInt(qtTextField.getText());
		
	 String	sql2="SELECT qté from stockcapteur where type_capteur='temperature' ";
	 st2=cnx.prepareStatement(sql2);
	  result2=st2.executeQuery();
	  if(result2.next()) {
		  quantitee=result2.getInt("qté");
		  
		  
	  }
	  if(quantite<quantitee) {
	 
		String sql="INSERT INTO panier (id_C,type_product,prix,quantite)  VALUES(?,?,?,?)";
		if( !type.equals("") && !prix.equals("") && quantite!=0) {
			st=cnx.prepareStatement(sql);
			st.setInt(1, id_c);
			st.setString(2, type);
			st.setString(3, prix);
			st.setInt(4, quantite);
			 st.execute();
			 Alert alert = new Alert(AlertType.CONFIRMATION,"Capteur ajouté au panier avec succés",javafx.scene.control.ButtonType.OK);
				alert.showAndWait();
		}}else {
			Alert alert = new Alert(AlertType.WARNING,"Quantité non disponible en stock",javafx.scene.control.ButtonType.OK);
			alert.showAndWait();
		}
		
		
	}
	
	
	
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// TODO Auto-generated method stub
		cnx=ConnexionMysql.connexionDB();
	}}

