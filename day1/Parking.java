import java.util.Scanner;

public class Parking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxSlots = 0;
        int count = 0;

        // Read the number of slots
        int n = sc.nextInt();
        String parkingLot = sc.next(); // Read the entire string in one go

        // Process each character
        for (char c : parkingLot.toCharArray()) {
            if (c == 'S') {
                count++;
                maxSlots = Math.max(maxSlots, count);
            } else {
                count = 0; // Reset when encountering 'X'
            }
        }

        System.out.println(maxSlots); // Output the result

        sc.close();
    }
}
