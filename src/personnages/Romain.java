package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement =0;
	private Equipement[] equipements;
	
	public Romain(String nom, int force) {
		assert(force>0):"force négative";
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
	}
	
	public String getNom() {
		return nom;
	}
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert(force>0):"force négative";
		int forceAvant=force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert(forceAvant>force):"force n'a pas diminué";
	}
	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
				case 2: {
					System.out.println("Le soldat " + nom + " est deja bien protégé !");
					break;
				}
				case 1: {
					if (equipements[0] == equipement) {
						System.out.println("Le soldat " + nom + " possede déjà un " + 
								equipement + ".");
						break;
					} else {
						equipement(equipement);
						break;
					}
				}
				default : {
					equipement(equipement);
					break;
				}
			}
		}
	private void equipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'equipe d'un " + 
				equipement + ".");
	}
	
	
	public static void main(String[] args) {
		Romain cesar = new Romain("Cesar", 20);
		System.out.println(cesar.prendreParole());
		cesar.parler("Bonjour");
		cesar.recevoirCoup(10);
		cesar.recevoirCoup(15);
		System.out.println(Equipement.BOUCLIER);
		System.out.println(Equipement.CASQUE);
		cesar.sEquiper(Equipement.CASQUE);
		cesar.sEquiper(Equipement.CASQUE);
		cesar.sEquiper(Equipement.BOUCLIER);
		cesar.sEquiper(Equipement.CASQUE);
	}

}
