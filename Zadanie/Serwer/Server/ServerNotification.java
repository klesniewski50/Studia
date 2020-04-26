package Server;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

class ServerNotification{
    public static final Comparator<ServerNotification> COMPARATOR = Comparator.comparing(ServerNotification::getDate);
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss aa");
    private Date date;
    private String content;
    public ServerNotification(Date date){
        this.date = date;
        this.content = "Empty message";
    }
    public ServerNotification(Date date, String content){
        this.date = date;
        this.content = content;
    }
    Date getDate(){
        return date;
    }
    void setDate(Date date){
        this.date = date;
    }
    String getContent(){
        return content;
    }
    void setContent(String content){
        this.content = content;
    }
}
