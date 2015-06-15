package projet;

import java.util.Scanner;

public class Caracteristique {
	private int force;
	private int adresse;
	private int endurance;
	
	public Caracteristique() {
		this.force = 0;
		this.adresse = 0;
		this.endurance = 0;
	}
	public Caracteristique(int force, int adresse, int endurance) {
		this.force = force;
		this.adresse = adresse;
		this.endurance = endurance;
	}
	public int getForce() {
		return force;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public int getAdresse() {
		return adresse;
	}
	public void setAdresse(int adresse) {
		this.adresse = adresse;
	}
	public int getEndurance() {
		return endurance;
	}
	public void setEndurance(int endurance) {
		this.endurance = endurance;
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
	
	public void initialisation(){
		Scanner n = new Scanner(System.in);
		System.out.println("Saisie les degres caractéristique de votre personnage, 18 degrés à répartir entre les trois caractéristiques. ");
		boolean verif=false;
		while(verif==false){
			System.out.println("Saisie le degre de force qui doit être entre [0..18]");
			this.setForce(n.nextInt());
			verif=true;
			if((this.getForce()<0)||(this.getForce()>18)){
				System.out.println("degre de force invalide");
				verif=false;
			}
		}
		verif=false;
		while(verif==false){
			System.out.println("Saisie le degres d'adresse qui doit être entre [0.."+(18-this.force)+"]");
			this.setAdresse(n.nextInt());
			verif=true;
			if((this.getAdresse()<0)||(this.getAdresse()>(18-this.force))){
				System.out.println("degre de d'adresse invalide");
				verif=false;
			}
		}	
		System.out.println("Donc Votre endurance sera: "+(18-(this.force+this.adresse)));
		this.setEndurance(18-(this.force+this.adresse));
	}
	
	public String toString() {
		String s;
		s=" -Force : "+convertion(this.force) ;
		s=s+"\n -Adresse : "+convertion(this.adresse);
		s=s+"\n -Endurance : "+convertion(this.endurance)+"\n";

		return s ;
	}
	
		

}
