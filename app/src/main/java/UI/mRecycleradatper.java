package UI;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import com.example.hzk.R;

public class mRecycleradatper extends RecyclerView.Adapter<mRecycleradatper.MyViewHolder> {
    private List<expand_or_fold_item> mDatas;
    private Context mContext;
    private LayoutInflater inflater;


    public mRecycleradatper(Context context, List<expand_or_fold_item> datas){
        this. mContext=context;
        this. mDatas=datas;
        inflater=LayoutInflater. from(mContext);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.show_comments,parent, false);
        MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        expand_or_fold_item item=mDatas.get(position);
        if(position%2==0){
            //holder.tv.setBackgroundColor(Color.BLUE);
            holder.v.setBackgroundColor(Color.GRAY);
        }
        holder.pic1.setTag(item.getSpan1());
        holder.name.setText(item.getName());
        holder.rank.setText(item.getRank());
        holder.comment.setText(item.getComment());
        holder.pic2.setTag(item.getSpan2());

    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView pic1;
        TextView name;
        TextView rank;
        TextView comment;
        ImageView pic2;
        View v;
        public MyViewHolder(View view) {
            super(view);
            pic1=(ImageView)view.findViewById(R.id.imageView1);
            name=(TextView) view.findViewById(R.id.username);
            rank=(TextView)view.findViewById(R.id.star);
            comment=(TextView)view.findViewById(R.id.comment);
            pic2=(ImageView)view.findViewById(R.id.imageView2);
            v=view;
        }

    }
}