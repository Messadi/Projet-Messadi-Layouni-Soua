package projet;

import java.util.Scanner;

public class Attaquer {
	private int x;
	private int y;

	public Attaquer(){
		this.x=0;
		this.y=0;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void attaquer(Terrain t, Personnage p1, Personnage p2){
		boolean verif=false;
		String mainAttaque;
		System.out.println("saisie la case d'attaquement");
		Scanner n = new Scanner(System.in);
		System.out.print("ligne : ");
		this.setX(n.nextInt());
		System.out.print("colonne : ");
		this.setY(n.nextInt()+1);
		
		if(t.getTab(this.getX(),this.getY()).equals(String.valueOf(p2.getNumJoueur()))){
			if((!(p1.getMainDroite().equals(" ")))&&(!(p1.getMainGauche().equals(" ")))){
				while(verif==false){
					System.out.println("vous voulez attaquer avec main: ");
					if(!(p1.getMainDroite().equals(" "))){
						System.out.println("D : droite avec un "+p1.getMainDroite() );
					}
					if(!(p1.getMainGauche().equals(" "))){
						System.out.println("G : gauche avec un"+p1.getMainGauche());
					}
					mainAttaque=n.nextLine();
					if(mainAttaque.equals("G")){
						verif=true;
					}
					else if(mainAttaque.equals("D")){
						verif=true;
					}
					else{
						System.out.println("ERREUR : choix incorrecte ");
						verif=false;
					}
				}
			}
			if(p1.getCap().getAttaque()>p2.getCap().getEsquive()){
				System.out.println(" Cible touchée");
				if(p1.getCap().getDegats()>=p2.getCap().getDefense()){
					p2.setBlessure(p2.getBlessure()-3);
				}
				else{
					System.out.println(p2.getNumJoueur()+" personnage s'en tire indemne ");
				}	
			}		
		}
		else if((t.getTab(this.getX(),this.getY()).equals("C"))||(t.getTab(this.getX(),this.getY()).equals("L"))) {
				System.out.println(" Cible touchée");
				t.setTab(this.getX(),this.getY()," ");
				int randomNum = 1 + (int)(Math.random()*2);
				if(randomNum==1){
					t.setTab(this.getX(),this.getY(),"a");
				}
				else {
					t.setTab(this.getX(),this.getY(),"P");
				}
			}
		else{
			System.out.println("Attaque non réussit");
		}
	}
	
	public void action(Terrain t,Personnage p1,Personnage p2){
		int ligne=t.rechercheligne(Integer.toString(p1.getNumJoueur()));
		int colonne=t.recherchecolonne(Integer.toString(p1.getNumJoueur()));
		int x=ligne;
		int y =colonne;
		int i=0;
		
		while(i<3){
			x=x+1;
			if((t.getTab(x,y).equals(Integer.toString(p2.getNumJoueur())))){
				p2.getCap().setDegats(0);
			}
			if ((t.getTab(x,y).equals("C"))||(t.getTab(x,y).equals("L"))){
				t.setTab(x,y," ");
			}
			i=i+1;
		}
		x=ligne;
		i=0;
		while(i<3){
			y=y+1;
			if((t.getTab(x,y).equals(Integer.toString(p2.getNumJoueur())))){
				p2.getCap().setDegats(0);
			}
			if((t.getTab(x,y).equals("C"))||(t.getTab(x,y).equals("L"))){
				t.setTab(x,y," ");
			}
			i=i+1;
		}
		x=ligne;
		y=colonne;
		i=0;
		while(i<3){
			if((x-1)>=0){
				x=x-1;
			}
			if((t.getTab(x,y).equals(Integer.toString(p2.getNumJoueur())))){
				p2.getCap().setDegats(0);
			}
			if ((t.getTab(x,y).equals("C"))||(t.getTab(x,y).equals("L"))){
				t.setTab(x,y," ");
			}
			i=i+1;
		}
		x=ligne;
		i=0;
		while(i<3){
			if((y-1)>=0){
				y=y-1;
			}
			if((t.getTab(x,y).equals(Integer.toString(p2.getNumJoueur())))){
				p2.getCap().setDegats(0);
			}
			if ((t.getTab(x,y).equals("C"))||(t.getTab(x,y).equals("L"))){
				t.setTab(x,y," ");
			}
			i=i+1;
		}
	}
	
}
