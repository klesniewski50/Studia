package Server;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.security.ntlm.Server;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.management.Notification;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ServerException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;

public class ServerThread implements Runnable {
    public final static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss aa");
    Socket messagePortSocket;
    int currentPort;
    public ServerThread(int currentPort) throws IOException {
        this.messagePortSocket = (new ServerSocket(currentPort)).accept();
        this.currentPort = currentPort;
    }

    public static void sendAvailablePort(Socket portZeroSocket, int currentPort) throws IOException {
        PrintStream printStream = new PrintStream(portZeroSocket.getOutputStream());
        printStream.println(Integer.toString(currentPort));
        System.out.println(Thread.currentThread().getName() + " Available port (" + currentPort + ") have been send to the client!");
        printStream.close();
    }

    @Override
    public void run() {
        try{
            Scanner scanner = new Scanner(messagePortSocket.getInputStream());
            PrintStream printStream = new PrintStream(messagePortSocket.getOutputStream());
            String messageContent = scanner.nextLine();
            System.out.println(Thread.currentThread().getName() + " Message content: " + messageContent);
            String notifyDateString = scanner.nextLine();
            System.out.println(Thread.currentThread().getName() + " Notification date: " + notifyDateString);
            Date notifyDate = DATE_FORMAT.parse(notifyDateString);
            long timeLeft = notifyDate.getTime() - Calendar.getInstance().getTimeInMillis();
            System.out.println(Thread.currentThread().getName() + " All the needed date is received. Waiting to notify the client!");
            Thread.sleep(timeLeft);
            printStream.println(messageContent);
            System.out.println(Thread.currentThread().getName() + " Notification have been send! Thank you!");
            printStream.close();
            messagePortSocket.close();
        }
        catch(IOException e){
            System.out.println(Thread.currentThread().getName() + " Socket may be unable to connect to client!");
        }
        catch(ParseException e){
            System.out.println(Thread.currentThread().getName() + " Date format was incorrect!");
        }
        catch(InterruptedException | IllegalArgumentException e){
            System.out.println(Thread.currentThread().getName() + " Client send his notification to late!");
        }
    }
}