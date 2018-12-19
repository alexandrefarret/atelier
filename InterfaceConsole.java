package ProjetAtelier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfaceConsole {
	
	public static void main(String[] args) {
		
		System.out.println("BIENVENUE DANS L'ATELIER");
		
		Scanner sc = new Scanner(System.in);
		
		boolean bConfiguration = true;
		
		double dTempsTotal =0;
		
		// Variables tampons
		int iEntree;
		String sChoix;
		int iEntierTemp;
		int iEntierTemp2;
		String sChaineTemp;
		double dDoubleTemp;
		Machine machineTemp = new Machine();

		Atelier monAtelier = new Atelier("Atelier island", 3);
		
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

		// Test variables
		
		Ilot ilot1 = new Ilot(1, "Perçage",0);
		Ilot ilot2 = new Ilot(2, "Vissage",1);
		Ilot ilot3 = new Ilot(3, "Pliage",2);
		
		monAtelier.lesIlots.add(ilot1);
		monAtelier.lesIlots.add(ilot2);
		monAtelier.lesIlots.add(ilot3);
		
		Operation fraisage = new Operation(1, "Fraisage", "Perçage");
		Operation vissage = new Operation(2, "Vissage", "Visseuse");
		Operation pliage = new Operation(3, "Pliage", "Pliseuse");
		
		Machine machine1 = new Machine(1, 1.0, fraisage, 4, 4,ilot1);
		Machine machine2 = new Machine(2, 1.2, vissage, 6, 6,ilot2);
		Machine machine3 = new Machine(3, 1.0 , vissage,2,3,ilot3);
		
		Convoyeur convoyeur1 = new Convoyeur(1, 1.0);
		
		Phase phase1 = new Phase(1, fraisage, 12, "x", "x");
		Phase phase2 = new Phase(2, vissage, 20, "x", "x");
		
		Gamme gamme1 = new Gamme(1, "Test");
		gamme1.getLesPhases().add(phase1);
		gamme1.getLesPhases().add(phase2);
		
		lesGammesDispo.add(gamme1);
		
		lesPhasesDispo.add(phase1);
		lesPhasesDispo.add(phase2);
		
		lesMachinesDispo.add(machine1);
		lesMachinesDispo.add(machine2);
		lesMachinesDispo.add(machine3);
		
		lesOperationsDispo.add(fraisage);
		lesOperationsDispo.add(vissage);
		lesOperationsDispo.add(pliage);
		
		do{
			menu();
			iEntree = sc.nextInt();
			switch(iEntree) {
			
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
						boolean bTestTemp = true;
						
						Phase unePhase = new Phase();
						System.out.println("Création d'une phase en cours ... \n");
						
						// Check if the phase number already exist
						do
						{
							int iPhaseCpt = 0;
							System.out.print("Veuillez renseigner le numéro de la phase : ");
							iEntierTemp = sc.nextInt();

							
							for(Phase laPhase : lesPhasesDispo)
							{
								if(!(laPhase.iNumeroPhase == iEntierTemp))
								{
									iPhaseCpt++;
								}
							}
							if(lesPhasesDispo.size() == iPhaseCpt)
							{
									bTestTemp = false;
									unePhase.setNumeroPhase(iEntierTemp);
							}
						}
						while(bTestTemp);
						
						System.out.print("Veuillez renseigner le temps de réalisation : (en min)");
						iEntierTemp = sc.nextInt();
						unePhase.setTempsRealisation(iEntierTemp);
						
						System.out.print("Veuillez renseigner la date de début : (DD/MM/YYYY) ");
						sChaineTemp = sc.next();
						unePhase.setDateDebutPhase(sChaineTemp);
						
						System.out.print("Veuillez renseigner la date de fin : (DD/MM/YYYY) ");
						sChaineTemp = sc.next();
						unePhase.setDateFinPhase(sChaineTemp);
						
						bTestTemp = true;
						// Demander le numéro de l'opération tant que celui-ci n'existe pas
						do
						{
							System.out.print("Veuillez renseigner le numéro de l'opération : ");
							iEntierTemp = sc.nextInt();
							operationTemp.setIdOperation(iEntierTemp);
							
							for(Operation monOperation : lesOperationsDispo)
							{
								if(monOperation.iIdOperation == iEntierTemp)
								{
									unePhase.setTypeOperation(monOperation);
									lesPhasesDispo.add(unePhase);
									operationTemp = monOperation;
									bTestTemp = false;
								}
							}
							if(unePhase.typeOperation == null)
							{
								System.out.println("L'opération n'existe pas !");
							}
						}
						while(bTestTemp);
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
						boolean bTestTemp = true;
						Phase phaseTemp = new Phase();
						
						Gamme uneGamme = new Gamme();
						System.out.println("Création d'une gamme en cours ... \n");
						
						bTestTemp = true;
						// Check if the Gamme number already exist
						do
						{
							int iGammeCpt = 0;
							System.out.print("Veuillez renseigner le numéro de la gamme : ");
							iEntierTemp = sc.nextInt();

							
							for(Gamme laGamme : lesGammesDispo)
							{
								if(!(laGamme.iNumProduit == iEntierTemp))
								{
									iGammeCpt++;
								}
							}
							if(lesGammesDispo.size() == iGammeCpt)
							{
									bTestTemp = false;
									uneGamme.setNumProduit(iEntierTemp);
							}
						}
						while(bTestTemp);
						
						System.out.print("Veuillez renseigner le nom du produit : ");
						sChaineTemp = sc.next();
						uneGamme.setNomProduit(sChaineTemp);
						
						// Tableau tampon permettant de stocker les phases saisis pour la gamme
						String[] sTabPhases;
						
						// Demander le numéro de la phase tant que celui-ci n'existe pas
						do
						{
							
							System.out.print("Veuillez renseigner la(les) phase(s) :  (si plusieurs, à séparer avec une virgule)");
							sChaineTemp = sc.next();
							sTabPhases = sChaineTemp.split(",");
							for(Phase maPhase : lesPhasesDispo)
							{
								for(String monIdPhase : sTabPhases)
								{
									if(maPhase.iNumeroPhase == Integer.parseInt(monIdPhase))
									{
										uneGamme.lesPhases.add(maPhase);
										phaseTemp = maPhase;
										bTestTemp = false;
									}
										
										//phaseTemp.setNumeroPhase(Integer.parseInt(monIdPhase));
								}
							}
						}
						while(bTestTemp);
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
						System.out.println(choixGamme.iNumProduit + " "+ choixGamme.sNomProduit);
					}
					iEntierTemp = sc.nextInt();
					System.out.print("Combien d'unité :");
					iEntierTemp2 = sc.nextInt();
					
					// Pour chaques gammes
					for(Gamme maGamme : lesGammesDispo)
					{
						// Si la gamme choisit existe
						if(iEntierTemp == maGamme.iNumProduit)
						{
							iEntierTemp = 0 ;
							dTempsTotal = 0;
							System.out.println("Vous avez choisit la gamme " + maGamme.iNumProduit + " "+maGamme.sNomProduit);
							// Pour chaques phases
							for(Phase laPhase : maGamme.lesPhases)
							{
								boolean bTestTemp = true;
								// Pour chaques machines
								for(Machine laMachine : lesMachinesDispo)
								{
									// On compare le type de machine de la phase avec le type de la machine
									if(laMachine.Operation.equals(laPhase.typeOperation) && bTestTemp)
									{
										if(iEntierTemp == 0)
										{
											dTempsTotal += laPhase.iTempsRealisation*laMachine.dCoeffVitesse;
											bTestTemp = false;
											machineTemp.setIlotMachine(laMachine.getIlotMachine());
											machineTemp.getIlotMachine().setParcelle(laMachine.getIlotMachine().getParcelle());
											iEntierTemp++;
										}
										else
										{
											dTempsTotal += laPhase.iTempsRealisation*laMachine.dCoeffVitesse;
											dTempsTotal += 
											monAtelier.iTTempsTransfertParcelle[machineTemp.getIlotMachine().getParcelle()][laMachine.getIlotMachine().getParcelle()]*convoyeur1.dCoefficientDeplacement;
											machineTemp.setIlotMachine(laMachine.getIlotMachine());
											machineTemp.getIlotMachine().setParcelle(laMachine.getIlotMachine().getParcelle());
											bTestTemp = false;
										}
										
									}
								}
							}
						}
					}
					// On multiplie par le nombre d'unitée
					dTempsTotal *= iEntierTemp2;
					System.out.println("Le temps de création est de " + dTempsTotal);
					break;
				
				case 4:
					bConfiguration = false;
					break;
				default:
			}
		}
		while(bConfiguration == true);
		sc.close();
	}
	
	/**
	 * Affiche le texte du menu
	 */
	public static void menu()
	{
		affiche("\n"+ "TAPER 1 - Créer une Phase \n" + 
				"TAPER 2 - Créer une Gamme \n" + 
				"TAPER 3 - Lancer la simulation \n" + 
				"TAPER 4 - Quitter");
	}
	
	/**
	 * Affiche le texte
	 * @param text texte à afficher
	 */
	public static void  affiche(String text) {
		System.out.println(text);
	}
	
	

}
