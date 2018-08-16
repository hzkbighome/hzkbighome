package UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;

import com.example.hzk.R;

import java.util.ArrayList;
import java.util.List;

public class shop extends AppCompatActivity {


    private List<filelist> mDatas;
    private myRecycleradatper recycleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        Button  btn1 = (Button) findViewById(R.id.person);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Intent是一种运行时绑定（run-time binding）机制，它能在程序运行过程中连接两个不同的组件。
                //在存放资源代码的文件夹下下，
                Intent i = new Intent(shop.this , Persondetail.class);
                //启动
                startActivity(i);
            }
        });
        //内容设置
        mDatas = new ArrayList<filelist>();
        filelist fl;
        String rank;
        ImageSpan pic;
        for ( int i=0; i < 10; i++) {
            if (i%2==0){
                rank="四星半";
            }else{
                rank="二星半";
            }
            pic=new ImageSpan(this, R.mipmap.ic_launcher_round);
            fl=new filelist("item"+i,rank,pic);
            mDatas.add(fl);
        }

        recycleAdapter=new myRecycleradatper(this,mDatas);
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recy_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this );
        recyclerView.setLayoutManager(layoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        recyclerView.setHasFixedSize(true);
        //创建并设置Adapter
        recyclerView.setAdapter(recycleAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }
}