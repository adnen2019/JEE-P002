package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.IMetierProd;
import metier.MetierImp;
import metier.Produit;

@WebServlet(name = "CS", urlPatterns = {"/control", "*.do"})
public class ControleurServlet extends HttpServlet {
	
	IMetierProd metier;
	@Override
	public void init() throws ServletException {
		metier = new MetierImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		if (path.equals("/delete.do")) {
			int x = Integer.parseInt(req.getParameter("id"));
			metier.Delete(x);
			resp.sendRedirect("search.do?motCle=");
			
		} else if (path.equals("/search.do")) {
			String mc = req.getParameter("motCle");
			ProduitModel pm = new ProduitModel();
			pm.setMC(mc);
			ArrayList<Produit> pr = metier.Search(mc);
			pm.setLp(pr);
			req.setAttribute("res", pm);
			req.getRequestDispatcher("VueProduit.jsp").forward(req, resp);
			
		} else if (path.equals("/save.do") && req.getMethod().equals("POST")) {
			String x = req.getParameter("libelle");
			double y = Double.parseDouble(req.getParameter("prix"));
			Produit p = new Produit(x, y);
			metier.Add(p);
			req.getRequestDispatcher("SaisiProduit.jsp").forward(req, resp);
			
		} else if (path.equals("/saisie.do")) {
			req.getRequestDispatcher("SaisiProduit.jsp").forward(req, resp);
			
		} else {
			req.getRequestDispatcher("VueProduit.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
