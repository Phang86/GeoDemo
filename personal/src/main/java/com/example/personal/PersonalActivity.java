package com.example.personal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.annotation.BindPath;
import com.example.basic.BaseActivity;

@BindPath("personal/PersonalActivity")
public class PersonalActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        showMsg("PersonalActivity");
    }
}