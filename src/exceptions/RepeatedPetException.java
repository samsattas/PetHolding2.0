package exceptions;

public class RepeatedPetException extends Exception{
	public RepeatedPetException(){
		super("Error, la Mascota esta repetida.");
	}
}
