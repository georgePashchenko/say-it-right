package km81m.say_it_right.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import km81m.say_it_right.R;

/**
 * User: alexeydushenin
 * Date: 11/2/13
 * Time: 9:27 PM
 */
public class LevelActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level);

        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.level_np_id);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);
        numberPicker.setValue(1);

        numberPicker.setWrapSelectorWheel(true);
    }

    public void startTest(View view) {
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }

}
