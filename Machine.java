//=============================================================================//
//                    Name of file : "Machine.java"                            //
//                    Author         : Alexandre Farret                        //
//                    Creation date  : 12/12/2018                              //
//                    Last update       : 16/12/2018                           //
//=============================================================================//

package ProjetAtelier;

import ProjetAtelier.Phase;

public class Machine 
{
	//******* Attributes *******//
	protected int numeroMachine;
	protected Operation Operation;
	protected double coeffVitesse;
	protected Stock fileEntree;
	protected Stock fileSortie;
	protected int nbPlacesEntree;
	protected int nbPlacesSortie;
	protected Ilot ilotMachine;
	
	//******* Methods *******//
	
	public Machine()
	{
	}
	/**
	 * Constructor	
	 * @param numero number of machine
	 * @param vitesse speed of the machine
	 * @param fonction Operation of machine
	 * @param placeEntree Number of places in entry
	 * @param placeSortie Number of places in out
	 * @param ilotMachine Ilot of the machine
	 */
	public Machine(int numero, double vitesse, Operation fonction, int placeEntree, int placeSortie, Ilot ilotMachine)
	{
		fileEntree = new Stock(placeEntree);
		fileSortie = new Stock(placeSortie);
		coeffVitesse = vitesse;
		numeroMachine = numero;
		Operation = fonction;
		nbPlacesEntree = placeEntree;
		nbPlacesSortie = placeSortie;
		this.ilotMachine = ilotMachine;
	}
	
	// To add an element of entry list
	public boolean ajouterObjet(Phase obj)
	{
		boolean reponse = fileEntree.ajouterElement(obj);
		return reponse;
	}
	
	 
	//To delete the last element (FIFO)
	public void objetTermine()
	{
		fileSortie.enleverElement();
	}
	
	//Make operation
	public boolean operation()
	{
		Phase objetPret = fileEntree.prochainElement();
		boolean verdict = fileSortie.ajouterElement(objetPret);
		if (verdict == false )
		{
			//unavailable, it's full
			return false; 
		}
		else
		{
			//Maked, it must be removed
			fileEntree.enleverElement();
			return true; 
		}
	}
	
	//Display all lines of the machine
	public void afficherFiles()
	{
		System.out.println("Objet en attente :");
		fileEntree.afficherStock();
		System.out.println("Objet termin� :");
		fileSortie.afficherStock();
	}
	//Return time to realise a phase
	public double tempsDeLaPhase(Phase phaseATraiter)
	{
		return phaseATraiter.getTempsRealisation();
	}
	
	//Start of simulation
	//Attention, this method must to belongs one operation
	//it must be add one abject in entry and exit an object in out with the good methods
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
				//full output list
				return 0.00000000001;
			}
			else
			{
				return tmpsTotal;
			}
		}
		catch (IndexOutOfBoundsException e)
		{
			//the entry list is empty
			return 0.00000000002;
		}
	}
	
	//Return number of machine
	public int getNumeroMachine() { return numeroMachine; }
	
	//Return the size of the input stock
	public int tailleStockEntree() { return fileEntree.tailleStock(); }
	
	//Return the size of the output stock
	public int tailleStockSortie() { return fileSortie.tailleStock(); }
	
	//Return the max size of the input
	public int getNbPlacesEntree() { return nbPlacesEntree; }
	
	//Return the max size of the output stock
	public int getNbPlacesSortie() { return nbPlacesSortie; }

	public Operation getOperation() {
		return Operation;
	}

	public void setOperation(Operation operation) {
		Operation = operation;
	}

	public double getCoeffVitesse() {
		return coeffVitesse;
	}

	public void setCoeffVitesse(double coeffVitesse) {
		this.coeffVitesse = coeffVitesse;
	}

	public Stock getFileEntree() {
		return fileEntree;
	}

	public void setFileEntree(Stock fileEntree) {
		this.fileEntree = fileEntree;
	}

	public Stock getFileSortie() {
		return fileSortie;
	}

	public void setFileSortie(Stock fileSortie) {
		this.fileSortie = fileSortie;
	}

	public void setNumeroMachine(int numeroMachine) {
		this.numeroMachine = numeroMachine;
	}

	public void setNbPlacesEntree(int nbPlacesEntree) {
		this.nbPlacesEntree = nbPlacesEntree;
	}

	public void setNbPlacesSortie(int nbPlacesSortie) {
		this.nbPlacesSortie = nbPlacesSortie;
	}
	public Ilot getIlotMachine() {
		return ilotMachine;
	}
	public void setIlotMachine(Ilot ilotMachine) {
		this.ilotMachine = ilotMachine;
	}
}