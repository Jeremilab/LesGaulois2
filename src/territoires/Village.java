package territoires;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois=0;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois= new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if ( nbVillageois < villageois.length) {
			villageois[nbVillageois]= gaulois;
			nbVillageois++;
	    }else {
	    	System.out.println("Il y'a trop d'habitants.");
	    }
	}
	
	public Gaulois trouverHabitant(int nbReference) {
		return villageois[nbReference];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+ chef.getNom() +
				" vivent les l�gendaires gaulois:");
		for (int i=0;i < nbVillageois; i++) {
			System.out.println("-"+villageois[i].getNom());
		}
	}
	
	public static void main(String args[]) {
		Village village = new Village("Village des Irr�ductibles",30);
		System.out.println(village.getNom());
//		Gaulois gaulois = village.trouverHabitant(30);
//		Si il y a 30 villageois alors les indices sont 0 � 29
		Chef chef=new Chef("Abraracourix", 6, village);
		village.setChef(chef);
		Gaulois asterix = new Gaulois("Ast�rix",8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		null car asterix est le villageois 0
		Gaulois obelix=new Gaulois("Ob�lix",25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}