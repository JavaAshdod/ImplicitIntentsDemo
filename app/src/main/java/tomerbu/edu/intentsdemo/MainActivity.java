package tomerbu.edu.intentsdemo;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etQuery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etQuery = (EditText) findViewById(R.id.etQuery);
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");

        Toast.makeText(this, "Hello, " + email, Toast.LENGTH_SHORT).show();
    }

    public void dial(View view) {
        Uri data = Uri.parse("tel://0507123012");
        Intent dialIntent = new Intent(Intent.ACTION_DIAL, data);
        startActivity(dialIntent);
    }

    public void webPage(View view) {
        Uri data = Uri.parse("https://developer.android.com/index.html#q=intent");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, data);
        startActivity(webIntent);
    }

    public void showMap(View view) {
       // Uri data = Uri.parse("geo:31.8141984,34.655782?z=17");
        Uri data = Uri.parse("geo:0,0?q=רחוב + האורגים + 35 + אשדוד&z=17");
        Intent intent = new Intent(Intent.ACTION_VIEW, data);
        startActivity(intent);
    }

    public void youtubeSearch(View view) {
        Uri data = Uri.parse("https://www.youtube.com/results?search_query=" + getQuery());
        Intent intent = new Intent(Intent.ACTION_VIEW, data);
        startActivity(intent);
    }

    public void googleSearch(View view) {
        Uri dataUri = Uri.parse("https://www.google.co.il/search?q=" + getQuery());
        startActivity(
                new Intent(Intent.ACTION_VIEW, dataUri)
        );
    }

    public void androidDevSearch(View view) {
        Uri dataUri = Uri.parse("https://developer.android.com/index.html#q=" + getQuery());
        startActivity(new Intent(Intent.ACTION_VIEW, dataUri));
    }

    public String getQuery() {
        return etQuery.getText().toString();
    }

    public void setAlarm(View v){
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_HOUR, 1);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, 20);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Call Mom!");
        startActivity(intent);
    }
}















