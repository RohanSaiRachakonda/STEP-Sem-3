import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class representing an examination question
abstract class ExamQuestion {
    protected String questionText;
    protected String correctAnswer;
    protected int points;

    public ExamQuestion(String questionText, String correctAnswer, int points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.points = points;
    }

    public abstract double evaluate(String studentAnswer);
    public abstract String getQuestionType();
}

class MultipleChoiceQuestion extends ExamQuestion {
    public MultipleChoiceQuestion(String questionText, String correctAnswer, int points) {
        super(questionText, correctAnswer, points);
    }

    @Override
    public double evaluate(String studentAnswer) {
        return correctAnswer.trim().equals(studentAnswer.trim()) ? points : 0.0;
    }

    @Override
    public String getQuestionType() {
        return "MCQ";
    }
}

class TrueFalseQuestion extends ExamQuestion {
    public TrueFalseQuestion(String questionText, String correctAnswer, int points) {
        super(questionText, correctAnswer, points);
    }

    @Override
    public double evaluate(String studentAnswer) {
        return correctAnswer.trim().equalsIgnoreCase(studentAnswer.trim()) ? points : 0.0;
    }

    @Override
    public String getQuestionType() {
        return "TF";
    }
}

class EssayQuestion extends ExamQuestion {
    public EssayQuestion(String questionText, String correctAnswer, int points) {
        super(questionText, correctAnswer, points);
    }

    @Override
    public double evaluate(String studentAnswer) {
        String[] keywords = correctAnswer.split(",");
        String studentLower = studentAnswer.toLowerCase();
        int matchedKeywords = 0;

        for (String kw : keywords) {
            String trimmedKw = kw.trim().toLowerCase();
            if (!trimmedKw.isEmpty() && studentLower.contains(trimmedKw)) {
                matchedKeywords++;
            }
        }

        if (matchedKeywords >= 2) {
            return points * 0.75; // 75% for at least two keywords
        } else if (matchedKeywords == 1) {
            return points * 0.50; // 50% for one keyword
        } else {
            return 0.0;
        }
    }

    @Override
    public String getQuestionType() {
        return "ESSAY";
    }
}

public class ExaminationQuestionGrader {

    public static class Submission {
        ExamQuestion question;
        String studentAnswer;

        public Submission(ExamQuestion question, String studentAnswer) {
            this.question = question;
            this.studentAnswer = studentAnswer;
        }
    }

    public static void gradeSubmissions(List<Submission> submissions) {
        double totalScore = 0.0;
        for (Submission sub : submissions) {
            double score = sub.question.evaluate(sub.studentAnswer);
            totalScore += score;
            System.out.printf("%s: %.2f%n", sub.question.getQuestionType(), score);
        }
        System.out.printf("Total Score: %.2f%n", totalScore);
    }

    public static void main(String[] args) {
        List<Submission> submissions = new ArrayList<>();

        // Default sample test cases matching Problem 4
        submissions.add(new Submission(
            new MultipleChoiceQuestion("What is the capital of France?", "Paris", 10),
            "Paris"
        ));
        submissions.add(new Submission(
            new TrueFalseQuestion("The Earth is flat?", "False", 5),
            "True"
        ));
        submissions.add(new Submission(
            new EssayQuestion("Name two primary OOP principles.", "Inheritance, Polymorphism, Encapsulation", 20),
            "Polymorphism is one."
        ));
        submissions.add(new Submission(
            new EssayQuestion("Describe abstraction and composition.", "Abstraction, Composition", 15),
            "I talked about abstraction."
        ));

        gradeSubmissions(submissions);
    }
}
