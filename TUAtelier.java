package ProjetAtelier;

public class TUAtelier {

	public static void main(String[] args) {

		Atelier unAtelier = new Atelier("Notre atelier", 6);
		
		unAtelier.creationTempsParcelle();
		
		unAtelier.afficher();
	}

}
