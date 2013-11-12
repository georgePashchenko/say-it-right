package km81m.say_it_right.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import km81m.say_it_right.R;
import km81m.say_it_right.logic.TestBlock;
import km81m.say_it_right.logic.TestResults;
import km81m.say_it_right.logic.UserAnswer;

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
        int pos = args.getInt("pos");

        LinearLayout layout = (LinearLayout) rootView.findViewById(R.id.simple_test_layout);
        for (int i = 0; i < pos; i++) {
            Button button = new Button(layout.getContext());
            button.setText(Integer.toString(pos));
            layout.addView(button);
        }
        return rootView;
    }

}
