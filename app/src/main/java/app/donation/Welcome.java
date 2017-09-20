package app.donation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by kevin on 20/09/2017.
 */

public class Welcome extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_welcome);
  }

  public void welcomeLoginButtonPressed(View view) {
    startActivity(new Intent(this, Login.class));
  }

  public void signupButtonPressed(View view) {
    startActivity(new Intent(this, Signup.class));
  }
}
