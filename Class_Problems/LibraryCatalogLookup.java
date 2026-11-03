import java.util.Scanner;

public class LibraryCatalogLookup {
    public static String findBook(String[][] catalog, String targetIsbn) {
        int lo = 0, hi = catalog.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = catalog[mid][0].compareTo(targetIsbn);
            if (cmp == 0) return catalog[mid][1];
            else if (cmp < 0) lo = mid + 1;
            else hi = mid - 1;
        }
        return "Not Found";
    }

    // Time: O(log n) per query, Space: O(1)
    // Binary search is ideal because the catalog is sorted and queried far more than updated
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        String[][] catalog = new String[n][2];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            int sep = line.indexOf(' ');
            catalog[i][0] = line.substring(0, sep);
            catalog[i][1] = line.substring(sep + 1);
        }

        int q = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < q; i++) {
            String isbn = scanner.nextLine().trim();
            System.out.println(findBook(catalog, isbn));
        }

        scanner.close();
    }
}

