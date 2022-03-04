package models;

public class Serre extends Client {
  private double metrage;
  public Serre() {
	  super();
  }
  
  public Serre(int id,String nom,String prenom,String cin, String phoneNumber, double metrage) {
	  super(id,nom,prenom,cin,phoneNumber);
	  this.metrage=metrage;
  }

public double getMetrage() {
	return metrage;
}

public void setMetrage(double metrage) {
	this.metrage = metrage;
}
  
}
