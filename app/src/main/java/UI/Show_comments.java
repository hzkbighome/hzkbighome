package UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.style.ImageSpan;

import com.example.hzk.R;
import java.util.ArrayList;
import java.util.List;

public class Show_comments extends AppCompatActivity {

    private List<expand_or_fold_item> mDatas;
    private mRecycleradatper recycleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment
        );

        //内容设置
        mDatas = new ArrayList<expand_or_fold_item>();
        expand_or_fold_item item1;

        ImageSpan pic1;
        String name;
        String rank;
        String comment;
        ImageSpan pic2;

        for ( int i=0; i < 10; i++) {
            pic1=new ImageSpan(this, R.drawable.user_img);
            name="用户名";
            rank="星级";
            comment="这是评价内容";
            pic2=new ImageSpan(this, R.drawable.bg);
            item1=new expand_or_fold_item(pic1,name,rank,comment,pic2);
            mDatas.add(item1);
        }

        recycleAdapter=new mRecycleradatper(this,mDatas);
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.com_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recycleAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}
