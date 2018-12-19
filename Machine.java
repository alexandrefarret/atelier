//=============================================================================//
//                    Nom du fichier : "Machine.java"                          //
//                    Auteur         : Alexandre Farret                        //
//                    Date création  : 12/12/2018                              //
//                    Date MAJ       : 15/12/2018                              //
//=============================================================================//

package ProjetAtelier; //test

import ProjetAtelier.Phase;

public class Machine 
{
	//******* Attributs *******//
	protected int numeroMachine;
	protected Operation Operation;
	protected double coeffVitesse;
	protected Stock fileEntree;
	protected Stock fileSortie;
	protected int nbPlacesEntree;
	protected int nbPlacesSortie;
	
	//******* Méthodes *******//
	/**
	 * Constructeur	
	 * @param numero Numéro de la machine
	 * @param vitesse Vitesse de la machine
	 * @param fonction Operation de la machine
	 * @param placeEntree Nombre de place en entrée de la machine
	 * @param placeSortie Nombre de place en sortie de la machine
	 */
	public Machine(int numero, double vitesse, Operation fonction, int placeEntree, int placeSortie)
	{
		fileEntree = new Stock(placeEntree);
		fileSortie = new Stock(placeSortie);
		coeffVitesse = vitesse;
		numeroMachine = numero;
		Operation = fonction;
		nbPlacesEntree = placeEntree;
		nbPlacesSortie = placeSortie;
	}
	
	//Permet d'ajouter un élément à la liste d'entrée
	public boolean ajouterObjet(Phase obj)
	{
		boolean reponse = fileEntree.ajouterElement(obj);
		return reponse;
	}
	
	//Enlève le dernier élément (FIFO) à la liste de sortie
	public void objetTermine()
	{
		fileSortie.enleverElement();
	}
	
	//Réalise l'opération
	public boolean operation()
	{
		Phase objetPret = fileEntree.prochainElement();
		boolean verdict = fileSortie.ajouterElement(objetPret);
		if (verdict == false )
		{
			return false; //Liste sortie pleine, on ne fait rien
		}
		else
		{
			fileEntree.enleverElement();
			return true; //Objet travaillé, on l'enlève de la liste d'entrée
		}
	}
	
	//Affiche l'ensemble des files de la machine
	public void afficherFiles()
	{
		System.out.println("Objet en attente :");
		fileEntree.afficherStock();
		System.out.println("Objet terminé :");
		fileSortie.afficherStock();
	}
	
	//Retourne le temps de réalisation d'un phase
	public double tempsDeLaPhase(Phase phaseATraiter)
	{
		return phaseATraiter.getTempsRealisation();
	}
	
	//Lance une simulation
	//Attention, cette méthode correspond à une opération seulement
	//Il faut donc ajouter un objet en entrée et sortir un objet en sortie en utilisant les bonnes méthodes dans cette classe
	public double simulationSequence()
	{
		try
		{
			double tmpsTotal;
			double tempsPhase = this.tempsDeLaPhase(fileEntree.prochainElement());
			tmpsTotal = tempsPhase * coeffVitesse;
			boolean statutSortie = this.operation();
			if ( statutSortie == false )
			{
				//Liste sortie pleine
				return 0.00000000001;
			}
			else
			{
				return tmpsTotal;
			}
		}
		catch (IndexOutOfBoundsException e)
		{
			//La liste d'entrée est vide...
			return 0.00000000002;
		}
	}
	
	//Retourne numéro machine
	public int getNumeroMachine() { return numeroMachine; }
	
	//Retourne la taille du stock d'entrée
	public int tailleStockEntree() { return fileEntree.tailleStock(); }
	
	//Retourne la taille du stock de sortie
	public int tailleStockSortie() { return fileSortie.tailleStock(); }
	
	//Retourne la taille max du stock d'entrée
	public int getNbPlacesEntree() { return nbPlacesEntree; }
	
	//Retourne la taille max du stock de sortie
	public int getNbPlacesSortie() { return nbPlacesSortie; }
}