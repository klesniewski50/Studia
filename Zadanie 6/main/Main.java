package main;

import MyExceptions.WektoryRoznejDlugosciException;
import java.util.Scanner;

public class Main {
    static int[] scanVector() throws NumberFormatException{
        String vectorString = (new Scanner(System.in)).nextLine();
        String[] vectorStringArray = vectorString.split(" ");
        int[] vector = new int[vectorStringArray.length];
        for (int i = 0; i < vectorStringArray.length; i++) {
            vector[i] = Integer.parseInt(vectorStringArray[i]);
        }
        return vector;
    }
    static int[] addScannerVectors() throws Exception {
        System.out.println("Input first vector: ");
        int[] vector1 = scanVector();
        System.out.println("Input second vector: ");
        int[] vector2 = scanVector();
        if (vector1.length != vector2.length) {
            String message = "Dlugosc pierwszego wektora to " + vector1.length + " a drugiego to " + vector2.length + ".";
            throw new WektoryRoznejDlugosciException(message);
        }
        int[] vector3 = new int[vector1.length];
        for (int i = 0; i < vector1.length; i++) {
            vector3[i] = vector1[i] + vector2[i];
        }
        return vector3;
    }
    public static void main(String[] args) {
        int[] resultVector; boolean loop = true;
        while(loop)
            try {
                resultVector = addScannerVectors();
                System.out.println("Result: ");
                for(int element : resultVector){
                    System.out.print(element + " ");
                }
                loop = false;
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
