import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Question {
    protected String type;
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String type, String questionText, String correctAnswer, String studentAnswer, double points) {
        this.type = type;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public String getType() {
        return type;
    }

    public abstract double evaluateScore();
}

class McqQuestion extends Question {
    public McqQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super("MCQ", questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        if (correctAnswer.trim().equalsIgnoreCase(studentAnswer.trim())) {
            return points;
        }
        return 0.0;
    }
}

class TfQuestion extends Question {
    public TfQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super("TF", questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        if (correctAnswer.trim().equalsIgnoreCase(studentAnswer.trim())) {
            return points;
        }
        return 0.0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super("ESSAY", questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        String[] keywords = correctAnswer.split(",");
        int matchedCount = 0;
        String studentTextLower = studentAnswer.toLowerCase();

        for (String kw : keywords) {
            String cleanKw = kw.trim().toLowerCase();
            if (!cleanKw.isEmpty() && studentTextLower.contains(cleanKw)) {
                matchedCount++;
            }
        }

        if (matchedCount >= 2) {
            return points * 0.75;
        } else if (matchedCount == 1) {
            return points * 0.50;
        }
        return 0.0;
    }
}

public class ExamGrader {
    public static List<String> parseTokens(String line) {
        List<String> tokens = new ArrayList<>();
        Matcher matcher = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                tokens.add(matcher.group(1));
            } else {
                tokens.add(matcher.group(2));
            }
        }
        return tokens;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            List<String> tokens = parseTokens(line);
            String type = tokens.get(0).toUpperCase();
            String questionText = tokens.get(1);
            String correctAnswer = tokens.get(2);
            String studentAnswer = tokens.get(3);
            double points = Double.parseDouble(tokens.get(4));

            switch (type) {
                case "MCQ":
                    questions.add(new McqQuestion(questionText, correctAnswer, studentAnswer, points));
                    break;
                case "TF":
                    questions.add(new TfQuestion(questionText, correctAnswer, studentAnswer, points));
                    break;
                case "ESSAY":
                    questions.add(new EssayQuestion(questionText, correctAnswer, studentAnswer, points));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown question type: " + type);
            }
        }

        double totalScore = 0.0;
        for (Question q : questions) {
            double score = q.evaluateScore();
            System.out.printf(Locale.US, "%s: %.2f%n", q.getType(), score);
            totalScore += score;
        }

        System.out.printf(Locale.US, "Total Score: %.2f%n", totalScore);
        scanner.close();
    }
}
