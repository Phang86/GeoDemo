package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.annotation.BindPath;
import com.example.basic.BaseActivity;
import com.example.basic.router.ARouter;

@BindPath("login/LoginActivity")
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        showMsg("LoginActivity");
        ARouter.getInstance().jumpActivity("personal/PersonalActivity");

    }
}