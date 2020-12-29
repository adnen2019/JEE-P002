package metier;

import java.util.ArrayList;

public interface IMetierProd {
	
	public ArrayList <Produit>Search(String mc);
	public void Add(Produit p);
	public void Delete(int id);
	public void Update(Produit p);
	public Produit getProduit(int id);
	
}
