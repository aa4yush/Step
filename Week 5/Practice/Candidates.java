import java.util.Arrays;

class Candidates implements Comparable<Candidates> {

    private String name;
    private double cgpa;
    private int codingScore;

    public Candidates(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    double compositeScore() {
        return cgpa * 10 + codingScore;
    }

    @Override
    public int compareTo(Candidates other) {
        return Double.compare(
                other.compositeScore(),
                this.compositeScore()
        );
    }

    String getName() {
        return name;
    }

    static String shortlistAndRank(Candidates[] candidates) {

        Candidates[] shortlisted = new Candidates[candidates.length];

        int count = 0;

        for (Candidates c : candidates) {

            if (isEligible(c.cgpa) ||
                    isEligible(c.cgpa, c.codingScore)) {

                shortlisted[count] = c;
                count++;
            }
        }

        shortlisted = Arrays.copyOf(shortlisted, count);

        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {

            result += (i + 1) + ". "
                    + shortlisted[i].getName()
                    + " (" + shortlisted[i].compositeScore() + ")";

            if (i < shortlisted.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Candidates[] candidates = {
                new Candidates("Aisha", 8.2, 40),
                new Candidates("Rohit", 6.8, 65),
                new Candidates("Meena", 6.0, 90),
                new Candidates("Karan", 7.5, 20)
        };

        System.out.println(
                Candidates .shortlistAndRank(candidates)
        );
    }
}
