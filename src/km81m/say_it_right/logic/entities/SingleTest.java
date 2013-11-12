package km81m.say_it_right.logic.entities;

import km81m.say_it_right.logic.Level;

import java.io.Serializable;

/**
 * User: alexeydushenin
 * Date: 11/3/13
 * Time: 2:15 PM
 * Simple test, contains one word, entity in DB
 */
public class SingleTest implements Serializable {

    private String word;
    //position in word
    private int answer;
    private Level level;

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

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
