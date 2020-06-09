package com.example.rainometer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends MainActivity

{
    EditText etemail ,etpass;
    TextView tvlogin;
    Button btnlogin ,btnsignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etemail=(EditText)findViewById(R.id.etemail);
        etpass=(EditText)findViewById(R.id.etpass);
        tvlogin=(TextView)findViewById(R.id.tvlogin);
        btnlogin=(Button) findViewById(R.id.btnlogin);
        btnsignup=(Button)findViewById(R.id.btnsignup);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(i);



            }
        });



    }
}
