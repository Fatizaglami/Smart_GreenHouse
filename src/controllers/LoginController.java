package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;

import application.ConnexionMysql;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import javafx.fxml.Initializable;


public class LoginController implements Initializable {

	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	private Parent fxml;
	 @FXML
     private JFXComboBox<String> jfoenixCombobox;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		con=ConnexionMysql.connexionDB();
		
		jfoenixCombobox.getItems().add("Administrateur");
		jfoenixCombobox.getItems().add("Client");
		
		
		 
		jfoenixCombobox.setPromptText("Select the category");
	}
	   

	   @FXML
	    private Label labelError;
	    @FXML
	    private Button cancelButton;

	    @FXML
	    private TextField lginTextFied;

	    @FXML
	    private Button loginButton;

	    @FXML
	    private PasswordField passwordTextFied;
	    

	    @FXML
	    void cancel(ActionEvent event) {
	    	Stage stage =(Stage)cancelButton.getScene().getWindow();
	        stage.close();

	    }
	    Connection con = null;
	    PreparedStatement preparedStatement=null;
	    ResultSet resultSet= null;

	    @FXML
	   private void login(ActionEvent event) throws Exception{
	    	
	    	
	    	String name=lginTextFied.getText().toString();
	    	String pass=passwordTextFied.getText().toString();
	    	 
	    	if(name.equals("") && pass.equals("")) {
	    		Alert alert = new Alert(Alert.AlertType.WARNING);
	    		alert.setTitle("Warning Dialog");
	    		alert.setContentText("login or password are blank");
	    		alert.setHeaderText("Warning alert");
	    		alert.showAndWait();
	    	}
	    	
	    	else {
	    		//query
	    		String sql ="SELECT * FROM personne WHERE login=? and password=?";
	    		try {
	    			
	    			preparedStatement=con.prepareStatement(sql);
	    			preparedStatement.setString(1,name);
	    			preparedStatement.setString(2, pass);
	    			resultSet=preparedStatement.executeQuery();
	    			
	    			if(!resultSet.next()) {
	    				labelError.setText("Enter correct login or password");
	    			}
	    			else {
	    				Stage home=new Stage() ;
	    				if((String)jfoenixCombobox.getValue()=="Administrateur") {
	    				try {
	    					loginButton.getScene().getWindow().hide();
	    					fxml= FXMLLoader.load(getClass().getResource("/interfaces/AdminBoard.fxml"));
	    					
	    					Scene scene = new Scene(fxml);
	    					home.setScene(scene);
	    					home.show();
	    					
	    					
	    				}catch(Exception e) {e.printStackTrace();}}
	    				if((String)jfoenixCombobox.getValue()=="Client") {
	    				try {
	    					loginButton.getScene().getWindow().hide();
	    					fxml= FXMLLoader.load(getClass().getResource("/interfaces/ClientDashboard.fxml"));
	    					
	    					Scene scene = new Scene(fxml);
	    					home.setScene(scene);
	    					home.show();
	    					
	    					
	    				}catch(Exception e) {e.printStackTrace();}}
	    			}
	    		}catch(Exception e) {e.printStackTrace();}}}}





