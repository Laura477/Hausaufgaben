package javakurs.DatumEinfach;

public class InvalidDateException extends RuntimeException { //unchecked
	public InvalidDateException(String message) {
		super(message);
	}
}
