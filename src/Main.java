import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        final int N = sc.nextInt();
        int[] array = new int[N];
        double sum = 0;
        System.out.println("Enter " + N + " integers:");
        for(int i = 0; i < N; i++){
            array[i] = sc.nextInt();
            sum += array[i];
        }
        // Conditions are
        // heap <= 2/3sum
        // heap >= sum/3
        //
        // Can not be satisfied if:
        // There is an element that is > 2/3sum
        double high = sum/1.5; // to make calculations easier
        boolean possible = true;
        for(int i = 0; i < N; i++){
            if(array[i] > high){
                possible = false;
                break;
            }
        }
        if (!possible){
            System.out.println("It is impossible to divide the array into two heaps");
            return;
        }
        int current = 0;
        double low = sum/3;
        ArrayList<Integer> indexes = new ArrayList<>();
        for(int i = 0; i < N && current < low; i++) {
            if (current + array[i] < high) {
                current += array[i];
                indexes.add(i);
            }
        }
        System.out.print("First heap is:");
        for(int index : indexes){
            System.out.print(" " + array[index]);
        }
        System.out.print("\nSecond heap is:");
        for(int i = 0; i < N; i++){
            if(!indexes.contains(i)){
                System.out.print(" " + array[i]);
            }
        }
    }
}
