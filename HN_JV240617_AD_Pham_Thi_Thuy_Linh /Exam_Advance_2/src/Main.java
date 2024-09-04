import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the ISBN : ");
        String isbn = sc.nextLine();
        if(!isbn.matches("^[0-9]{10}$")) {
            System.err.println("Invalid ISBN.Please try again");
        }else{
            Stack<Integer> stack = new Stack<>();
            char[] arr = isbn.toCharArray();
            for(int i = 0; i < isbn.length(); i++) {
                stack.push(Integer.parseInt(String.valueOf(arr[i])));
            }
//            System.out.println(stack);
            int sum = 0;
            int count = 0;
            while(!stack.isEmpty()) {
                    count++;
                int pop = stack.pop();
                sum+=pop*count;
//                System.out.println(pop+"*" + count);
            }
//            System.out.println(sum);
            if(sum % 11 != 0){
                System.err.println(isbn+ " is not a valid ISBN");
            }else{
                System.out.println(isbn+" is a ISBN");
            }
        }
    }
}
