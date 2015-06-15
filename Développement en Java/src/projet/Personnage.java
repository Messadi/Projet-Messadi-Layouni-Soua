package projet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.text.Format;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.lang.model.element.Element;
import javax.sql.rowset.spi.XmlWriter;
import javax.swing.text.Document;

public class Personnage extends Terrain {
	private int pa;
	private int blessure ;
	private int numJoueur;
	private int experience;
	private int minuteDeCreation;
	private int minuteDelinstant;
	 

	public int getMinuteDeCreation() {
		return minuteDeCreation;
	}
	public void setMinuteDeCreation(int minuteDeCreation) {
		this.minuteDeCreation = minuteDeCreation;
	}
	public int getMinuteDelinstant() {
		return minuteDelinstant;
	}
	public void setMinuteDelinstant(int minuteDelinstant) {
		this.minuteDelinstant = minuteDelinstant;
	}
	private Caracteristique car;
	private Capacite cap;
	private Objets opj;
	private String mainGauche;
	private String mainDroite;
	
	public String getMainGauche() {
		return mainGauche;
	}
	public void setMainGauche(String mainGauche) {
		this.mainGauche = mainGauche;
	}
	public String getMainDroite() {
		return mainDroite;
	}
	public void setMainDroite(String mainDroite) {
		this.mainDroite = mainDroite;
	}
	public Personnage() {
		this.car=new Caracteristique ();
		this.opj=new Objets();
		this.cap=new Capacite(this.opj,this.car);
		this.pa=6;
		this.blessure=6;
		this.numJoueur=1;
		this.experience=0;
		this.mainDroite=" ";
		this.mainGauche=" ";
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public Caracteristique getCar() {
		return car;
	}
	public void setCar(Caracteristique car) {
		this.car = car;
	}
	public Capacite getCap() {
		return cap;
	}
	public void setCap(Capacite cap) {
		this.cap = cap;
	}
	public Objets getOpj() {
		return opj;
	}
	public void setOpj(Objets opj) {
		this.opj = opj;
	}
	public int getNumJoueur() {
		return numJoueur;
	}
	public void setNumJoueur(int numJoueur) {
		this.numJoueur = numJoueur;
	}

	public int getPa(){
		return this.pa;
	}
	public void setPa(int pa){
		this.pa=pa;
	}
	public int getBlessure(){
		return this.blessure;
	}
	public void setBlessure(int blessure){
		this.blessure=blessure;
	}
	public void initialisation(){
		this.car.initialisation();
		
	}
	public boolean perdu(){
		if(this.getBlessure()<=0){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void enregistrer(Personnage p){			
		
		File file = new File("personnage.txt");
		 
		try {
		      FileWriter writer = new FileWriter(file);
		      writer.write(String.valueOf(p));
		      writer.close();
		} catch (IOException ex){
			Logger.getLogger(Serializable.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public String toString() {
		String s= this.opj.toString()+"Vos caractéristique : \n"+this.car.toString()+this.cap.toString()+"\n";
		s=s+"Votre niveau de blessures est  ";
		if(this.getBlessure()==6){
			s=s+"en forme \n";
		}
		else if(this.getBlessure()==5){
			s=s+"Blessures superficielles \n";
		}
		else if(this.getBlessure()==4){
			s=s+"Légerement blessé \n";
		}
		if(this.getBlessure()==3){
			s=s+"Blessé \n";
		}
		if(this.getBlessure()==2){
			s=s+"Gravement blessé \n";
		}
		if(this.getBlessure()==1){
			s=s+"Inconscient \n";
		}
		if(this.getBlessure()<=0){
			s=s+"Mort \n";
		}
		s=s+"Vos points d'action :"+this.getPa()+"\n"; 
		return s;
	}
	
	
	

}
