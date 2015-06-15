package projet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestProjet {

	public static void main(String[] args) {
		
		Scanner n = new Scanner(System.in);
		Terrain t= new Terrain();
		Choix choix = new Choix();
		Attaquer attaque = new Attaquer();
		Personnage p1 = new Personnage();
		Personnage p2 = new Personnage();
		p1.setNumJoueur(1);
		p2.setNumJoueur(2);
		
		int choisir=1;
		Personnage joueur ;
		Personnage joueuradv;
		int compteur=1;
				 
		SimpleDateFormat formatter = new SimpleDateFormat ("HH:mm" );
		Date currentTime = new Date();
		String dateString = formatter.format(currentTime);
		String carac = ""+dateString.charAt(3)+dateString.charAt(4);
	
		t.setTab(4, 5, String.valueOf(p1.getNumJoueur()));
		t.setTab(15, 16, "2");
		System.out.println("******************* Tour de premiere joueur *******************");
		System.out.println("Personnaliser votre personnage ");
		p1.initialisation();
		p1.setMinuteDeCreation(Integer.parseInt(carac));
		System.out.println(p1.toString());
		System.out.println("******************* Tour de deuxième joueur *******************");
		System.out.println("Personnaliser votre personnage ");
		p2.initialisation();
		p2.setMinuteDeCreation(Integer.parseInt(carac));
		System.out.println(p2.toString());
		
		while((p1.perdu()==false)&&(p2.perdu()==false)&&(choisir!=5)){	
			if(compteur%2!=0){
				joueur=p1;
				joueuradv=p2;
			}
			else{
				joueur=p2;
				joueuradv=p1;
			}
			System.out.println("*********************"+"C'est le tour de Joueur n°"+joueur.getNumJoueur()+"*********************");
			System.out.println(t.toString());
			System.out.println(joueur.toString());
			if(joueur.getBlessure()<2){
				System.out.println(" Votre personnage ne peux plus jouer, il est inconscient, il a besoin d'une potion de soin ");
				int nj=0;
				boolean verifnj=false;
				while((nj<4)&&(verifnj==false)){
					if((joueur.getOpj().getactionObject(nj).equals("S"))&&(joueur.getOpj().getNomObject(nj).equals("potion de Soin"))){
						System.out.println("Voulez vous utiliser votre potion de soin maintenant y/n");
						String choixnj=n.nextLine();
						if(choixnj.equals("y")){
							if((joueur.getBlessure()+3)>6){
								joueur.setBlessure(6);
							}
							else {
								joueur.setBlessure(joueur.getBlessure()+3);
							}
						}
						else{
							System.out.println("Votre personnage est en danger");
						}
					}
					nj=nj+1;
				}
			}
			else{
				choisir=choix.choisir(joueur);
				if(choisir==1){
					t.initialise(String.valueOf(joueur.getNumJoueur()));
				}
				else if(choisir==2){
					attaque.attaquer(t,joueur,joueuradv);
					joueur.setPa(joueur.getPa()+1);
				}
				else if(choisir==3){
					int ch=joueur.getOpj().choisirObjet(joueur.getOpj());
					if((ch==1)||(ch==2)){
						if(joueur.getOpj().getactionObject(ch-1).equals("D")){
							joueur.getOpj().tabObjet[2][ch-1]="E";	
							if(ch==1){
								String reponse;
								String main ="Vous voulez l'utiliser dans dans quelle main";
								if(joueur.getMainDroite().equals(" ")){
									main=main+"\n G : main Gauche";
								}
								if(joueur.getMainGauche().equals(" ")){
									main=main+"\n D : main Droite";
								}
								System.out.println(main);
								reponse=n.nextLine();
								if(reponse.equals("D")){
									joueur.setMainDroite(joueur.getOpj().getNomObject(ch-1));
								}
								else if(reponse.equals("G")){
									joueur.setMainGauche(joueur.getOpj().getNomObject(ch-1));
								}			
							}
							else{
								joueur.getCap().setDefense(joueur.getCap().getDefense()+joueur.getOpj().getValeurObject(ch-1));
							}
						}
						else{
							joueur.getOpj().tabObjet[2][ch-1]="D";	
						}
					}
					else if((ch==3)||(ch==4)){
						if(joueur.getOpj().getactionObject(ch-1).equals("S")){
							joueur.getOpj().tabObjet[2][ch-1]="A";						
							if(ch==4){
								if((joueur.getBlessure()+3)>6){
									joueur.setBlessure(6);
								}
								else {
									joueur.setBlessure(joueur.getBlessure()+3);
								}
							}
							else{
								System.out.println("attaque");
								attaque.action(t, joueur, joueuradv);
							}
						}
						else{
							joueur.getOpj().tabObjet[2][ch-1]="S";		
						}
					}
				}
				else if(choisir==4){
					joueur.getOpj().ajouterObjets(t);
				}
				else if(choisir==5){
					File file = new File("projet.txt");
					 
					 try {
					       FileWriter writer = new FileWriter(file);
					       writer.write(""+joueur);
					       writer.close();
					} catch (IOException ex){
						Logger.getLogger(Serializable.class.getName()).log(Level.SEVERE, null, ex);
					}
					System.out.println("******************* AU REVOIR *******************");
				}
			}

			dateString = formatter.format(currentTime);
			carac = ""+dateString.charAt(3)+dateString.charAt(4);
			joueur.setMinuteDelinstant(Integer.parseInt(carac));
			if(joueur.getMinuteDelinstant()>=(joueur.getMinuteDeCreation()+3)){
				joueur.setPa(joueur.getPa()+1);
				joueur.setMinuteDeCreation(joueur.getMinuteDelinstant());
			}
			compteur=compteur+1;
		}
		
		if(p1.perdu()==true){
			System.out.println("******************* Félicitation *******************");
			System.out.println("******************* le deuxième joueur a gagner *******************");
			p1.setExperience(p1.getExperience()+2);
		}
		if(p2.perdu()==true){
			System.out.println("******************* Félicitation *******************");
			System.out.println("******************* le premiere joueur a gagner *******************");
			p2.setExperience(p2.getExperience()+2);
		}
	}
}
