import java.util.*;

public class Logic {
    static int sproby = 0;
    static int amountOfShovedLetters = 1;
    static int numberAnswer = 0;
    static int previousLenghtOfFilterCopies = 1;
    Scanner scanner = new Scanner(System.in);
    Set<Integer> filterCopies = new LinkedHashSet<Integer>();
    List<String> maskedAnswer = new ArrayList<String>();
    List<String> answer = new ArrayList<String>();

    void start(int numberQuestion) {
        filterCopies.add(numberQuestion);
        System.out.println("\n" + QuestionsAndAnsvers.getQuestion(numberQuestion));
        maskAnsver(numberQuestion);
        System.out.print(maskedAnswer.toString());
        System.out.print("\t - " + QuestionsAndAnsvers.getAnsver(numberQuestion).length() + " letters" + "\n");

        if (QuestionsAndAnsvers.getAnsver(numberQuestion).equals((scanner.next()).toLowerCase())) {
            System.out.println("Так, це правильна відповідь!");
            maskedAnswer.clear();
            answer.clear();
            System.out.println("Бажаєте зіграти ще? (так/ні)");
            sproby = 0;
            amountOfShovedLetters = 1;
            oneMoreGame(numberQuestion);
        } else {
            System.out.println("Спробуйте ще раз:\n");
            sproby++;
            if (sproby >= 5) {
                System.out.println("Можливо потрібна допога?");
                System.out.println("(так/ні)");
                help(numberQuestion);
            }
            start(numberQuestion);
        }
    }

    private void help(int numberQuestion) {
        String yesOrNo = scanner.next().toLowerCase();
        if (yesOrNo.equals("ні")) {
            sproby = 0;
            start(numberQuestion);
        } else if (yesOrNo.equals("так")) {
            wordOrLetter(numberQuestion);
        } else {
            System.out.println("Неправильне введення, спробуйте ще раз:\n");
            help(numberQuestion);
        }
    }

    private void maskAnsver(int numberQuestion) {
        System.out.println("\n");
        char[] word = QuestionsAndAnsvers.getAnsver(numberQuestion).toCharArray();
        if(numberAnswer != numberQuestion) {
            for (int i = 0; i < QuestionsAndAnsvers.getAnsver(numberQuestion).length(); i++) {
                maskedAnswer.add("*");
                answer.add(String.valueOf(word[i]));
            }
            numberAnswer = numberQuestion;
        }
    }

    private void maskAnswerWithLetter(int numberQuestion) {
        for (int i = 0; i <amountOfShovedLetters ; i++) {
            maskedAnswer.set(i,answer.get(i));
            if (amountOfShovedLetters == QuestionsAndAnsvers.getAnsver(numberQuestion).length()) {
                System.out.println(answer+"\n");
                System.out.println("Бажаєте зіграти ще? (так/ні)");
                sproby = 0;
                amountOfShovedLetters = 1;
                maskedAnswer.clear();
                answer.clear();
                oneMoreGame(numberQuestion);
            }
        }
        amountOfShovedLetters++;
        System.out.println(maskedAnswer.toString());
    }

    private void randomQuestionsWithotRepits(int numberQuestion) {
        Random random = new Random();
        numberQuestion = 0 + random.nextInt(5);
        filterCopies.add(numberQuestion);
        if (filterCopies.size() > previousLenghtOfFilterCopies) {
            previousLenghtOfFilterCopies++;
            if (filterCopies.size() == 6) {
                previousLenghtOfFilterCopies = 1;
                filterCopies.clear();
            }
            start(numberQuestion);
        } else {
            randomQuestionsWithotRepits(numberQuestion);
        }
    }

    private void oneMoreGame(int numberQuestion) {

        String yesOrNo = scanner.next();
        if (yesOrNo.equals("так")) {
            randomQuestionsWithotRepits(numberQuestion);
        } else if (yesOrNo.equals("ні")) {
            return;
        } else {
            System.out.println("Неправильні параметри вводу, спробуйте ще раз :\n");
            oneMoreGame(numberQuestion);
        }
    }

    private void wordOrLetter(int numberQuestion) {
        System.out.println("Ок, показати одну літеру чи ціле слово?");
        System.out.println("(літера/cлово)");
        String wordOrLetter = scanner.next().toLowerCase();
        if (wordOrLetter.equals("літера")) {
            maskAnswerWithLetter(numberQuestion);
            start(numberQuestion);
            sproby = 0;
        } else if (wordOrLetter.equals("слово")) {
            System.out.println("\n" + QuestionsAndAnsvers.getAnsver(numberQuestion));
            System.out.println("Бажаєте зіграти ще? (так/ні)");
            maskedAnswer.clear();
            answer.clear();
            sproby = 0;
            amountOfShovedLetters = 1;
            oneMoreGame(numberQuestion);
        } else {
            System.out.println("Неправильне введення, спробуйте ще раз");
            wordOrLetter(numberQuestion);
        }
    }
}