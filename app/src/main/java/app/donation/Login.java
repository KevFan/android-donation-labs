package app.donation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import models.User;

/**
 * Created by kevin on 20/09/2017.
 */

public class Login extends AppCompatActivity {
  private TextView loginEmailBox;
  private TextView loginPasswordBox;
  private DonationApp app;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    loginEmailBox = (TextView) findViewById(R.id.loginEmailBox);
    loginPasswordBox = (TextView) findViewById(R.id.loginPasswordBox);
    app = (DonationApp) getApplication();
  }

  public void loginButtonPressed(View view) {
    String email = loginEmailBox.getText().toString();
    String password = loginPasswordBox.getText().toString();
    if (email.isEmpty() || password.isEmpty()) {
      Toast.makeText(this, "Fill in all information to sign in !!", Toast.LENGTH_SHORT).show();
    } else if (app.successLogin(email, password) != null) {
      startActivity(new Intent(this, Donate.class));
      Toast.makeText(this, "Login Successful !!", Toast.LENGTH_SHORT).show();
    } else {
      Toast.makeText(this, "Email/Password incorrect !!", Toast.LENGTH_SHORT).show();
    }
  }
}
