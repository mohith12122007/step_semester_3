package session_seven_oop_fundamentals.class_problems;
public class NameTag {

    private final String firstName;
    private final String lastInitial; // splitting done ONCE, in the constructor

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastInitial = parts[1].substring(0, 1);
    }

    public String getNickname() {
        return firstName + " " + lastInitial + ".";
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname()); // Maria G.
    }
}