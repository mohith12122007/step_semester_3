package session_eight_oop_fundamentals_practice.class_problems;

import java.util.*;
import java.util.regex.*;

public class ExamGrader {
    private static final Pattern QUOTED = Pattern.compile("\"([^\"]*)\"");

    abstract static class Question {
        protected final String correctAnswer, studentAnswer;
        protected final int points;
        protected Question(String correct, String student, int points) {
            this.correctAnswer = correct; this.studentAnswer = student; this.points = points;
        }
        public abstract String getTypeName();
        public abstract double grade();
    }

    static class MCQQuestion extends Question {
        MCQQuestion(String c, String s, int p) { super(c, s, p); }
        public String getTypeName() { return "MCQ"; }
        public double grade() { return correctAnswer.equals(studentAnswer) ? points : 0; }
    }

    static class TFQuestion extends Question {
        TFQuestion(String c, String s, int p) { super(c, s, p); }
        public String getTypeName() { return "TF"; }
        public double grade() { return correctAnswer.equals(studentAnswer) ? points : 0; }
    }

    static class EssayQuestion extends Question {
        EssayQuestion(String c, String s, int p) { super(c, s, p); }
        public String getTypeName() { return "ESSAY"; }
        public double grade() {
            String student = studentAnswer.toLowerCase();
            int matches = 0;
            for (String kw : correctAnswer.split(","))
                if (student.contains(kw.trim().toLowerCase())) matches++;
            if (matches >= 2) return points * 0.75;
            if (matches == 1) return points * 0.50;
            return 0;
        }
    }

    static Question parseQuestion(String line) {
        String type = line.substring(0, line.indexOf(' ')).trim();
        List<String> quoted = new ArrayList<>();
        Matcher m = QUOTED.matcher(line);
        while (m.find()) quoted.add(m.group(1));
        int points = Integer.parseInt(line.substring(line.lastIndexOf(' ') + 1).trim());
        switch (type) {
            case "MCQ":   return new MCQQuestion(quoted.get(1), quoted.get(2), points);
            case "TF":    return new TFQuestion(quoted.get(1), quoted.get(2), points);
            case "ESSAY": return new EssayQuestion(quoted.get(1), quoted.get(2), points);
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < n; i++)
            questions.add(parseQuestion(sc.nextLine()));
        double total = 0;
        for (Question q : questions) {                // uniform, no type checks
            double score = q.grade();
            System.out.printf(Locale.US, "%s: %.2f%n", q.getTypeName(), score);
            total += score;
        }
        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
    }
}