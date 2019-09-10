package exceptions;

public class RepeatedException extends Exception{
	public RepeatedException(){
		super("Error, el usuario esta repetido.");
	}
}
