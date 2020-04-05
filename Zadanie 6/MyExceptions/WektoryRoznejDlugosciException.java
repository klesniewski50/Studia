package MyExceptions;

public class WektoryRoznejDlugosciException extends Exception{
    public WektoryRoznejDlugosciException(){
        super("Vectors' lengths are different!");
    }
    public WektoryRoznejDlugosciException(String message, Throwable cause){
        super(message, cause);
    }
    public WektoryRoznejDlugosciException(String message){
        super(message);
    }
    public WektoryRoznejDlugosciException(Throwable cause){
        super(cause);
    }
}
