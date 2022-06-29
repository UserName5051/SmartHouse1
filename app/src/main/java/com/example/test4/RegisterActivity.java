package com.example.test4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private EditText email, name, password;
    private Button registerBtn, enterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.register_email_et);
        name = findViewById(R.id.register_name_et);
        password = findViewById(R.id.register_password_et);

        String EmailPattern = "[a-zA-Z0-9._]+@[a-z]+\\.+[a-z]+";


        registerBtn = findViewById(R.id.register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email = email.getText().toString();
                String Name = name.getText().toString();
                String Password = password.getText().toString();

                if (Email.isEmpty()){
                    email.setError("Введите Email");
                } else if (!Email.matches(EmailPattern)){
                    email.setError("Введите корректный email\nпо паттерну user@gmail.com");
                } else if (Name.isEmpty()){
                    name.setError("Введите имя");
                }else if (Password.isEmpty()){
                    password.setError("Введите пароль");
                } else{
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        enterBtn = findViewById(R.id.enter_your_house_btn);
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, EnterYourHouseActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}