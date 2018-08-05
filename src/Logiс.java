import java.util.*;

public class Logiс {
    private static int tries = 0;
    private static int amountOfShovedLetters = 1;
    private static int numberAnswer = 0;
    private static int previousLenghtOfFilterCopies = 1;
    private static int checkChanges = 0;
    private Scanner scanner = new Scanner(System.in);
    private Set<Integer> filterCopies = new LinkedHashSet<>();
    private List<String> maskedAnswer = new ArrayList<>();
    private List<String> answer = new ArrayList<>();

    void start(int numberQuestion) {
        filterCopies.add(numberQuestion);
        System.out.println("\n" + QuestionsAndAnsvers.getQuestion(numberQuestion));
        maskAnsver(numberQuestion);
        System.out.print(maskedAnswer.toString());
        System.out.print("\t - " + QuestionsAndAnsvers.getAnsver(numberQuestion).length() + " letters" + "\n");
        scanAnswer(numberQuestion);
    }

    private void scanAnswer(int numberQuestion) {
        char[] ansverLetters = QuestionsAndAnsvers.getAnsver(numberQuestion).toCharArray();
        String enterLetter = scanner.next().toLowerCase();
        if (enterLetter.length() < 2) {
            checkLetter(ansverLetters,enterLetter,numberQuestion);
        } else {
            System.out.println("Неправильний ввід даних, спробуйте ще раз\nВведіть одну літеру: ");
            scanAnswer(numberQuestion);
        }
    }

    private void checkLetter(char[] ansverLetters, String enterLetter, int numberQuestion) {
        for (int i = 0; i < QuestionsAndAnsvers.getAnsver(numberQuestion).length(); i++) {
            if (ansverLetters[i] == enterLetter.charAt(0)) {
                if (maskedAnswer.get(i).charAt(0) == '*') {
                    tries = 0;
                    maskedAnswerWithLetter(numberQuestion, i);
                    checkChanges++;
                    break;
                }
            }
        }
        if (checkChanges > 0) {
            checkChanges=0;
            scanAnswer(numberQuestion);
        } else {
            if (tries > 4) {
                System.out.println("Можливо потрібна допомога?");
                System.out.println("(так/ні)");
                help(numberQuestion);
                } else {
                System.out.println("Такої букви немає, спробуйте ще раз");
                tries++;
                scanAnswer(numberQuestion);
            }
        }
    }

    private void help(int numberQuestion) {
        String yesOrNo = scanner.next().toLowerCase();
        switch (yesOrNo) {
            case "ні":
                tries = 0;
                start(numberQuestion);
                break;
            case "так":
                tries = 0;
                wordOrLetter(numberQuestion);
                break;
            default:
                System.out.println("Неправильне введення, спробуйте ще раз:\n");
                help(numberQuestion);
                break;
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

    private void maskedAnswerWithLetter(int numberQuestion, int numberLetter) {
        maskedAnswer.set(numberLetter, answer.get(numberLetter));
        if (amountOfShovedLetters == QuestionsAndAnsvers.getAnsver(numberQuestion).length()) {
            System.out.println(answer + "\n");
            System.out.println("Бажаєте зіграти ще? (так/ні)");
            tries = 0;
            amountOfShovedLetters = 1;
            maskedAnswer.clear();
            answer.clear();
            oneMoreGame();
        }
        amountOfShovedLetters++;
        System.out.println(maskedAnswer.toString());
    }

    private void randomQuestionsWithoutRepeats() {
        Random random = new Random();
        int numberQuestion = random.nextInt(5);
        filterCopies.add(numberQuestion);
        if (filterCopies.size() > previousLenghtOfFilterCopies) {
            previousLenghtOfFilterCopies++;
            if (filterCopies.size() == 6) {
                previousLenghtOfFilterCopies = 1;
                filterCopies.clear();

            }
            start(numberQuestion);
        } else {
            randomQuestionsWithoutRepeats();
        }
    }

    private void oneMoreGame() {

        String yesOrNo = scanner.next();
        switch (yesOrNo) {
            case "так":
                randomQuestionsWithoutRepeats();
                break;
            case "ні":

                break;
            default:
                System.out.println("Неправильні параметри вводу, спробуйте ще раз :\n");
                oneMoreGame();
                break;
        }
    }

    private void wordOrLetter(int numberQuestion) {
        System.out.println("Ок, показати одну літеру чи ціле слово?");
        System.out.println("(літера/cлово)");
        String wordOrLetter = scanner.next().toLowerCase();
        switch (wordOrLetter) {
            case "літера":
                for (int i = 0; i < QuestionsAndAnsvers.getAnsver(numberQuestion).length(); i++) {
                    if (maskedAnswer.get(i).charAt(0) == '*') {
                        maskedAnswer.set(i, answer.get(i));
                        break;
                    }
                }
                start(numberQuestion);
                tries = 0;
                break;
            case "слово":
                System.out.println("\n" + QuestionsAndAnsvers.getAnsver(numberQuestion));
                System.out.println("Бажаєте зіграти ще? (так/ні)");
                maskedAnswer.clear();
                answer.clear();
                tries = 0;
                amountOfShovedLetters = 1;
                oneMoreGame();
                break;
            default:
                System.out.println("Неправильне введення, спробуйте ще раз");
                wordOrLetter(numberQuestion);
                break;
        }
    }
}