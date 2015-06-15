package projet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Terrain {
	
	private String tab[][]=new String[60][60];
	private int ligne;
	private int colonne;
	
	public Terrain(){
		this.ligne=22;
		this.colonne=20;
		int j=0;
		int i=0;
		int c=64;
		String s=" ";
		for( i=0;i<=22;i++){
			for(j=0;j<=20;j++){
				this.tab[i][j]=" ";
			}
		}
		for(i=0;i<=22;i++){
			for(j=0;j<=22;j++){
				if(j==0){
					if(i==0){
						s=s+"  ";
						this.tab[i][j]=s;
					}
					else if(i<10){
						s=String.valueOf(i)+"  ";
						this.tab[i][j]=s;
					}
					else{
						s=String.valueOf(i)+" ";
						this.tab[i][j]=s;	
					}
				}
				if(i==0){
					this.tab[i][j]=s;
					c=c+1;
					s =""+((char)c);
				}
			}
		}
		for( i=1;i<=22;i++){
			for( j=1;j<=20;j++){
				this.tab[i][j]=" ";
				if((i==1)||(i==22)||(j==1)||(j==20)){
					this.tab[i][j]="#";
				}
			}
		}
		i=4;
		for(j=9;j<18;j++){
			this.tab[i][j]="#";
		}
		i=10;
		for(j=5;j<15;j++){
			this.tab[i][j]="#";
		}
		i=18;
		for(j=11;j<15;j++){
			this.tab[i][j]="#";
		}
		j=14;
		for(i=5;i<9;i++){
			this.tab[i][j]="#";
		}
		j=10;
		for(i=14;i<21;i++){
			this.tab[i][j]="#";
		}
		this.setTab(2,10, "C");
		this.setTab(3,13, "L");
		this.setTab(7,9, "C");
		this.setTab(6,5, "a");
		this.setTab(5,17, "L");
		this.setTab(9,6,"L");
		this.setTab(11,10,"P");
		this.setTab(11,15,"L");
		this.setTab(11,4,"C");
		this.setTab(13,7,"L");
		this.setTab(15,4,"P");
		this.setTab(17,4,"C");
		this.setTab(15,9,"C");
		this.setTab(20,15,"P");
		this.setTab(19,16,"C");
		this.setTab(17,15,"L");
		this.setTab(20,7,"L");
		this.setTab(18,8,"a");
	}
	public void setTab(int i, int j,String s){
		this.tab[i][j]=s;
	}
	public String getTab(int i,int j ){
		return this.tab[i][j];
	}
	public int getLigne(){
		return this.ligne;
	}
	public void setLigne(int ligne){
		this.ligne=ligne;
	}
	public int getColonne(){
		return this.colonne;
	}	
	public void setColonne(int colonne){
		this.colonne=colonne;
	}
	public int rechercheligne(String s){
		for(int i=0;i<22;i++){
			for(int j=0;j<20;j++){
				if(this.getTab(i,j).equals(s)){
					return i;
				}
			}
		}
		return -1;
	}
	public int recherchecolonne(String s){
		for(int i=0;i<22;i++){
			for(int j=0;j<20;j++){
				if(this.getTab(i,j).equals(s)){
					return j;
				}
			}
		}
		return -1;
	}
	
	public void supprime(String s){
		for(int i=0;i<22;i++){
			for(int j=0;j<20;j++){
				if(this.getTab(i,j).equals(s)){
					this.tab[i][j]=" ";
				}
			}
		}
	}
	public void initialise(String s){
		Scanner n = new Scanner(System.in);
		int verif=0;
		while(verif==0){
			System.out.println("Saisie la ligne et colonne de votre déplacement");
			System.out.print("ligne : ");
			this.ligne=n.nextInt();
			System.out.print("colonne : ");
			this.colonne=n.nextInt()+1;
			if(this.getTab(this.ligne, this.colonne)==" "){
				this.setTab(this.ligne,this.colonne,s);
				verif=1;
			}
			else{
				System.out.println("ERREUR: Case occupè");
			}
		}
		supprime(s);
		this.tab[this.ligne][this.colonne]=s;
		
	}
	
	public String toString(){
		String ch=" ";
		for(int i=0;i<=22;i++){
			for(int j=0;j<=20;j++){
				ch=ch+getTab(i,j);
			}
			ch=ch+"\n";
		}
		return ch;
	}
}
