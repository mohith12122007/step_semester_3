package session_five_oop_fundamentals_practice.assignment_problems;
import java.util.Arrays;

class Player implements Comparable<Player> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    // Constructor
    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Getters (encapsulation)
    public String getName() { return name; }
    public int getMatchesPlayed() { return matchesPlayed; }
    public double getBattingAverage() { return battingAverage; }
    public boolean isInjured() { return injured; }

    @Override
    public int compareTo(Player other) {
        // Rank by fantasy points (batting average), descending
        return Double.compare(other.getBattingAverage(), this.getBattingAverage());
    }
}

public class DraftEngine {

    // Overload 1: experience-only rule — established players (10+ matches)
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Overload 2: combined rule — newer players need 5+ matches AND must be fit
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    static String draftAndRank(Player[] players) {
        // Step 1: Shortlist draftable players
        Player[] draftable = new Player[players.length];
        int count = 0;

        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftable[count++] = p;
            }
        }

        Player[] finalList = Arrays.copyOf(draftable, count);

        // Step 2: Rank — compareTo() does all the work
        Arrays.sort(finalList);

        // Step 3: Build the result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < finalList.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ").append(finalList[i].getName());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Mohith", 15, 48.0, false),
            new Player("Ullas", 7, 55.0, false),
            new Player("Arun", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players)); // 1. Rahul | 2. Virat | 3. Dev
    }
}