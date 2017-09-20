package app.donation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by kevin on 20/09/2017.
 */

public class Login extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
  }

  public void loginButtonPressed(View view) {
    startActivity(new Intent(this, Donate.class));
  }
}
