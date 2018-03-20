/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ouroboros.main;


import javax.swing.WindowConstants;
import ouroboros.classes.Ecran;
import ouroboros.ecrans.PremierEcran;
/**
 *
 * @author user
 */
public class Main
{
	public static void main(String[] args)
	{		
		Ecran eAccueil = new Ecran();
	    PremierEcran premierEcran = new PremierEcran();
	    premierEcran.ParametresPremierEcran(eAccueil);
	    eAccueil.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
