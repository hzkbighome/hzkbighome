package UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hzk.R;

import DAO.UserDaoImpl;

public class login extends AppCompatActivity {


    EditText userEt;
    EditText pwdEt;
    Button login;
    Button to_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        userEt = (EditText) findViewById(R.id.username);
        pwdEt = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        to_register = (Button) findViewById(R.id.to_register);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userEt.getText().toString();
                String password = pwdEt.getText().toString();
                UserDaoImpl userDao=new UserDaoImpl();
                if (userDao.login(user,password)) {
                    Intent intent = new Intent(UI.login.this,shop.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(UI.login.this, "登录密码不正确或账户不存在！",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }  );



        to_register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                 Intent intent = new Intent(UI.login.this, Register.class);
                 startActivity(intent);
            }
        });
    }

}