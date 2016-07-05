package tomerbu.edu.intentsdemo;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {

    TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        Intent openingIntent = getIntent();
        int hour = openingIntent.getIntExtra(AlarmClock.EXTRA_HOUR, 0);
        int min = openingIntent.getIntExtra(AlarmClock.EXTRA_MINUTES, 0);

        timePicker.setCurrentHour(hour);
        timePicker.setCurrentMinute(min);
    }

    public void setAlarms(View view) {

        int hour = 0;
        int minutes =0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            hour = timePicker.getHour();
            minutes= timePicker.getMinute();
        }
        else {
            hour = timePicker.getCurrentHour();
            minutes = timePicker.getCurrentMinute();
        }


        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);

        intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Call Home.");

        startActivity(intent);


        Calendar c = Calendar.getInstance();
        c.set(2017, 11, 3, 21, 32);
    }
}
