package session_five_oop_fundamentals_practice.class_problems;
import java.util.Arrays;

class Candidate implements Comparable<Candidate> {

    private String name;
    private double cgpa;
    private int codingScore;

    // Constructor
    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCodingScore() {
        return codingScore;
    }

    // Composite score: cgpa*10 + codingScore/2
    // (Aisha: 102.0, Rohit: 100.5, Karan: 85.0)
    public double getCompositeScore() {
        return cgpa * 10 + codingScore / 2.0;
    }

    @Override
    public int compareTo(Candidate other) {
        // Descending order by composite score
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }
}

public class PlacementEngine {

    // Overload 1: CGPA-only quick filter (bar = 7.0)
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    // Overload 2: combined check for borderline cases (CGPA >= 6.5 AND coding >= 60)
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    static String shortlistAndRank(Candidate[] candidates) {
        // Step 1: Shortlist
        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa()) || isEligible(c.getCgpa(), c.getCodingScore())) {
                shortlisted[count++] = c;
            }
        }

        // Trim the unused slots
        Candidate[] finalList = Arrays.copyOf(shortlisted, count);

        // Step 2: Rank — compareTo() does all the work
        Arrays.sort(finalList);

        // Step 3: Build the result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < finalList.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ")
                  .append(finalList[i].getName())
                  .append(" (").append(finalList[i].getCompositeScore()).append(")");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("mohith", 9.7, 40),
            new Candidate("ullas", 6.8, 65),
            new Candidate("Minnu", 6.0, 90),
            new Candidate("bodi", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
        
    }
}