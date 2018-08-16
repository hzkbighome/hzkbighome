package UI;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.hzk.R;

import java.util.List;


public class myRecycleradatper extends RecyclerView.Adapter<myRecycleradatper.MyViewHolder> {
    private List<filelist> mDatas;
    private Context mContext;
    private LayoutInflater inflater;


    public myRecycleradatper(Context context, List<filelist> datas){
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

        View view = inflater.inflate(R.layout.shopintro,parent, false);
        MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        filelist da=mDatas.get(position);
        if(position%2==0){
            //holder.tv.setBackgroundColor(Color.BLUE);
            holder.v.setBackgroundColor(Color.GRAY);
        }
        holder.name.setText(da.getName());
        holder.rank.setText(da.getRank());
        holder.pic.setTag(da.getSpan());

    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView rank;
        ImageView pic;
        View v;
        public MyViewHolder(View view) {
            super(view);
            name=(TextView) view.findViewById(R.id.txt_name);
            rank=(TextView)view.findViewById(R.id.txt_rank);
            pic=(ImageView)view.findViewById(R.id.imageView);
            v=view;
        }

    }
}
