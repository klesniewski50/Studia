package Main;

import Clients.ClientException;
import Clients.ClientMessage;
import Clients.SingleClient;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.ServerException;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
        public static final String HOST_IP_ADDRESS = "127.0.0.1";
        public static final int portZero = 5000;
        public static int getAvailablePort() throws ClientException {
            int port;
            try{
                Socket socket = new Socket(HOST_IP_ADDRESS, portZero);
                Scanner scanner = new Scanner(socket.getInputStream());
                port = Integer.parseInt(scanner.nextLine());
                System.out.println("Available port: " + port);
            }
            catch(IOException e){
                throw new ClientException("Cannot connect to the port zero!");
            }
            catch(NoSuchElementException e){
                throw new ClientException("You just have been disconnected with the server!");
            }
/*            catch(ParseException e){
                System.out.println("Incorrect format of the received port!");
            }*/
            return port;
        }
        public static synchronized SingleClient createClient(int port) throws ClientException{
            Scanner scanner = new Scanner(System.in);
            Date date = Calendar.getInstance().getTime();
            System.out.println("Input date in format " + ClientMessage.DATE_FORMAT.toString() + ":");
            String stringDate = scanner.nextLine();
            System.out.println("Input the message you want to be notified about: ");
            String stringMessage = scanner.nextLine();
            try{
                date.setTime(ClientMessage.DATE_FORMAT.parse(stringDate).getTime());
            }
            catch(ParseException e){
                throw new ClientException("Date format is incorrect!");
            }
            return new SingleClient(new ClientMessage(stringMessage, date), port, HOST_IP_ADDRESS);
        }
    public static void main(String[] args){
            try{
                createClient(getAvailablePort());
            }
            catch(ClientException e){
                System.out.println(e.getMessage());
            }
    }
}
