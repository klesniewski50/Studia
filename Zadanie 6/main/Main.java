package main;

import MyExceptions.*;
import java.util.Scanner;

public class Main {
    static int[] addScannerVectors() throws WektoryRoznejDlugosciException, WektoryZlegoFormatuException {
        System.out.println("Input first vector: ");
        String vectorString1 = (new Scanner(System.in)).nextLine();
        System.out.println("Input second vector: ");
        String vectorString2 = (new Scanner(System.in)).nextLine();
        String[] vectorStringArray1 = vectorString1.split(" ");
        String formatExceptionString = "";
        int[] vector1 = new int[vectorStringArray1.length];
        try{
            for(int i = 0; i < vectorStringArray1.length; i++){
                vector1[i] = Integer.parseInt(vectorStringArray1[i]);
            }
        }
        catch(NumberFormatException e){
            formatExceptionString += "First vector has a wrong format! ";
        }
        String[] vectorStringArray2 = vectorString2.split(" ");
        int[] vector2 = new int[vectorStringArray2.length];
        try{
            for(int i = 0; i < vectorStringArray2.length; i++){
                vector2[i] = Integer.parseInt(vectorStringArray2[i]);
            }
        }
        catch(NumberFormatException e){
            formatExceptionString += "Second vector has a wrong format! ";
        }
        if(formatExceptionString.length() > 0){
            throw new WektoryZlegoFormatuException(formatExceptionString);
        }
        int[] vector3 = new int[vector1.length];
        try{
            for(int i = 0; i < vector1.length; i++){
                vector3[i] = vector1[i] + vector2[i];
            }
        }
        catch(IndexOutOfBoundsException e){
            if(vector1.length != vector2.length){
                String message = "Dlugosc pierwszego wektora to " + vector1.length + " a drugiego to " + vector2.length + ".";
                throw new WektoryRoznejDlugosciException(message);
            }
        }
        return vector3;
    }
    public static void main(String[] args) {
        int[] resultVector; boolean loop = true;
        while(loop)
            try {
                resultVector = addScannerVectors();
                for(int element : resultVector){
                    System.out.print(element + " ");
                }
                loop = false;
            }
            catch(WektoryRoznejDlugosciException | WektoryZlegoFormatuException e){
                e.printStackTrace();
            }
        }
    }
