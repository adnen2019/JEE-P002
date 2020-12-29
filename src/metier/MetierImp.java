package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MetierImp implements IMetierProd {

	@Override
	public ArrayList<Produit> Search(String mc) {
		Connection con = SingletonConnection.getConnection();
		ArrayList <Produit> pl = new ArrayList<Produit>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM produit WHERE libelle LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet res = ps.executeQuery();//contient le resultat la requete
			while(res.next()) {
				Produit p = new Produit(res.getInt(1), res.getString(2), res.getDouble(3));
				pl.add(p);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pl;
	}

	@Override
	public void Add(Produit p) {
		Connection con = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO produit (libelle,prix) VALUES(?,?)");
			ps.setString(1, p.getLibelle());
			ps.setDouble(2,  p.getPrix());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void Delete(int id) {
		Connection con = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM produit WHERE id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Update(Produit p) {
		Connection con = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM produit WHERE id=?");
			ps.setInt(1, p.id);
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Produit getProduit(int id) {
		Connection con = SingletonConnection.getConnection();
		Produit p = new Produit();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM produit WHERE id=?");
			ps.setInt(1, id);
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				p.setId(res.getInt(1));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
}
