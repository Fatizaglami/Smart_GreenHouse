package interfaces;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import models.Capteur;

//import Model.Terrain;
//import Model.captter;

public class Interface extends JFrame{
	public JPanel panel;
	public JPanel Login_Panel;
	public JPanel Inscription_Panel;
	public JPanel acceuil_Panel;
	public JPanel Terrain_Panel;
	public JPanel Infos_Panel;
	public JPanel Paiement_Panel;
	
	public CardLayout Card;

	JButton b;
	
	// Login Panel
	
    public JLabel login_userLabel = new JLabel("USERNAME");
    public JLabel login_passwordLabel = new JLabel("PASSWORD");
    
    public JTextField login_userTextField = new JTextField();
    public JPasswordField login_passwordField = new JPasswordField();
    
    public JButton login_Button_login = new JButton("LOGIN");
    public JButton login_resetButton = new JButton("RESET");
    public JButton login_InscrireButton = new JButton("S'inscrire");	
    
    
    JCheckBox login_showPassword = new JCheckBox("Show Password");

    //Fin Login Panel
    
    
    
    
    
    //Inscription Panel
    
    public JLabel inscription_usernom= new JLabel("NOM");
    public JLabel inscription_userpnom= new JLabel("PRENOM");
    public JLabel inscription_userage= new JLabel("AGE");
    public JLabel inscription_userlogin = new JLabel("LOGIN");
    public JLabel inscription_userpass = new JLabel("PASSWORD");
   
    public JTextField inscription_nom= new JTextField();
    public JTextField inscription_prenom= new JTextField();
    public JTextField inscription_age= new JTextField();
    public JTextField inscription_login= new JTextField();
    public JPasswordField inscription_password = new JPasswordField();
     
    public JButton inscription_inscrire_Button = new JButton("S'INSCRIRE");     

    //Fin Inscription Panel
    
    
    
    
    //Acceuil Panel
    
	JPanel acceuil_p=new JPanel();
	JPanel acceuil_haut=new JPanel();
	JPanel acceuil_moy=new JPanel();
    public JButton acceuil_b0,acceuil_b1,acceuil_b2,acceuil_b3,acceuil_b4,acceuil_b5;
    public JLabel acceuil_lbl;
    public JButton acceuil_accueil_btn,acceuil_espace_btn,acceuil_connecter_btn,acceuil_creer_btn;
    public LinkedList<Capteur> l;

    
    //Fin Acceuil Panel
    
    
    
    
    //Terrain Panel
    

    JLabel Terrain_sup= new JLabel("SUPERFICIE");
    JLabel Terrain_adresse= new JLabel("ADRESSE");
    JLabel Terrain_ville= new JLabel("VILLE");
    JLabel tlab;
    
   
    public JTextField Terrain_tsup= new JTextField();
    public JTextField Terrain_tadresse= new JTextField();
    public JTextField Terrain_tville= new JTextField();
   
     
    public JButton Terrain_Ajouter_Button = new JButton("AJOUTER");
    public JButton Terrain_Existe_Button = new JButton("Choisir un terrain existant");

    
    //Fin Terrain Panel
    
    
    
    
    
    //Infos Panel
    
    
    JLabel Infos_usernom= new JLabel("NOM");
    JLabel Infos_userpnom= new JLabel("PRENOM");
    JLabel Infos_userage= new JLabel("AGE");
    JLabel Infos_userlogin = new JLabel("LOGIN");
    JLabel Infos_userpass = new JLabel("PASSWORD");
   
    public JTextField Infos_nom= new JTextField();
    public JTextField Infos_prenom= new JTextField();
    public JTextField Infos_age= new JTextField();
    public JTextField Infos_login= new JTextField();
    public JPasswordField Infos_password = new JPasswordField();
     
    public JButton Infos_Modifier_Button = new JButton("MODIFIER");

    
    
    //Fin Infos Panel
    
    
    
    
    
    
    
    //Paiement Panel
    
    JLabel type= new JLabel("TYPE DE CARTE");
    JLabel num= new JLabel("NUMERO DE LA CARTE");
    JLabel code= new JLabel("CODE DE SECURITE");
    JLabel nom = new JLabel("NOM DU PROPRIETAIRE");
    JLabel date = new JLabel("DATE D'EXPIRATION");
    
    public String types[]={"VISA","MASTERCARD"};        
    public JComboBox tcb=new JComboBox(types); 
    DateFormat format = new SimpleDateFormat("MM/YYYY");
    public JFormattedTextField tdate= new JFormattedTextField(format);
    public JTextField tnum=new JTextField("");
    public JTextField tcode=new JTextField("");
    public JTextField tnom=new JTextField("");
    public JButton loginButton = new JButton("PAYER");

    
    
    //Espaaaaaaace
    public JPanel phaut;
	public JPanel Espace_Panel;

    //Voir Capteur
	public JButton bvoircapteur;
	public JPanel pvoircapteur=new JPanel();
	public JTable jtcap = new JTable();
	public JButton bretourcap;
	

	
	//Voir Terrain
	public JButton bvoirterrain;
	public JPanel pvoirterrain =new JPanel();
	public JTable jtter = new JTable();
	public JButton bretourter;

	//Voir Resultat
	public JButton bvoirdecision;
	public JButton bretourdec;
	public JPanel pvoirdecision=new JPanel();
	
    public JLabel tidvisualisert;
    public JTextField idvisualisert;

	
	//Modifier infos
	public JButton bmodifierInfos;
	public JButton bretourmod;
	public JPanel pmodifierInfos=new JPanel();
	//
	public JButton bacc;
	public JLabel usernom= new JLabel("NOM");
	public  JLabel userpnom= new JLabel("PRENOM");
	public  JLabel userage= new JLabel("AGE");
	public  JLabel userlogin = new JLabel("LOGIN");
	public  JLabel userpass = new JLabel("PASSWORD");
	   
	public  JTextField nomm= new JTextField();
	public   JTextField prenomm= new JTextField();
	public   JTextField agem= new JTextField();
	    public  JTextField loginm= new JTextField();
	    public  JPasswordField passwordm = new JPasswordField();
	     
	    public JButton loginButtonm = new JButton("MODIFIER");

	    
	    //voir Decision
	    
	     public JLabel tidvisualiser;
	     public JTextField idvisualiser;
	     public JButton visualiser;

	
	//
	public LinkedList<Capteur> listcap=new LinkedList();
//	public LinkedList<Terrain> listerr=new LinkedList();
}