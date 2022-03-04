package models;

public class Panier {
    private	int id_panier;
    private	int id_c;
    private String product_type;
    private String prix;
    private int quantite;
    
    
    public Panier() {}
    public Panier( int id_panier,int id_c, String product_type,String prix,int quantite ) {
    	            this.id_panier=id_panier;
    	            this.id_c=id_c;
    	            this.product_type=product_type;
    	            this.prix=prix;
    	            this.quantite=quantite;
    }
	public int getId_panier() {
		return id_panier;
	}
	public void setId_panier(int id_panier) {
		this.id_panier = id_panier;
	}
	public int getId_c() {
		return id_c;
	}
	public void setId_c(int id_c) {
		this.id_c = id_c;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
    
	

}
