package models;

public class Client extends Personne{
    protected String addresse;
    public Client() {
    	super();
    }

    public Client(int id,String nom, String prenom, String login, String password,String cin,String addresse, String phoneNumber,String email) {
        super(id,nom, prenom, login, password,cin,phoneNumber,email);
        this.addresse=addresse;

    }
    public Client(int id,String nom,String prenom,String cin,String phoneNumber) {
    	super(id,nom,prenom,cin,phoneNumber);
    	
    }


    


    public Client (String login,String mdp) {
        super(login,mdp);
    }

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

   
}
