package models;

public class LigneCommande {
	double cout_total;
	int quantite;
	public LigneCommande(double cout_total,int quantite) {
		this.cout_total=cout_total;
		this.quantite=quantite;
		
		
	}
	public double getCout_total() {
		return cout_total;
	}
	public void setCout_total(double cout_total) {
		this.cout_total = cout_total;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	

}
