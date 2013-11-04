package km81m.say_it_right.logic.entities;

/**
 * User: alexeydushenin
 * Date: 11/3/13
 * Time: 2:15 PM
 * Simple test, contains one word, entity in DB
 */
public class SingleTest {

    private String word;
    //position in word
    private int answer;
    private int level;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
