package javakurs.GefangenenSpiel;

public interface GefangenenStrategie {
	public boolean getNextDecision();
	public void setOpponentsLastDecision(boolean decision);
}
