package metier;

public class Test {

	public static void main(String[] args) {
		IMetierProd metier = new MetierImp();
		metier.Add(new Produit("PC", 1000));
		metier.Add(new Produit("PC", 900));
		metier.Add(new Produit("PC", 100));
		
		System.out.println(metier.Search("PC").toString());
	}

}
