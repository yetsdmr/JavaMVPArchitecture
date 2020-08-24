package com.yetsdmr.javamvparchitecture.view.Main;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.yetsdmr.javamvparchitecture.R;
import com.yetsdmr.javamvparchitecture.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView.View{

    MainView.Presenter presenter;

    Button login;
    EditText usernameText,passwordText;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        login = findViewById(R.id.login);
        usernameText = findViewById(R.id.username);
        passwordText = findViewById(R.id.pasword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();

               user = new User(username,password);

                if (TextUtils.isEmpty(user.getUsername()) || TextUtils.isEmpty(user.getPassword())){
                    onError("Field(s) Required");
                }else {
                    presenter.doLogin(user);
                }
            }
        });

    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}