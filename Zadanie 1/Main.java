package main;

public class Main {

    public static void main(String[] args) {
        int[] abc = new int[3]; int i = 0;
        for(String s : args){
            try{
                abc[i] = Integer.parseInt(s);
                if(++i == 3) {
                    System.out.println("Already enough arguments!");
                    break;
                }
            }
            catch(NumberFormatException e){
                System.out.println("The argument isn't an integer.");
            }
        }
        int a = abc[0], b = abc[1], c = abc[2];
        int delta = countDelta(a, b, c);
        if(a != 0){
            System.out.print("Delta = " + delta + ". ");
            if(delta < 0)
                System.out.println("Funkcja nie ma miejsc zerowych! Delta jest ujemna");
            else if(delta == 0)
                System.out.println("Funkcja ma jedno miejsce zerowe: " + (- b/(2*a)));
            else
            System.out.println("Funkcja ma dwa miejsca zerowe: " + ((-b+Math.sqrt(delta)/(2*a))) + " " +  ((-b-Math.sqrt(delta)/(2*a))));
        }
        else{
            System.out.println("Funkcja ma jedno miejsce zerowe: " + (-c/b));
        }
    }
    static int countDelta(int a, int b, int c){
        return b*b - 4*a*c;
    }
}




