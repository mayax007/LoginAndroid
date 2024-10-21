package com.example.videomvp.login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.videomvp.R;
import com.example.videomvp.beans.User;
import com.example.videomvp.login.ContractLogin;
import com.example.videomvp.login.presenter.LoginPresenter;

public class LoginView extends AppCompatActivity implements ContractLogin.View{

    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;

    private LoginPresenter presenter =
            new LoginPresenter(this);

    private static LoginView mainActivity = null;
    public static LoginView getInstance(){
        return mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;
        initComponents();
    }
    private void initComponents(){
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User("", edtEmail.getText().toString(), edtPassword.getText().toString());
                presenter.login(user);
            }
        });
    }

    @Override
    public void successLogin(String message) {
        Toast.makeText(mainActivity, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failureLogin(String err) {

    }
}
