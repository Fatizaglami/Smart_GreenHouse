package models;

import java.util.Date;

public class Commande extends Personne{
	private int num_commande;
	private Date date_commande;
	private int id_C;
	public Commande(int id,String nom,String prenom,String cin,String phoneNumber, Date date_commande) {
    	super(id,nom,prenom,cin,phoneNumber);
    	this.date_commande=date_commande;
    }
	public int getNum_commande() {
		return num_commande;
	}
	public void setNum_commande(int num_commande) {
		this.num_commande = num_commande;
	}
	public Date getDate_commande() {
		return date_commande;
	}
	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}
	public int getId_C() {
		return id_C;
	}
	public void setId_C(int id_C) {
		this.id_C = id_C;
	}
	
	
}
