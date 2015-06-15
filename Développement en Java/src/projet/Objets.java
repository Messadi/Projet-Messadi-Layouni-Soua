package projet;

import java.util.Scanner;

public class Objets {
	String tabObjet[][]= new String [50][50];
	int taille;

	public Objets() {
		this.tabObjet[0][0]="épée longue";
		this.tabObjet[1][0]="4";
		this.tabObjet[2][0]="D";
		this.tabObjet[0][1]="vétements de cuir";
		this.tabObjet[1][1]="1";
		this.tabObjet[2][1]="D";
		this.tabObjet[0][2]="potion d'explosion";
		this.tabObjet[1][2]="1";
		this.tabObjet[2][2]="S";
		this.tabObjet[0][3]="potion de Soin";
		this.tabObjet[1][3]="1";
		this.tabObjet[2][3]="S";
		this.taille=4;
	}
	public void setTaille(int taille){
		this.taille=taille;
	}
	public int getTaille(){
		return this.taille;
	}
	public void setObjets(String ch, int n){
		this.tabObjet[0][this.getTaille()]=ch;	
		this.tabObjet[1][this.getTaille()]=String.valueOf(n);
	}
	public String getNomObject(int colonne){
		return this.tabObjet[0][colonne];
	}
	public int getValeurObject(int colonne){
		return (Integer.valueOf(this.tabObjet[1][colonne]));
	}
	public String getactionObject(int colonne){
		return this.tabObjet[2][colonne];
	}
	public void ajouterObjets(Terrain t){
		boolean verif =true;
		Scanner n = new Scanner(System.in);
		this.taille=this.taille+1;
		while(verif){
			System.out.println("Saisie ligne et colonne de la case a l'objet que vous voulez ramasser");
			System.out.print("ligne : ");
			int ligne =n.nextInt()	;
		
			System.out.print("colonne : ");
			int colonne= n.nextInt();
			if (t.getTab(ligne, colonne).equals("a")){
				this.setObjets("armee",4);
				t.setTab(ligne, colonne,"");
				verif=false;
			}
			else if (t.getTab(ligne, colonne).equals("P")){
				this.setObjets("potion",1);
				t.setTab(ligne, colonne,"");
				verif=false;
			}
			else{
				System.out.println("Erreur: la case saisi ne contient pas un objets");
			}
		}
	}
	public String convertion(int n){
		String ch="";
		if(((int)n/3)!=0){
			ch=((int)n/3)+"D";
		}
		if((n-(3*((int)n/3)))!=0){
			ch=ch+" +"+(n-(3*((int)n/3)));
		}
		return ch;
	}
	public int choisirObjet(Objets o){
		Scanner n = new Scanner(System.in);
		int choix=0;
		String ch="";
		int d=0;
		int d1=0;
		int s=0;
		int s1=0;
		for(int i=0;i<4;i++){
				if(getactionObject(i).equals("D")){
					if(d==0){	
						ch=ch+"Pour vous équiper d'un objets: \n";
					}
					ch=ch+(i+1)+" - "+o.getNomObject(i)+" ("+convertion(o.getValeurObject(i))+")"+"\n";
					d=d+1;
				}
				else if(getactionObject(i).equals("E")){
					if(d1==0){	
						ch=ch+"Pour vous déséquiper d'un objets: \n";
					}
					ch=ch+(i+1)+" - "+o.getNomObject(i)+" ("+convertion(o.getValeurObject(i))+")"+"\n";
					d1=d1+1;
				}
				else if(getactionObject(i).equals("S")){
					if(s==0){	
						ch=ch+"Pour utiliser une potion : \n";
					}
					ch=ch+(i+1)+" - "+o.getNomObject(i)+" ("+convertion(o.getValeurObject(i))+")"+"\n";
					s=s+1;			
				}
		}
		ch=ch+"Votre choix ";
		System.out.print(ch);
		choix=n.nextInt();
		return choix;
	}
	
	public String toString() {
		String s= "Vos Objets équipés : \n ";
		for(int i=0;i<this.getTaille();i++){
			s=s+" - "+this.getNomObject(i)+" ("+convertion(this.getValeurObject(i))+")"+"\n";
			if(i==1){
				s=s+"Votre Sac : \n";
			}
		}
		return s;
	}

}
