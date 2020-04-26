package Clients;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ClientMessage {
    private String messageContent;
    private Date notification;
    public final static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss aa");
    public ClientMessage(String messageContent, Date notification){
        this.messageContent = messageContent;
        this.notification = notification;
    }
    String getMessageContent(){
        return messageContent;
    }
    void setMessageContent(String messageContent){
        this.messageContent = messageContent;
    }
    Date getNotification(){
        return notification;
    }
    void setNotification(Date notification){
        this.notification = notification;
    }
    void send(PrintStream p){
        p.println(messageContent);
        p.println(DATE_FORMAT.format(getNotification().getTime()));
        System.out.println("Request was successfully sent.");
    }
    String receive(Scanner s){
        return s.nextLine();
    }
}
