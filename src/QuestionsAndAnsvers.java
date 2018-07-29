
public class QuestionsAndAnsvers {
    private static String[][] s = new String[7][2];
   private static String questionsAndAnswers(int a, int b) {
       s[1][0] = "Найбільш оплачувана професія в США";
       s[1][1] = "лікар";
       s[2][0] = "Те, що не їдять мосульмани";
       s[2][1] = "свинина";
       s[3][0] = "Одиниця вимірювання опору";
       s[3][1] = "ом";
       s[4][0] = "Те, що робила машина «Энигма»";
       s[4][1] = "шифр";
       s[5][0] = "Дуже ароматна рослина, містить багато ментолу";
       s[5][1] = "м'ята";
       s[6][0] = "Книга великого розміру і товщини";
       s[6][1] = "том";
       return s[a][b];
   }

    static String getQuestion(int a ) {
       return questionsAndAnswers(a, 0);
    }
    static String getAnsver(int a) {
       return questionsAndAnswers(a, 1);
    }
}
