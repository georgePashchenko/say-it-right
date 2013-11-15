package km81m.say_it_right.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import km81m.say_it_right.R;
import km81m.say_it_right.logic.TestBlock;
import km81m.say_it_right.logic.UserAnswer;
import km81m.say_it_right.logic.entities.SingleTest;

import java.util.ArrayList;
import java.util.List;

/**
 * User: alexeydushenin
 * Date: 11/12/13
 * Time: 5:13 PM
 */
public class TestObjectFragment extends Fragment {

    private UserAnswer userAnswer;
    private TestBlock testBlock;

    public TestObjectFragment(UserAnswer userAnswer, TestBlock testBlock) {
        this.userAnswer = userAnswer;
        this.testBlock = testBlock;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.simple_test, container, false);
        Bundle args = getArguments();
        final int pos = args.getInt("pos");

        TextView textView = (TextView) rootView.findViewById(R.id.simple_test_label);
        textView.setText("Тест №" + (pos + 1) + "/10");

        final List<Button> buttons = new ArrayList<Button>();

        LinearLayout layout = (LinearLayout) rootView.findViewById(R.id.simple_test_layout);
        final SingleTest test = testBlock.getSingleTests().get(pos);
        for (int i = 0; i < test.getWord().length(); i++) {
            final Button button = new Button(layout.getContext());
            buttons.add(button);
            button.setText(String.valueOf(test.getWord().charAt(i)));
            layout.addView(button);
            final int temp = i + 1;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    userAnswer.addAnswer(pos, temp);
                    for (Button b : buttons) {
                        b.setEnabled(false);
                    }
                    if (temp == test.getAnswer()) {
                        button.setBackgroundColor(Color.GREEN);
                    } else {
                        button.setBackgroundColor(Color.RED);
                        buttons.get(test.getAnswer() - 1).setBackgroundColor(Color.BLUE);
                    }

                }
            });
        }
        return rootView;
    }

}
