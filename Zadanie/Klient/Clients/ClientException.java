package Clients;

public class ClientException extends Throwable {
    public ClientException(){
        super("Occurred some unknown error surrounding client");
    }
    public ClientException(Throwable cause){
        super(cause);
    }
    public ClientException(String message){
        super(message);
    }
    public ClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
