package km81m.say_it_right.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import km81m.say_it_right.logic.TestBlock;
import km81m.say_it_right.logic.UserAnswer;

/**
 * User: alexeydushenin
 * Date: 11/12/13
 * Time: 5:12 PM
 */
public class TestCollectionAdapter extends FragmentStatePagerAdapter {

    private UserAnswer userAnswer;
    private TestBlock testBlock;

    public TestCollectionAdapter(FragmentManager fm, UserAnswer userAnswer, TestBlock testBlock) {
        super(fm);
        this.userAnswer = userAnswer;
        this.testBlock = testBlock;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new TestObjectFragment(userAnswer, testBlock);
        Bundle args = new Bundle();
        args.putInt("pos", i);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 10;
    }
}
