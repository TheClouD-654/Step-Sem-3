import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract LocalDate getDueDate(LocalDate currentDate);
}

class BookItem extends LibraryItem {
    public BookItem(String title) {
        super(title);
    }

    @Override
    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14);
    }
}

class DvdItem extends LibraryItem {
    public DvdItem(String title) {
        super(title);
    }

    @Override
    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title) {
        super(title);
    }

    @Override
    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3);
    }
}

public class LibrarySystem {
    public static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    public static LibraryItem createItem(String type, String title) {
        switch (type.toUpperCase()) {
            case "BOOK":
                return new BookItem(title);
            case "DVD":
                return new DvdItem(title);
            case "MAGAZINE":
                return new MagazineItem(title);
            default:
                throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace).trim();
            String rawTitle = line.substring(firstSpace + 1).trim();

            if (rawTitle.startsWith("\"") && rawTitle.endsWith("\"") && rawTitle.length() >= 2) {
                rawTitle = rawTitle.substring(1, rawTitle.length() - 1);
            }

            items.add(createItem(type, rawTitle));
        }

        for (LibraryItem item : items) {
            LocalDate dueDate = item.getDueDate(CURRENT_DATE);
            System.out.println(item.getTitle() + ": " + dueDate);
        }

        scanner.close();
    }
}
