package session_seven_oop_fundamentals.assignment_problems;

public class TrafficLight {

    private String color; // private, and next() is the ONLY door in or out
    private final String id;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED"; // every new light starts on red
    }

    public void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else { // YELLOW -> back to RED
            color = "RED";
        }
    }

    public String getColor() { // read-only
        return color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println(t.getColor()); // RED
        t.next();
        System.out.println(t.getColor()); // GREEN
        t.next();
        System.out.println(t.getColor()); // YELLOW
        t.next();
        System.out.println(t.getColor()); // RED
    }
}