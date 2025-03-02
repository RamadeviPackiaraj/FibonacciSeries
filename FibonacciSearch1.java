import java.util.Arrays;
import java.util.Scanner;
public class FibonacciSearch1{
public static int fibonacciSearch(int[] arr,int target){
    int n=arr.length;
    int fib2=0;
    int fib1=1;
    int fib =fib1+fib2;
    //smallest fibonacci number
    while(fib<n){
        fib2=fib1;
        fib1=fib;
        fib=fib2+fib1;
    }
    int offset=-1;
    
    while(fib>1){
        int i=Math.min(offset+fib2,n-1);
        //search right
        if(arr[i]<target){
            fib=fib1;
            fib1=fib2;
            fib2=fib-fib1;
            offset=i;
        }
        //search left
        else if(arr[i]>target){
            fib=fib2;
            fib1=fib1-fib2;
            fib2=fib-fib1;
        }
        else{
            return i;
        }
    }
        return -1;
    }

public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Array Size:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter "+n+"Array Elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the Target element:");
        int target=sc.nextInt();
        int index=fibonacciSearch(arr,target);
        if(index==-1)
            System.out.println("Element not found");
        else{
            System.out.println("Elemt fount at the Index of "+index);
        }
        sc.close();
    }
}