package projet;

import java.util.Scanner;

public class Choix {
	int choix;
	public Choix (){
		this.choix=0;
	}
	public void setChoix(int choix){
		this.choix=choix;
	}
	public int getChoix(){
		return this.choix;
	}
	
	public int choisir(Personnage p) {
		Scanner n = new Scanner(System.in);
		boolean verif=false;
		String 	s="Vous pouvez : \n"
			+"1 - vous déplacer (cout 2PA) \n"
			+"2 - attaquer (cout 3PA) \n"
			+"3 - utiliser un objet (cout 3PA) \n"
			+"4 - ramasser un objet (cout 2PA) \n"
			+"5 - finir et garder les PA restants \n"
			+"Votre choix : ";
		while(!(verif)){
			System.out.print(s);
			this.setChoix(n.nextInt());	
			if((this.getChoix()<1)||(this.getChoix()>5)){
				System.out.println("ERREUR : votre choix est incorrecte");
				System.out.print(s);
			}
			else{
				if(((this.getChoix()==1)&&(p.getPa()>=2))||(((this.getChoix()==2)&&(p.getPa()>=3)))||((this.getChoix()==3)&&(p.getPa()>=3))||((this.getChoix()==4)&&(p.getPa()>=2))||(this.getChoix()==5)){
					if((this.getChoix()==1)||(this.getChoix()==4)){
						p.setPa(p.getPa()-2);
					}
					else if((this.getChoix()==2)||(this.getChoix()==3)){
						p.setPa(p.getPa()-3);
					}
					verif=true;
				}
				else{
					System.out.println("Votre nombre de PA ne vous permet pas de jouer cette action ");
				}
				
			}
		}
		return this.choix;
	}

}
