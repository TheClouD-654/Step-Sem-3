import java.util.Scanner;

public class twosum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many values do you want to enter? ");
        int size = input.nextInt();
        int[] nums = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            nums[i] = input.nextInt();
        }

        System.out.print("Enter target value: ");
        int target = input.nextInt();
        boolean found = false;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println("Indices: " + i + " and " + j);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No two values add up to " + target + ".");
        }

        input.close();
    }
}
