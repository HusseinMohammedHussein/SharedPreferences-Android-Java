/* Hussein Mohammed Hussein | 12/4/2020 */
package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputEditText metUsername, metPassword;
    TextInputLayout mtlUser, mtlPassword;
    Button mbtnLogin;
    SharedPreferences sharedPreferences;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        onClick();
    }

/*    Initialization Views Method, it's role:
 *            * Invoke all views of Details Activity and Initialization it.
 */
    private void initialization() {
        metUsername = findViewById(R.id.etUsername);
        metPassword = findViewById(R.id.etPassword);
        mbtnLogin = findViewById(R.id.btnLogin);
        mtlUser = findViewById(R.id.tlUsername);
        mtlPassword = findViewById(R.id.tlPass);
        sharedPreferences = getSharedPreferences("userLogin", Context.MODE_PRIVATE);
        intent = new Intent(MainActivity.this, DetailsUser.class);
    }


/*    A onClick method to Do the following:
 *                   * Validation on TextInputEditText.
 *                   * Show Error with TextInputLayout.
 *                   * each all is execution when user press Login Button.
 */
    private void onClick() {
        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameDB = metUsername.getEditableText().toString().trim();
                String passwordDB = metPassword.getEditableText().toString().trim();
                if (usernameDB.equals("Hussein")) {
                    mtlUser.setError(null);
                    mtlUser.setErrorEnabled(false);
                    mtlUser.requestFocus();
                    if (passwordDB.equals("456")) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", usernameDB);
                        editor.putString("password", passwordDB);
                        editor.apply();
                        mtlPassword.setError(null);
                        mtlPassword.setErrorEnabled(false);
                        mtlPassword.requestFocus();
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "Logined", Toast.LENGTH_SHORT).show();
                    } else {
                        mtlPassword.setError("Password Error!");
                        mtlPassword.setErrorEnabled(true);
                        mtlPassword.requestFocus();
                    }
                } else {
                    mtlUser.setError("User Not Exits!");
                    mtlUser.setErrorEnabled(true);
                    mtlUser.requestFocus();
                }
            }

        });
    }
}
