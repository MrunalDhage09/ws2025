import java.util.Scanner;
public class Array {
    public static void main(String [] args){
        int [] arr={1};
        int n= arr.length+1;
        int totalSum=n*(n+1)/2;

        int arraySum=0;
        for(int i=0;i<arr.length;i++){
            arraySum+=arr[i];
        }
        int missing=totalSum-arraySum;
        System.out.println(missing);

    }

}
