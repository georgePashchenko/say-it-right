package km81m.say_it_right.logic;

/**
 * User: alexeydushenin
 * Date: 11/3/13
 * Time: 2:25 PM
 */
public class UserAnswer {

    private int[] answers = new int[10];

    public void addAnswer(int question, int result) {
        if (question < 0 || question >= answers.length) {
            throw new IllegalArgumentException("question number must be 0..9, but = " + question);
        }
        answers[question] = result;
    }

    public int getAnswer(int question) {
        if (question < 0 || question >= answers.length) {
            throw new IllegalArgumentException("question number must be 0..9, but = " + question);
        }
        return answers[question];
    }

}
