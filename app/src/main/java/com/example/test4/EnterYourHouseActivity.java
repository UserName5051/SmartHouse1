package com.example.test4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterYourHouseActivity extends AppCompatActivity {

    private EditText email, password;
    private Button registerBtn, enterBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_your_house);

        email = findViewById(R.id.enter_email_et);
        password = findViewById(R.id.enter_password_et);

        String EmailPattern = "[a-zA-Z0-9._]+@[a-z]+\\.+[a-z]+";


        enterBtn = findViewById(R.id.eneter_btn);
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email = email.getText().toString();
                String Password = password.getText().toString();

                if (Email.isEmpty()){
                    email.setError("Введите Email");
                } else if (!Email.matches(EmailPattern)){
                    email.setError("Введите корректный email\nпо паттерну user@gmail.com");
                } else if (Password.isEmpty()){
                    password.setError("Введите пароль");
                } else{
                    Intent intent = new Intent(EnterYourHouseActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        registerBtn = findViewById(R.id.enter_register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnterYourHouseActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}