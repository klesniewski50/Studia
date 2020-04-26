package Server;

public class ServerException extends Throwable {
    public ServerException(){
        super("Occurred some unknown error surrounding server");
    }
    public ServerException(Throwable cause){
        super(cause);
    }
    public ServerException(String message){
        super(message);
    }
    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
