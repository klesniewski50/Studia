package main;

import java.util.Scanner;

public class Main {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) {
        int attemptAmount, attemptValue;
        System.out.println("If you want to play write anything other than 0");
        while(!((new Scanner(System.in)).next()).equals("0")){
            int randomValue = (int)(Math.random()*100);
            attemptAmount = 0;
            do{
                attemptAmount++;
                System.out.print("Try to quest the number: ");
                attemptValue = (new Scanner(System.in)).nextInt();
                if(attemptValue < randomValue)
                    System.out.println("Try something bigger!");
                else if(attemptValue > randomValue)
                    System.out.println("Try something smaller");
            }while(attemptValue != randomValue);
            System.out.println("You are right! You attempted at " + attemptAmount + " try!\nWanna try again?");
        }
        System.out.println("Thank you for playing! Goodbye.");
    }
}
