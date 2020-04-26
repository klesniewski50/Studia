package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.print("Input file name: ");
        String fileName = (new Scanner(System.in)).nextLine();
        FileWriter fileWr;
        try{
            fileWr = new FileWriter("name.txt");
        }
        catch(IOException e){
            System.out.println("The file can't be written correctly!");
            return;
        }
        fileWr.write(fileName, 0, fileName.length());
        fileWr.close();
        FileReader fileRd;
        try{
            fileRd = new FileReader(fileName);
        }
        catch(IOException e){
            System.out.println("The file can't be read correctly!");
            return;
        }
        int readPoint = 0;
        char[] buffer = new char[5]; int randomAmount;
        Writer print = new PrintWriter(System.out);
        System.out.println("If you want to leave write 'q'");
        while(!(new Scanner(System.in)).next().equals("q")){
            randomAmount = (int)(Math.random()*5 + 1);
            buffer = Arrays.copyOf(buffer, buffer.length + randomAmount);
            if(fileRd.read(buffer, readPoint, randomAmount) != randomAmount)
                break;
            print.write(buffer, readPoint, randomAmount);
            print.flush();
            readPoint += randomAmount;
            System.out.println("\nWant to try again?");
        }
    }
}
