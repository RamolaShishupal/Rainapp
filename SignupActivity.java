package com.example.rainometer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignupActivity extends MainActivity {


    EditText etemail ,etpass;
    TextView tvlogin;
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etemail=(EditText)findViewById(R.id.etemail);
        etpass=(EditText)findViewById(R.id.etpass);
        tvlogin=(TextView)findViewById(R.id.tvlogin);
        btnlogin=(Button) findViewById(R.id.btnlogin);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(i);

            }
        });
    }
}
