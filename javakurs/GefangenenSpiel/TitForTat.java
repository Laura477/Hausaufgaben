package javakurs.GefangenenSpiel;

public class TitForTat implements GefangenenStrategie {
	private boolean lastDecision =true;
	
	public boolean getNextDecision() {
		return lastDecision;
	}

	public void setOpponentsLastDecision(boolean decision) {
		lastDecision = decision;
	}
}
