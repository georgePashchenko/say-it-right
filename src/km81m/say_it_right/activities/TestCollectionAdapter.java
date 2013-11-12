package km81m.say_it_right.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * User: alexeydushenin
 * Date: 11/12/13
 * Time: 5:12 PM
 */
public class TestCollectionAdapter extends FragmentStatePagerAdapter {

    public TestCollectionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new TestObjectFragment();
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
