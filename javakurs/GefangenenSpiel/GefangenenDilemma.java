package javakurs.GefangenenSpiel;

public class GefangenenDilemma {
	private GefangenenStrategie spieler1;
	private GefangenenStrategie spieler2;
	private int punkte1=0;
	private int punkte2=0;
	private boolean decision1;
	private boolean decision2;
	private int rundenzahl=1;
	
	public GefangenenDilemma(GefangenenStrategie spieler1, GefangenenStrategie spieler2) {
		this.spieler1 = spieler1;
		this.spieler2 = spieler2;

	}
	
	public void spiele(int n) {
		
		while (rundenzahl <=n) {
			//Abfrage der aktuellen Spieltaktik
			decision1 = spieler1.getNextDecision();
			decision2 = spieler2.getNextDecision();
			
			//Punktevergabe
			if (decision1 && decision2) {
				punkte1 +=2;
				punkte2 +=2;
			}
			if (!decision1 && !decision2) {
				punkte1 +=4;
				punkte2 += 4;
			}
			if (!decision1 && decision2 ) {
				punkte1 +=1;
				punkte2 +=6;
			}
			if (decision1 && !decision2 ) {
				punkte1 +=6;
				punkte2 +=1;
			}
			
			//Zugmitteilung
			spieler1.setOpponentsLastDecision(decision2);
			spieler2.setOpponentsLastDecision(decision1);
			
			rundenzahl++;
		}
		
		System.out.println(punkte1);
		System.out.println(punkte2);

	}

	int getRundenzahl() {
		return rundenzahl;
	}

	void setRundenzahl(int rundenzahl) {
		this.rundenzahl = rundenzahl;
	}

}
