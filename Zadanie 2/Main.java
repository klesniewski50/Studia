package main;

public class Main {
    public static void main(String[] args) {
        String text = args[0];
        int begin = 0, end = text.length(), i = 0;
        while(i < args.length){
            try{
                begin = Integer.parseInt(args[i++]);
                break;
            }
            catch(NumberFormatException e){
                System.out.println("Wrong argument type!");
                i++;
            }
        }
        while(i < args.length){
            try{
                end = Integer.parseInt(args[i]);
                break;
            }
            catch(NumberFormatException e){
                System.out.println("Wrong argument type!");
                i++;
            }
        }
        try{
            System.out.println("Result: " + String.copyValueOf(text.toCharArray(), begin, end - begin + 1));
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println("Index out of range!");
        }
    }
}
