package models;



public class Personne {
	    protected int id;
        protected String nom;
        protected String prenom;
        public String login;
        private String password;
        protected String cin;
        protected String phoneNumber;
        protected String email;
        protected Personne(){}

        public Personne(int id,String nom, String prenom,String login, String password,String cin,String phoneNumber,String email){
            this.id=id;
        	this.nom=nom;
            this.prenom=prenom;
            this.login=login;
            this.password=password;
            this.cin=cin;
            this.phoneNumber=phoneNumber;
            this.email=email;


        }
        public Personne(int id,String nom,String prenom,String cin,String phoneNumber) {
        	 this.id=id;
         	this.nom=nom;
             this.prenom=prenom;
             this.cin=cin;
             this.phoneNumber=phoneNumber;
        }
        public Personne(String login,String password){
            this.login=login;
            this.password=password;
        }
      public  String getNom(){
            return nom;
        }
     public   String getPrenom(){
            return prenom;
        }
      public  String getlogin(){
            return login;
        }
       public String getPaasword(){
            return password;
        }

        public String getEmail(){
            return email;
        }
        public String getPhoneNumber(){
            return phoneNumber;
        }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}
	
}
