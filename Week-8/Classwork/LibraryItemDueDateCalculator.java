import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class representing a library item
abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    // Common polymorphic method to calculate due date
    public abstract LocalDate calculateDueDate(LocalDate currentDate);
}

class BookItem extends LibraryItem {
    public BookItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14); // 14-day borrowing period
    }
}

class DvdItem extends LibraryItem {
    public DvdItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7); // 7-day borrowing period
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3); // 3-day borrowing period
    }
}

public class LibraryItemDueDateCalculator {

    public static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    // Central processor displaying due dates uniformly
    public static void displayDueDates(List<LibraryItem> items, LocalDate currentDate) {
        for (LibraryItem item : items) {
            LocalDate dueDate = item.calculateDueDate(currentDate);
            System.out.println(item.getTitle() + ": " + dueDate);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<LibraryItem> items = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            sc.nextLine(); // consume newline
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine().trim();
                int firstSpace = line.indexOf(' ');
                String type = line.substring(0, firstSpace).toUpperCase();
                String title = line.substring(firstSpace + 1).trim();
                if (title.startsWith("\"") && title.endsWith("\"")) {
                    title = title.substring(1, title.length() - 1);
                }
                switch (type) {
                    case "BOOK":
                        items.add(new BookItem(title));
                        break;
                    case "DVD":
                        items.add(new DvdItem(title));
                        break;
                    case "MAGAZINE":
                        items.add(new MagazineItem(title));
                        break;
                }
            }
            displayDueDates(items, CURRENT_DATE);
        } else {
            // Default sample demonstration
            items.add(new BookItem("1984"));
            items.add(new DvdItem("The Matrix"));
            items.add(new MagazineItem("Forbes Issue 500"));
            displayDueDates(items, CURRENT_DATE);
        }
        sc.close();
    }
}
