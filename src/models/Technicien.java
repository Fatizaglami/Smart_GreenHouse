package models;

import java.util.LinkedList;

public class Technicien extends Personne{
    protected LinkedList<Capteur>[] Capteur_a_Installer;
    protected String salaire;
    
    public Technicien() {
    	super();
    }

    public Technicien(int id,String nom, String prenom, String login, String password,String cin, String phoneNumber,String email, String salaire) {
        super(id,nom, prenom, login, password,cin,phoneNumber, email);
        this.salaire=salaire;

    }



    public Technicien(String login, String mdp) {
        super(login, mdp);

    }


    

    public LinkedList<Capteur>[] getCapteur_a_Installer() {
        return Capteur_a_Installer;
    }

    public void setCapteur_a_Installer(LinkedList<Capteur>[] capteur_a_Installer) {
        Capteur_a_Installer = capteur_a_Installer;
    }



	public String getSalaire() {
		return salaire;
	}



	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}


}
