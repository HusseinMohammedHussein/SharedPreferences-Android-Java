package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsUser extends AppCompatActivity {

    TextView mtvDetails;
    Button mbtnLogout;
    SharedPreferences sharedPreferences;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_user);
        initialization();
        onClick();
    }

/*    Initialization Views Method, it's role:
 *            * Invoke all views of Details Activity and Initialization it.
 */
    private void initialization() {
        mtvDetails = findViewById(R.id.txtvDetails);
        mbtnLogout = findViewById(R.id.btnLogout);
        sharedPreferences = getSharedPreferences("userLogin", Context.MODE_PRIVATE);
        intent = new Intent(DetailsUser.this, MainActivity.class);

    }

    /*    A method to Do the following:
     *                   * set Text in to TextView,
     *                   * Action when user press on Logout Button
     */
    @SuppressLint("SetTextI18n")
    private void onClick() {
        mtvDetails.setText(" Hello : " + sharedPreferences.getString("username",null) + "\n User Password Is : " + sharedPreferences.getString("password",null));
        mbtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Toast.makeText(DetailsUser.this, "User Logout", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

}
