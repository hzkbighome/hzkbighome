package UI;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.hzk.R;
import background.*;
public class Persondetail extends AppCompatActivity {
    TextView name;
    TextView sex;
    TextView email;
    TextView province;
    TextView city;
    TextView intro;
    usersystem us;
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person);
        us=new usersystem("1010101010");
        name=findViewById(R.id.namestr);
        name.setText(us.getNickname());
        sex=findViewById(R.id.sexstr);
        sex.setText(us.getSex());
        email=findViewById(R.id.emailstr);
        email.setText(us.getEmail());
        province=findViewById(R.id.provincestr);
        province.setText(us.getProvince());
        city=findViewById(R.id.citystr);
        city.setText(us.getCity());
        intro=findViewById(R.id.introstr);
        intro.setText(us.getIntro());
    }
}