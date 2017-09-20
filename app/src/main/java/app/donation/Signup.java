package app.donation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import models.User;

/**
 * Created by kevin on 20/09/2017.
 */

public class Signup extends AppCompatActivity {
  private TextView firstNameBox;
  private TextView lastNameBox;
  private TextView emailBox;
  private TextView passwordBox;
  private DonationApp app;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_signup);

    app = (DonationApp) getApplication();
    firstNameBox = (TextView) findViewById(R.id.firstNameBox);
    lastNameBox = (TextView) findViewById(R.id.lastNameBox);
    emailBox = (TextView) findViewById(R.id.emailBox);
    passwordBox = (TextView) findViewById(R.id.passwordBox);
  }

  public void registerButtonPressed(View view) {
    String firstName = firstNameBox.getText().toString();
    String lastName = lastNameBox.getText().toString();
    String email = emailBox.getText().toString();
    String password = passwordBox.getText().toString();

    if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
      Toast.makeText(this, "Fill in all information to complete signup", Toast.LENGTH_SHORT).show();
    } else {
      app.newUser(new User(firstName, lastName, email, password));
      startActivity(new Intent(this, Donate.class));
      Toast.makeText(this, "Completed signup !!", Toast.LENGTH_SHORT).show();
    }
  }
}
