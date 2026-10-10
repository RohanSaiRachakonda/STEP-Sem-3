import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;
    private double compositeScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
        // Composite score: (CGPA * 10.0) + (Coding Score * 0.5)
        this.compositeScore = (cgpa * 10.0) + (codingScore * 0.5);
    }

    // Overloaded eligibility rule 1: CGPA-only filter for established students
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    // Overloaded eligibility rule 2: Combined CGPA and coding score for borderline cases
    public static boolean isEligible(double cgpa, int codingScore) {
        if (isEligible(cgpa)) {
            return true;
        }
        return cgpa >= 6.5 && codingScore >= 60;
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

    public double getCompositeScore() {
        return compositeScore;
    }

    // Comparable implementation to rank candidates by composite score descending
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.compositeScore, this.compositeScore);
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null || candidates.length == 0) {
            return "";
        }

        List<Candidate> qualified = new ArrayList<>();
        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa(), c.getCodingScore())) {
                qualified.add(c);
            }
        }

        Candidate[] qualifiedArray = qualified.toArray(new Candidate[0]);
        // Arrays.sort relies directly on compareTo
        Arrays.sort(qualifiedArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < qualifiedArray.length; i++) {
            Candidate c = qualifiedArray[i];
            sb.append(String.format("%d. %s (%.1f)", i + 1, c.getName(), c.getCompositeScore()));
            if (i < qualifiedArray.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
}

public class PlacementDriveRankingEngine {

    public static String shortlistAndRank(Candidate[] candidates) {
        return Candidate.shortlistAndRank(candidates);
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        String result = shortlistAndRank(candidates);
        System.out.println(result);
        // Expected: 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)
    }
}
