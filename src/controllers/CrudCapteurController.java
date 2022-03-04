package controllers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import application.ConnexionMysql;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import models.StockCapteur;

public class CrudCapteurController implements Initializable{

	/*Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	  @FXML
	    private TableColumn<StockCapteur, String> clt_desc;

	    @FXML
	    private TableColumn<StockCapteur, Integer> clt_id;

	    @FXML
	    private TableColumn<StockCapteur, String> clt_prix;

	    @FXML
	    private TableColumn<StockCapteur, String> clt_type;
	    
	    @FXML
	    private TableColumn<StockCapteur, Integer> clt_quantité;

	    @FXML
	    private TextArea desCapteur;

	    @FXML
	    private TextField prixCapteur;

	    @FXML
	    private TextField quantitéCapteur;
	    
	    @FXML
	    private TableView<StockCapteur> table_capteur;

	    @FXML
	    private TextField typeCapteur;

	    @FXML
	    private TextField type_cap;

	    @FXML
	    void addCapteur(MouseEvent event) {

		    	String type=typeCapteur.getText();
		    	String prix=prixCapteur.getText();
		    	String desc=desCapteur.getText();
		    	String qté=quantitéCapteur.getText();
		    	
		    	
		    	String sql="INSERT INTO stockcapteur (type_capteur,prix_capteur,description,qté)  VALUES(?,?,?,?)";
		    	if(!type.equals("")&& !prix.equals("")&& !desc.equals("")&& !qté.equals("")) {
		    	try {
					st=cnx.prepareStatement(sql);
					st.setString(1, type);
					st.setString(2, prix);
					st.setString(3, desc);
					st.setString(4, qté);
					st.execute();
					
					typeCapteur.setText("");
					prixCapteur.setText("");
					desCapteur.setText("");
					quantitéCapteur.setText("");
					
					Alert alert = new Alert(AlertType.CONFIRMATION,"Capteur ajouté avec succés",javafx.scene.control.ButtonType.OK);
					alert.showAndWait();
					showCapteur();
					
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
	    void deleteCapteur(MouseEvent event) {

	    	String sql="DELETE stockcapteur FROM stockcapteur where  stockcapteur.type_capteur='"+type_cap.getText()+"'";
	    	try {
				st=cnx.prepareStatement(sql);
				st.executeUpdate();
				typeCapteur.setText("");
				prixCapteur.setText("");
				desCapteur.setText("");
				quantitéCapteur.setText("");
				Alert alert = new Alert(AlertType.CONFIRMATION,"Capteur supprimé avec succés",javafx.scene.control.ButtonType.OK);
				alert.showAndWait();
				showCapteur();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    @FXML
	    void editCapteur(MouseEvent event) {

	    	String type=typeCapteur.getText();
	    	String prix=prixCapteur.getText();
	    	String desc=desCapteur.getText();
	    	String qté=quantitéCapteur.getText();
	    	
	    	String sql="UPDATE stockcapteur SET type_capteur=?,prix_capteur=?,description=?,qté=? WHERE type_capteur='"+type_cap.getText()+"'";
	    	if(!type.equals("")&& !prix.equals("")&& !desc.equals("")&& !qté.equals("")) {
	    	try {
				st=cnx.prepareStatement(sql);
				st.setString(1, type);
				st.setString(2, prix);
				st.setString(3, desc);
				st.setString(4, qté);
				st.execute();
				
				typeCapteur.setText("");
				prixCapteur.setText("");
				desCapteur.setText("");
				quantitéCapteur.setText("");
				
				Alert alert = new Alert(AlertType.CONFIRMATION,"Capteur modifié avec succés",javafx.scene.control.ButtonType.OK);
				alert.showAndWait();
				showCapteur();
				
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
	    void rechercherCapteur(ActionEvent event) {
  
	    	String sql = "SELECT type_capteur,prix_capteur,description,qté FROM stockcapteur where type_capteur='"+type_cap.getText()+"'";
	    	int m=0;
	    	try {
				st=cnx.prepareStatement(sql);
				result=st.executeQuery();
				if(result.next()) {
					typeCapteur.setText(result.getString("type_capteur"));
					prixCapteur.setText(result.getString("prix_capteur"));
					desCapteur.setText(result.getString("description"));
					quantitéCapteur.setText(result.getString("qté"));
					m=1;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           if(m==0) {
        	   Alert alert= new Alert(AlertType.ERROR,"Aucun capteur trouvé de type"+" "+type_cap.getText()+"",javafx.scene.control.ButtonType.OK);
        	   alert.showAndWait();
           }
	    }
	    public ObservableList<StockCapteur> data = FXCollections.observableArrayList();
	    public void showCapteur() {
	    	table_capteur.getItems().clear();
	    	String sql = "SELECT * FROM stockcapteur";
	    	try {
				st=cnx.prepareStatement(sql);
				result=st.executeQuery();
				while(result.next()) {
					data.add(new StockCapteur(result.getInt("id_cap"),result.getString("type_capteur"),result.getString("prix_capteur"),result.getString("description"),result.getInt("qté")));
					clt_type.setCellValueFactory(new PropertyValueFactory<StockCapteur, String>("type"));
					clt_id.setCellValueFactory(new PropertyValueFactory<StockCapteur, Integer>("id_capteur"));
					clt_prix.setCellValueFactory(new PropertyValueFactory<StockCapteur, String>("prix"));
					clt_desc.setCellValueFactory(new PropertyValueFactory<StockCapteur, String>("desc"));
					clt_quantité.setCellValueFactory(new PropertyValueFactory<StockCapteur, Integer>("quantité"));

					
					table_capteur.setItems(data);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    	
	    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		cnx=ConnexionMysql.connexionDB();
    	showCapteur();
	}

	

}*/
	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	 @FXML
	   private TableColumn<StockCapteur, String> clt_desc;

	   @FXML
	   private TableColumn<StockCapteur, Integer> clt_id;

	   @FXML
	   private TableColumn<StockCapteur, String> clt_prix;

	   @FXML
	   private TableColumn<StockCapteur, String> clt_type;
	   
	   @FXML
	   private TableColumn<StockCapteur, Integer> clt_quantité;

	   @FXML
	   private TextArea desCapteur;

	   @FXML
	   private TextField prixCapteur;

	   @FXML
	   private TextField quantitéCapteur;
	   
	   @FXML
	   private TableView<StockCapteur> table_capteur;

	   @FXML
	   private TextField typeCapteur;

	   @FXML
	   private TextField type_cap;
	   @FXML
	   private JFXButton chooseButton;
	        public FileInputStream fileInputStream;
	        @FXML
	   private ImageView imageView;
	   private Image image;
	   public FileChooser fileChooser;
	   public File file;
	 
	   @FXML
	public    void choose(ActionEvent event) {
	    fileChooser =new FileChooser();
	    file =fileChooser.showOpenDialog(chooseButton.getScene().getWindow());
	   

	   }


	   @FXML
	   void addCapteur(MouseEvent event) throws FileNotFoundException {

	    String type=typeCapteur.getText();
	    String prix=prixCapteur.getText();
	    String desc=desCapteur.getText();
	    String qté=quantitéCapteur.getText();
	   
	   
	   
	    String sql="INSERT INTO stockcapteur (type_capteur,prix_capteur,description,qté,image)  VALUES(?,?,?,?,?)";
	    if(!type.equals("")&& !prix.equals("")&& !desc.equals("")&& !qté.equals("")) {
	    try {
	st=cnx.prepareStatement(sql);
	fileInputStream=new FileInputStream(file);

	st.setString(1, type);
	st.setString(2, prix);
	st.setString(3, desc);
	st.setString(4, qté);
	st.setBinaryStream(5, fileInputStream);
	       st.execute();
	       image =new Image(fileInputStream);
	       imageView.setImage(image);

	typeCapteur.setText("");
	prixCapteur.setText("");
	desCapteur.setText("");
	quantitéCapteur.setText("");

	Alert alert = new Alert(AlertType.CONFIRMATION,"Capteur ajouté avec succés",javafx.scene.control.ButtonType.OK);
	alert.showAndWait();
	showCapteur();

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
	   void deleteCapteur(MouseEvent event) {

	    String sql="DELETE stockcapteur FROM stockcapteur where  stockcapteur.type_capteur='"+type_cap.getText()+"'";
	    try {
	st=cnx.prepareStatement(sql);
	st.executeUpdate();
	typeCapteur.setText("");
	prixCapteur.setText("");
	desCapteur.setText("");
	quantitéCapteur.setText("");
	Alert alert = new Alert(AlertType.CONFIRMATION,"Capteur supprimé avec succés",javafx.scene.control.ButtonType.OK);
	alert.showAndWait();
	showCapteur();

	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	   }

	   @FXML
	   void editCapteur(MouseEvent event) throws FileNotFoundException {

	    String type=typeCapteur.getText();
	    String prix=prixCapteur.getText();
	    String desc=desCapteur.getText();
	    String qté=quantitéCapteur.getText();
	   
	    String sql="UPDATE stockcapteur SET type_capteur=?,prix_capteur=?,description=?,qté=?,image=? WHERE type_capteur='"+type_cap.getText()+"'";
	    if(!type.equals("")&& !prix.equals("")&& !desc.equals("")&& !qté.equals("")) {
	    try {
	st=cnx.prepareStatement(sql);
	fileInputStream=new FileInputStream(file);
	st.setString(1, type);
	st.setString(2, prix);
	st.setString(3, desc);
	st.setString(4, qté);
	st.setBinaryStream(5, fileInputStream);
    st.execute();
    image =new Image(fileInputStream);
    imageView.setImage(image);
	

	typeCapteur.setText("");
	prixCapteur.setText("");
	desCapteur.setText("");
	quantitéCapteur.setText("");

	Alert alert = new Alert(AlertType.CONFIRMATION,"Capteur modifié avec succés",javafx.scene.control.ButtonType.OK);
	alert.showAndWait();
	showCapteur();

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
	   void rechercherCapteur(ActionEvent event) {
	 
	    String sql = "SELECT type_capteur,prix_capteur,description,qté,image FROM stockcapteur where type_capteur='"+type_cap.getText()+"'";
	    byte byteimg[];
	    Blob blob;
	    int m=0;
	    try {
	st=cnx.prepareStatement(sql);
	result=st.executeQuery();
	if(result.next()) {
	typeCapteur.setText(result.getString("type_capteur"));
	prixCapteur.setText(result.getString("prix_capteur"));
	desCapteur.setText(result.getString("description"));
	quantitéCapteur.setText(result.getString("qté"));
	blob=result.getBlob("image");
	byteimg=blob.getBytes(1, (int) blob.length());
	Image img=new Image(new ByteArrayInputStream(byteimg),imageView.getFitWidth(),imageView.getFitHeight(),true,true);
	imageView.setImage(img);
	m=1;
	}
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	           if(m==0) {
	          Alert alert= new Alert(AlertType.ERROR,"Aucun capteur trouvé de type"+" "+type_cap.getText()+"",javafx.scene.control.ButtonType.OK);
	          alert.showAndWait();
	           }
	   }
	   public ObservableList<StockCapteur> data = FXCollections.observableArrayList();
	   public void showCapteur() {
	    table_capteur.getItems().clear();
	    String sql = "SELECT * FROM stockcapteur";
	    try {
	st=cnx.prepareStatement(sql);
	result=st.executeQuery();
	while(result.next()) {
	data.add(new StockCapteur(result.getInt("id_cap"),result.getString("type_capteur"),result.getString("prix_capteur"),result.getString("description"),result.getInt("qté")));
	clt_type.setCellValueFactory(new PropertyValueFactory<StockCapteur, String>("type"));
	clt_id.setCellValueFactory(new PropertyValueFactory<StockCapteur, Integer>("id_capteur"));
	clt_prix.setCellValueFactory(new PropertyValueFactory<StockCapteur, String>("prix"));
	clt_desc.setCellValueFactory(new PropertyValueFactory<StockCapteur, String>("desc"));
	clt_quantité.setCellValueFactory(new PropertyValueFactory<StockCapteur, Integer>("quantité"));


	table_capteur.setItems(data);
	}

	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	   
	   }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	cnx=ConnexionMysql.connexionDB();
	    showCapteur();
	}



	}
