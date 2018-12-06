package com.example.gtachantouria.mimeliapp.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gtachantouria.mimeliapp.List.ProductListActivity;
import com.example.gtachantouria.mimeliapp.R;

public class LoginActivity extends AppCompatActivity implements LoginPresenter.View {
    private Button mButton;
    private LoginPresenter mPresenter;
    private TextView mEmail;
    private TextView mPassword;
    private TextView mErrors;

    private View.OnClickListener loginListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), ProductListActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Presenter
        mPresenter = new LoginPresenter(this);

        //Views (User, Email)
        mEmail = findViewById(R.id.et_email);
        mPassword = findViewById(R.id.et_password);
        mErrors = findViewById(R.id.tv_errors);

        //Set Login data.
        mPresenter.updateEmail(mEmail.getText().toString());
        mPresenter.updatePassword(mPassword.getText().toString());

        //Button sets
        mButton = findViewById(R.id.btn_login);
        mButton.setOnClickListener(loginListener);
    }

    @Override
    public void validarLogin() {
        if(!mPresenter.checkLogin(mEmail.getText().toString(), mPassword.getText().toString())){
            mErrors.setText("User or pass incrorrect!!");
        }
    }
}
