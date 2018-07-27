
public class QuestionsAndAnsvers {
    private static String[][] s = new String[6][2];
    static int a;
   private static String questionsAndAnsvers(int a, int b){
        s[0][0] = "Книга великого розміру і товщини";
        s[0][1] = "том";
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
       return s[a][b];
    }

    static String getQuestion(int a ) {
       return questionsAndAnsvers(a, 0);
    }
    static String getAnsver(int a) {
       return questionsAndAnsvers(a, 1);
    }
}
