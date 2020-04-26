package Clients;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SingleClient{
    private ClientMessage message;
    public SingleClient(ClientMessage message, int currentPort, String hostIPAddress) throws ClientException {
        this.message = message;
        Socket socket;
        PrintStream printStream;
        Scanner scanner;
        try{
            socket = new Socket(hostIPAddress, currentPort);
            scanner = new Scanner(socket.getInputStream());
            printStream = new PrintStream(socket.getOutputStream());
            this.message.send(printStream);
            System.out.println("Waiting for notification...");
            System.out.println("Notification: " + message.receive(scanner));
            printStream.close();
            socket.close();
        }
        catch(IOException e){
            throw new ClientException("Occurred exception probably concerning sockets");
        }
        catch(NullPointerException e){
            throw new ClientException("There is some null pointer passed!");
        }
    }
    public String toString(){
        return message.getMessageContent();
    }
    public ClientMessage getMessage(){
        return message;
    }
    public void setMessage(ClientMessage message){
        this.message = message;
    }
}
