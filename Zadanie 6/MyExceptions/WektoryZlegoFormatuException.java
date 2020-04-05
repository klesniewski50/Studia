package MyExceptions;

public class WektoryZlegoFormatuException extends Exception{
    public WektoryZlegoFormatuException(){
        super("Vector's format is incorrect!");
    }
    public WektoryZlegoFormatuException(String message, Throwable cause){
        super(message, cause);
    }
    public WektoryZlegoFormatuException(String message){
        super(message);
    }
    public WektoryZlegoFormatuException(Throwable cause){
        super(cause);
    }
}
