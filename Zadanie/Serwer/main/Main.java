package Main;

import Server.ServerThread;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final int portZero = 5000;
    public static int offset = 1;
    public static boolean stop = false;
    public static void main(String[] args) {
        Thread.currentThread().setName("[main]");
        ArrayList<Thread> threads = new ArrayList<Thread>(); int i = 0;
        Thread quitThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " If you want to quit just click q/Q, else: click anything");
            while(true){
                if((new Scanner(System.in)).nextLine().equalsIgnoreCase("q")){
                    System.out.println(Thread.currentThread().getName() + " You can't add new clients anymore! Wait for all notifications to be send!");
                    stop = true;
                    break;
                }
            }
        });
        quitThread.setName("[quit]");
        quitThread.start();
        try{
            ServerSocket portZeroServerSocket = new ServerSocket(portZero);
            while(!stop){
                System.out.println(Thread.currentThread().getName() + " Waiting for another client...");
                Socket portZeroSocket = portZeroServerSocket.accept();
                ServerThread.sendAvailablePort(portZeroSocket, portZero + offset);
                portZeroSocket.close();
                String clientName = "[Client-" + offset + "]";
                threads.add(new Thread(new ServerThread(portZero + offset++), clientName));
                threads.get(i++).start();
            }
        }
        catch(IOException e){
            System.out.println("Socket exception!");
        }
    }
}