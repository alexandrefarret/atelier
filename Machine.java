package ProjetAtelier;

import ProjetAtelier.Phase;

public class Machine 
{
	//******* Attributes *******//
	protected int iNumeroMachine;
	protected Operation Operation;
	protected double dCoeffVitesse;
	protected Stock fileEntree;
	protected Stock fileSortie;
	protected int iNbPlacesEntree;
	protected int iNbPlacesSortie;
	protected Ilot ilotMachine;
	
	//******* Methods *******//
	
	public Machine()
	{
	} 
	
	/**
	 * Constructor	
	 * @param iNumero number of machine
	 * @param dVitesse speed of the machine
	 * @param fonction Operation of machine
	 * @param iPlaceEntree Number of places in entry
	 * @param iPlaceSortie Number of places in out
	 * @param ilotMachine Ilot of the machine
	 */
	public Machine(int iNumero, double dVitesse, Operation fonction, int iPlaceEntree, int iPlaceSortie, Ilot ilotMachine)
	{
		fileEntree = new Stock(iPlaceEntree);
		fileSortie = new Stock(iPlaceSortie);
		dCoeffVitesse = dVitesse;
		iNumeroMachine = iNumero;
		Operation = fonction;
		iNbPlacesEntree = iPlaceEntree;
		iNbPlacesSortie = iPlaceSortie;
		this.ilotMachine = ilotMachine;
	}
	
	// To add an element of entry list
	public boolean ajouterObjet(Phase obj)
	{
		boolean bReponse = fileEntree.ajouterElement(obj);
		return bReponse;
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
		boolean bVerdict = fileSortie.ajouterElement(objetPret);
		if (bVerdict == false )
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
		System.out.println("Objet terminé :");
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
			double dTmpsTotal;
			double dTempsPhase = this.tempsDeLaPhase(fileEntree.prochainElement());
			dTmpsTotal = dTempsPhase * dCoeffVitesse;
			boolean statutSortie = this.operation();
			if ( statutSortie == false )
			{
				//full output list
				return 0.00000000001;
			}
			else
			{
				return dTmpsTotal;
			}
		}
		catch (IndexOutOfBoundsException e)
		{
			//the entry list is empty
			return 0.00000000002;
		}
	}
	
	//Return number of machine
	public int getNumeroMachine() { return iNumeroMachine; }
	
	//Return the size of the input stock
	public int tailleStockEntree() { return fileEntree.tailleStock(); }
	
	//Return the size of the output stock
	public int tailleStockSortie() { return fileSortie.tailleStock(); }
	
	//Return the max size of the input
	public int getNbPlacesEntree() { return iNbPlacesEntree; }
	
	//Return the max size of the output stock
	public int getNbPlacesSortie() { return iNbPlacesSortie; }

	public Operation getOperation() {
		return Operation;
	}

	public void setOperation(Operation operation) {
		Operation = operation;
	}

	public double getCoeffVitesse() {
		return dCoeffVitesse;
	}

	public void setCoeffVitesse(double dCoeffVitesse) {
		this.dCoeffVitesse = dCoeffVitesse;
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

	public void setNumeroMachine(int iNumeroMachine) {
		this.iNumeroMachine = iNumeroMachine;
	}

	public void setNbPlacesEntree(int iNbPlacesEntree) {
		this.iNbPlacesEntree = iNbPlacesEntree;
	}

	public void setNbPlacesSortie(int iNbPlacesSortie) {
		this.iNbPlacesSortie = iNbPlacesSortie;
	}
	public Ilot getIlotMachine() {
		return ilotMachine;
	}
	public void setIlotMachine(Ilot ilotMachine) {
		this.ilotMachine = ilotMachine;
	}
}