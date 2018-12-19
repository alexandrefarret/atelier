package ProjetAtelier;

import java.rmi.dgc.Lease;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("BIENVENUE DANS L'ATELIER");
		
		Scanner sc = new Scanner(System.in);
		
		boolean configuration = true;
		
		// Matrice des distances entre les parcelles
		double distanceEntreParcelles[][]= new double[3][3];
		double tempsTotal =0;
		
		// Variables tampons
		int entree;
		String choix;
		int entierTemp;
		int entierTemp2;
		String chaineTemp;
		double doubleTemp;
		
		// Matrice renseignant les distances entre les parcelles 
		for(int i =0;i<3;i++)
		{
			for(int j = 0;j<3;j++)
			{
				doubleTemp = Math.random();
				if(distanceEntreParcelles[i][j]==0 && distanceEntreParcelles[j][i]==0 )
				{
					distanceEntreParcelles[i][j] = doubleTemp;
					distanceEntreParcelles[j][i] = doubleTemp;
				}
			}
		}
		
		
		Atelier monAtelier = new Atelier("Atelier island");
		
		Ilot ilot1 = new Ilot(1, "Perçage",0);
		Ilot ilot2 = new Ilot(2, "Vissage",1);
		Ilot ilot3 = new Ilot(3, "Pliage",2);
		
		monAtelier.lesIlots.add(ilot1);
		monAtelier.lesIlots.add(ilot2);
		monAtelier.lesIlots.add(ilot3);
		
		Operation fraisage = new Operation(1, "Fraisage", "Perçage");
		Operation vissage = new Operation(2, "Vissage", "Visseuse");
		Operation pliage = new Operation(3, "Pliage", "Pliseuse");
		
		Machine machine1 = new Machine(1, 1.0, fraisage, 4, 4);
		Machine machine2 = new Machine(2, 1.2, fraisage, 6, 6);
		Machine machine3 = new Machine(3, 1.0 , vissage,2,3);
		
		Stock stock1 = new Stock(123);
		
		Convoyeur convoyeur1 = new Convoyeur(1, 1.0);
		
		// Liste des phases dispo
		// Il faut y ajouter la phase dès sa création
		List<Phase> lesPhasesDispo = new ArrayList<Phase>();
		
		// Liste des opérations dispo
		// Il faut y ajouter les opérations dès leurs création
		List<Operation> lesOperationsDispo = new ArrayList<Operation>();
		
		// Liste des Gammes dispo
		// Il faut y ajouter les opérations dès leurs création
		List<Gamme> lesGammesDispo = new ArrayList<Gamme>();
		
		// Liste des Machine dispo
		// Il faut y ajouter les machines dès leurs création
		List<Machine> lesMachinesDispo = new ArrayList<Machine>();

		lesMachinesDispo.add(machine1);
		lesMachinesDispo.add(machine2);
		lesMachinesDispo.add(machine3);
		
		lesOperationsDispo.add(fraisage);
		lesOperationsDispo.add(vissage);
		lesOperationsDispo.add(pliage);
		
		do{
			menu();
			entree = sc.nextInt();
			switch(entree) {
			
				case 1:
					
					// Vérification de l'existance d'une opération
					if(lesOperationsDispo.isEmpty())
					{
						System.out.println("Il n'y a aucune opération, aucune phase ne peut être créée ! \n");
						break;
					}
					else
					{
						// Création d'une phase
						Operation operationTemp = new Operation();
						boolean testTemp = true;
						
						Phase unePhase = new Phase();
						System.out.println("Création d'une phase en cours ... \n");
						
						System.out.print("Veuillez renseigner le numéro de la phase : ");
						entierTemp = sc.nextInt();
						unePhase.setNumeroPhase(entierTemp);
						
						System.out.print("Veuillez renseigner le temps de réalisation : (en min)");
						entierTemp = sc.nextInt();
						unePhase.setTempsRealisation(entierTemp);
						
						System.out.print("Veuillez renseigner la date de début : (DD/MM/YYYY) ");
						chaineTemp = sc.next();
						unePhase.setDateDebutPhase(chaineTemp);
						
						System.out.print("Veuillez renseigner la date de fin : (DD/MM/YYYY) ");
						chaineTemp = sc.next();
						unePhase.setDateFinPhase(chaineTemp);
						
						// Demander le numéro de l'opération tant que celui-ci n'existe pas
						do
						{
							System.out.print("Veuillez renseigner le numéro de l'opération : ");
							entierTemp = sc.nextInt();
							operationTemp.setIdOperation(entierTemp);
							
							for(Operation monOperation : lesOperationsDispo)
							{
								if(monOperation.idOperation == entierTemp)
								{
									unePhase.setTypeOperation(monOperation);
									lesPhasesDispo.add(unePhase);
									operationTemp = monOperation;
									testTemp = false;
								}
							}
							if(unePhase.typeOperation == null)
							{
								System.out.println("L'opération n'existe pas !");
							}
						}
						while(testTemp);
					}
					break;
				
				case 2:
					
					// Vérification de l'existance d'une phase
					if(lesPhasesDispo.isEmpty())
					{
						System.out.println("Il n'y a aucune phase, aucune gamme ne peut être créée ! \n");
						break;
					}
					else
					{
						boolean testTemp = true;
						Phase phaseTemp = new Phase();
						
						Gamme uneGamme = new Gamme();
						System.out.println("Création d'une gamme en cours ... \n");
						
						System.out.print("Veuillez renseigner le numéro de la gamme : ");
						entierTemp = sc.nextInt();
						uneGamme.setNumProduit(entierTemp);
						
						System.out.print("Veuillez renseigner le nom du produit : ");
						chaineTemp = sc.next();
						uneGamme.setNomProduit(chaineTemp);
						
						// Tableau tampon permettant de stocker les phases saisis pour la gamme
						String[] tabPhases;
						
						// Demander le numéro de la phase tant que celui-ci n'existe pas
						do
						{
							
							System.out.print("Veuillez renseigner la(les) phase(s) :  (si plusieurs, à séparer avec une virgule)");
							chaineTemp = sc.next();
							tabPhases = chaineTemp.split(",");
							for(Phase maPhase : lesPhasesDispo)
							{
								for(String monIdPhase : tabPhases)
								{
									if(maPhase.numeroPhase == Integer.parseInt(monIdPhase))
									{
										uneGamme.lesPhases.add(maPhase);
										phaseTemp = maPhase;
										testTemp = false;
									}
										
										//phaseTemp.setNumeroPhase(Integer.parseInt(monIdPhase));
								}
							}
						}
						while(testTemp);
						lesGammesDispo.add(uneGamme);
						break;
					}
				case 3:
					// Simulation
					System.out.println("Simulation en cours ... \n");
					
					System.out.println("Veuillez choisir la gamme à simuler : (par son identifiant)");
					// Affichage de toutes les gammes existantes
					for(Gamme choixGamme : lesGammesDispo)
					{
						System.out.println(choixGamme.numProduit + " "+ choixGamme.nomProduit);
					}
					entierTemp = sc.nextInt();
					System.out.print("Combien d'unité :");
					entierTemp2 = sc.nextInt();
					
					// Pour chaques gammes
					for(Gamme maGamme : lesGammesDispo)
					{
						// Si la gamme choisit existe
						if(entierTemp == maGamme.numProduit)
						{
							System.out.println("Vous avez choisit la gamme " + maGamme.numProduit + " "+maGamme.nomProduit);
							// Pour chaques phases
							for(Phase laPhase : maGamme.lesPhases)
							{
								boolean testTemp = true;
								// Pour chaques machines
								for(Machine laMachine : lesMachinesDispo)
								{
									// On compare le type de machine de la phase avec le type de la machine
									if(laMachine.Operation.equals(laPhase.typeOperation) && testTemp)
									{
										tempsTotal += laPhase.tempsRealisation*laMachine.coeffVitesse;
										testTemp = false;
									}
								}
							}
						}
					}
					// On multiplie par le nombre d'unitée
					tempsTotal *= entierTemp2;
					System.out.println("Le temps de création est de " + tempsTotal);
					break;
					
				default:
			}
		}
		while(configuration == true);
		sc.close();
	}
	
	/**
	 * Affiche le texte du menu
	 */
	public static void menu()
	{
		affiche("\n"+ "TAPER 1 - Créer une Phase \n" + 
				"TAPER 2 - Créer une Gamme \n" + 
				"TAPER 3 - Lancer la simulation");
	}
	
	/**
	 * Affiche le texte
	 * @param text texte à afficher
	 */
	public static void  affiche(String text) {
		System.out.println(text);
	}
	
	

}
