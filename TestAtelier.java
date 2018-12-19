/*package ProjetAtelier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestAtelier {

	public static void main(String[] args) {
		
		// Création des opérations
		Operation percage = new Operation(1, "Perçage","Perçeuse");
		Operation vissage = new Operation(2, "Vissage", "Visseuse");
		Operation tounage = new Operation(3, "Tournage", "Tourneuse");
		Operation pliage =  new Operation(4, "Pliage", "Pliseuse");
		
		// Liste des phases dispo
		// Il faut y ajouter la phase dès sa création
		List<Phase> lesPhasesDispo = new ArrayList<Phase>();
		
		// Création des phases
		Phase phase1A = new Phase(1, percage, 23, "12/02/2015", "13/02/2015");
		Phase phase2A = new Phase(2, vissage, 28, "12/02/2015", "13/06/2015");
		Phase phase3A = new Phase(3, pliage, 14, "12/02/2015", "14/02/2015");
		Phase phase4A = new Phase(4, tounage, 2, "10/01/2017", "15/01/2017");
		
		// Ajout des phases dans la liste
		lesPhasesDispo.add(phase1A);
		lesPhasesDispo.add(phase2A);
		lesPhasesDispo.add(phase3A);
		lesPhasesDispo.add(phase4A);
		
		// Création de la gamme
		Gamme laPlanche = new Gamme(2, "SkateBoard");
		
		boolean ok = true;
		int i = 1;
		Scanner scan = new Scanner(System.in);
		// Phase tampon permettant de stocker le numPhase
		Phase phaseTemp = new Phase(0, null, 0, null, null);
		do
		{
			System.out.print("Quelle est le numéro de la phase " + i + " : ");
			phaseTemp.numeroPhase = scan.nextInt();
			for(Phase laPhaseTest : lesPhasesDispo)
			{
				// Comparaison entre le numéro de la phase tampon avec les phases dispo
				// Si elle existe on l'ajoute à la liste des phases de la Gamme
				if(laPhaseTest.numeroPhase == phaseTemp.numeroPhase)
				{
					laPlanche.lesPhases.add(laPhaseTest);
				}
				else
				{
					System.out.println("Cette phase n'existe pas !!!");
				}
			}
			i++;
			System.out.print("Continuer à ajouter ? (1 Oui / 0 Non) : ");
			if(scan.nextInt() != 1)
			{
				ok = false;
			}
			
		}
		while(ok);
		scan.close();
		
		// Fin de création de la gamme
		
		laPlanche.affichePhases();
	}

}*/
