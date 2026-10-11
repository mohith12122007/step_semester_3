package session_eight_oop_fundamentals_practice.class_problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LibrarySystem {
    private static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    abstract static class LibraryItem {
        protected final String title;
        protected LibraryItem(String title) { this.title = title; }
        public String getTitle() { return title; }
        public abstract int getBorrowDays();
        public LocalDate getDueDate() { return CURRENT_DATE.plusDays(getBorrowDays()); }
    }

    static class Book extends LibraryItem {
        Book(String title) { super(title); }
        public int getBorrowDays() { return 14; }
    }

    static class DVD extends LibraryItem {
        DVD(String title) { super(title); }
        public int getBorrowDays() { return 7; }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) { super(title); }
        public int getBorrowDays() { return 3; }
    }

    static LibraryItem createItem(String type, String title) {
        switch (type) {
            case "BOOK":     return new Book(title);
            case "DVD":      return new DVD(title);
            case "MAGAZINE": return new Magazine(title);
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String type = line.substring(0, line.indexOf(' '));
            String title = line.substring(line.indexOf(' ') + 1).trim();
            if (title.startsWith("\"") && title.endsWith("\""))
                title = title.substring(1, title.length() - 1);
            items.add(createItem(type, title));
        }
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (LibraryItem item : items)                  // uniform, no type checks
            System.out.println(item.getTitle() + ": " + fmt.format(item.getDueDate()));
    }
}