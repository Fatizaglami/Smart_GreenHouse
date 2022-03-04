package models;

public class StockCapteur {
	protected int id_capteur;
    protected String type;
    protected String prix;
    protected String desc;
    protected int quantité;

    public StockCapteur (){

    }
    public StockCapteur(int id_capteur, String type, String prix, String desc,int quantité){
        this.id_capteur=id_capteur;
        this.type=type;
        this.prix=prix;
        this.desc=desc;
        this.quantité=quantité;
    }
	public int getId_capteur() {
		return id_capteur;
	}
	public void setId_capteur(int id_capteur) {
		this.id_capteur = id_capteur;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getQuantité() {
		return quantité;
	}
	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}
    
}
