package projet;

public class Capacite {
	int intiative;
	int attaque;
	int esquive;
	int defense;
	int degats;
	
	public Capacite(Objets o, Caracteristique c){
		this.setIntiative(convertionNegatif(c.getAdresse(),o.getValeurObject(1)));
		this.setAttaque(convertion(c.getAdresse(),o.getValeurObject(0)));
		this.setEsquive(convertionNegatif(c.getAdresse(),o.getValeurObject(1)));
		this.setDefense(convertion(c.getEndurance(),o.getValeurObject(1)));
		this.setDegats(convertion(c.getForce(),o.getValeurObject(0)));
	}
	
	public int getIntiative() {
		return intiative;
	}

	public void setIntiative(String c) {
		this.intiative =converstionCapacite(c);
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(String c) {
		this.attaque =converstionCapacite(c);
	}
	
	public int getEsquive() {
		return esquive;
	}

	public void setEsquive(String c) {
		this.esquive =converstionCapacite(c);
	}

	public int getDefense() {
		return defense;
	}
	public void setDefense(int n){
		this.defense=n;
	}
	public void setDefense(String c) {
		this.defense =converstionCapacite(c);
	}

	public int getDegats() {
		return degats;
	}
	public void setDegats(int degats){
		this.degats=degats;
	}
	public void setDegats(String c) {
		this.degats=converstionCapacite(c);
	}
	public String convertionNegatif(int a,int b) {
		String ch="";
		int max=b;
		int min=a;
		if(a>b){
			max=a;
			min=b;
		}
		ch=(((int)max/3)-((int)min/3))+"D";
		ch=ch+"+"+(((max-(3*((int)max/3)))-(min-(3*((int)min/3)))));
		return ch;
	}
	public int converstionCapacite(String c){
		String ch=""+c.charAt(0);
		int n = Integer.parseInt(ch)*3;
		ch=""+c.charAt(3);
		n=n+Integer.parseInt(ch);
		return n;
	}

	public String convertion(int a,int b){
		String ch="";
		ch=(((int)a/3)+((int)b/3))+"D";
		ch=ch+"+"+(((a-(3*((int)a/3)))+(b-(3*((int)b/3)))));
		return ch;
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
		
	public String toString() {
		return " +Intiative : " + convertion(this.getIntiative())
				+ "\n +Attaque : " +convertion(this.getAttaque())
				+ "\n +Esquive : " + convertion(this.getEsquive())
				+ "\n +Defense : " + convertion(this.getDefense())
				+ "\n +Degats : " +convertion( this.getDegats())+ "\n";
	}


}
