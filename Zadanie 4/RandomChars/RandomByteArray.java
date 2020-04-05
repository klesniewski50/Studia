package RandomChars;
import java.util.Random;

public class RandomByteArray {
    private byte[] arr;
    private int size;
    public RandomByteArray(int size){
        this.size = size;
        if(size <= 0){
            throw new NegativeArraySizeException();
        }
        arr = new byte[size];
    }
    public RandomByteArray randomise(){
        for(int i = 0; i < size; i++){
            arr[i] = (byte)(Math.random()*95 + 35);
        }
        return this;
    }
    public String toString(){
        return ((new StringBuilder()).append(this.toCharArray())).toString();
    }
    public char[] toCharArray(){
        char[] toReturn = new char[size];
        for(int i = 0; i < size; i++){
            toReturn[i] = (char)arr[i];
        }
        return toReturn;
    }
    public static char[] toCharArray(byte[] input){
        char[] toReturn = new char[input.length];
        for(int i = 0; i < input.length; i++){
            toReturn[i] = (char)input[i];
        }
        return toReturn;
    }
    public int getSize(){
        return size;
    }
    public byte[] getArr(){
        return arr;
    }
}
