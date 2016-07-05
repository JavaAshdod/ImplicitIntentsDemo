package tomerbu.edu.intentsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
    }

    //onLoginClicked:
    public void login(View view) {
        //Explicit intent: the class is specified.
        Intent mainIntent = new Intent(this, MainActivity.class);

        //optionally pass extra data:
        mainIntent.putExtra("email", etEmail.getText().toString());

        startActivity(mainIntent);
    }
}
