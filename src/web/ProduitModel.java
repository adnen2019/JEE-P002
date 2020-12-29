package web;

import java.util.ArrayList;

import metier.Produit;

public class ProduitModel {
	String MC;
	ArrayList<Produit> lp = new ArrayList<Produit>();
	
	public String getMC() {
		return MC;
	}
	public void setMC(String mC) {
		MC = mC;
	}
	public ArrayList<Produit> getLp() {
		return lp;
	}
	public void setLp(ArrayList<Produit> lp) {
		this.lp = lp;
	}
	
	
	
}
