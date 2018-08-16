package UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.hzk.R;

import DAO.UserDaoImpl;

public class Register extends AppCompatActivity {

    private EditText userEt;
    private EditText pwdEt;
    Button register;
    Button to_login;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        userEt = (EditText)findViewById(R.id.re_username);
        pwdEt = (EditText)findViewById(R.id.re_password);
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String user = userEt.getText().toString();
                String password = pwdEt.getText().toString();

                UserDaoImpl userDao=new UserDaoImpl();
                userDao.Register(user,password);

                Toast.makeText(Register.this, "注册成功！",
                        Toast.LENGTH_SHORT).show();

            }
        });

        to_login = (Button) findViewById(R.id.to_login);
        to_login.setOnClickListener(new View.OnClickListener()

            {
                public void onClick (View v){
                Intent intent = new Intent(Register.this, shop.class);
                startActivity(intent);
                }
            });
        }

}
