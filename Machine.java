//=============================================================================//
//                    Nom du fichier : "Machine.java"                          //
//                    Auteur         : Alexandre Farret                        //
//                    Date cr�ation  : 12/12/2018                              //
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
	
	//******* M�thodes *******//
	/**
	 * Constructeur	
	 * @param numero Num�ro de la machine
	 * @param vitesse Vitesse de la machine
	 * @param fonction Operation de la machine
	 * @param placeEntree Nombre de place en entr�e de la machine
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
	
	//Permet d'ajouter un �l�ment � la liste d'entr�e
	public boolean ajouterObjet(Phase obj)
	{
		boolean reponse = fileEntree.ajouterElement(obj);
		return reponse;
	}
	
	//Enl�ve le dernier �l�ment (FIFO) � la liste de sortie
	public void objetTermine()
	{
		fileSortie.enleverElement();
	}
	
	//R�alise l'op�ration
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
			return true; //Objet travaill�, on l'enl�ve de la liste d'entr�e
		}
	}
	
	//Affiche l'ensemble des files de la machine
	public void afficherFiles()
	{
		System.out.println("Objet en attente :");
		fileEntree.afficherStock();
		System.out.println("Objet termin� :");
		fileSortie.afficherStock();
	}
	
	//Retourne le temps de r�alisation d'un phase
	public double tempsDeLaPhase(Phase phaseATraiter)
	{
		return phaseATraiter.getTempsRealisation();
	}
	
	//Lance une simulation
	//Attention, cette m�thode correspond � une op�ration seulement
	//Il faut donc ajouter un objet en entr�e et sortir un objet en sortie en utilisant les bonnes m�thodes dans cette classe
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
			//La liste d'entr�e est vide...
			return 0.00000000002;
		}
	}
	
	//Retourne num�ro machine
	public int getNumeroMachine() { return numeroMachine; }
	
	//Retourne la taille du stock d'entr�e
	public int tailleStockEntree() { return fileEntree.tailleStock(); }
	
	//Retourne la taille du stock de sortie
	public int tailleStockSortie() { return fileSortie.tailleStock(); }
	
	//Retourne la taille max du stock d'entr�e
	public int getNbPlacesEntree() { return nbPlacesEntree; }
	
	//Retourne la taille max du stock de sortie
	public int getNbPlacesSortie() { return nbPlacesSortie; }
}