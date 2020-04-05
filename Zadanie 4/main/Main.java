package main;

import RandomChars.RandomByteArray;

import java.io.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int amount = 1000;
        String filenameIO = "IO.txt";
        String filenameNIO = "NIO.txt";
        RandomByteArray rba;
        try{
            rba = new RandomByteArray(amount);
        }
        catch(NegativeArraySizeException e){
            System.out.println("Array size isn't valid!");
            System.out.println(e.toString());
            return;
        }
        rba.randomise();
        Writer wr = new PrintWriter(System.out);

        //java.IO part
        long IOTimeCountStart = System.nanoTime();
        FileWriter OutputFileNameIO;
        try{
            OutputFileNameIO = new FileWriter(filenameIO);
        }
        catch(IOException e){
            System.out.println("The file can't be written correctly!");
            return;
        }
        int i = 0;
        OutputFileNameIO.write(rba.toCharArray(), 0, amount);
        OutputFileNameIO.close();

        char[] IOResult = new char[amount];
        FileReader InputFileNameIO;
        try{
            InputFileNameIO = new FileReader(filenameIO);
        }
        catch(IOException e){
            System.out.println("The file can't be read correctly!");
            return;
        }
        if(InputFileNameIO.read(IOResult, 0, amount) != amount){
            System.out.println("Warning! File hasn't been read fully.");
        }
        InputFileNameIO.close();

        System.out.println("IO:");
        wr.write(IOResult);
        wr.flush();
        System.out.println();

        long IOTimeCountEnd = System.nanoTime();
        //java.NIO part
        long NIOTimeCountStart = System.nanoTime();
        Path path = Paths.get(filenameNIO);
        OutputStream outputStream = Files.newOutputStream(path, StandardOpenOption.CREATE);
        outputStream.write(rba.getArr(), 0, amount);
        outputStream.close();

        InputStream inputStream = Files.newInputStream(path, StandardOpenOption.READ);
        byte[] NIOResult = new byte[amount];
        if(inputStream.read(NIOResult, 0, amount) != amount){
            System.out.println("\nWarning! File hasn't been read fully.");
        }
        inputStream.close();

        System.out.println("NIO:");
        wr.write(RandomByteArray.toCharArray(NIOResult));
        wr.flush();
        System.out.println();
        long NIOTimeCountEnd = System.nanoTime();
        System.out.println("Elapsed time for IO: " + (IOTimeCountEnd - IOTimeCountStart));
        System.out.println("Elapsed time for NIO: " + (NIOTimeCountEnd - NIOTimeCountStart));
    }
}
