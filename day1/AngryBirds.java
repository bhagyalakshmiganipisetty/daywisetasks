import java.util.*;

public class AngryBirds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Number of nests
        int b = sc.nextInt(); // Number of birds
        int[] nests = new int[n];

        for (int i = 0; i < n; i++) {
            nests[i] = sc.nextInt();
        }

        Arrays.sort(nests); // Step 1: Sort nest positions

        int left = 1, right = nests[n - 1] - nests[0];
        int maxDist = 0;

        // Binary Search on minimum possible distance
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPlaceBirds(nests, b, mid)) {
                maxDist = mid;  // Update answer
                left = mid + 1; // Try for a larger minimum distance
            } else {
                right = mid - 1; // Try for a smaller minimum distance
            }
        }

        System.out.println(maxDist);
        sc.close();
    }

    private static boolean canPlaceBirds(int[] nests, int B, int minDist) {
        int birdsPlaced = 1, lastPlaced = nests[0];

        for (int i = 1; i < nests.length; i++) {
            if (nests[i] - lastPlaced >= minDist) {
                birdsPlaced++;
                lastPlaced = nests[i];
                if (birdsPlaced == B) return true;
            }
        }
        return false;
    }
}
