package exception;

public class NotLivingCellException extends Exception{
	private static final long serialVersionUID = 8774146437261514151L;
	
	public NotLivingCellException(){
		super("The giving cell isn't a living cell.");
	}
}
