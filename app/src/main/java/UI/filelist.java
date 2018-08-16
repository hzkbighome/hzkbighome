package UI;

import android.text.style.ImageSpan;

public class filelist {
    private String Name;  //商品名称
    private String Rank;    //推荐等级
    private ImageSpan Span;  //图片
    public filelist(){

    }
    public filelist(String name,String rank,ImageSpan span){
        this.Name=name;
        this.Rank=rank;
        this.Span=span;
    }
    public String getName(){
        return Name;
    }
    public String getRank(){
        return Rank;
    }
    public ImageSpan getSpan(){
        return Span;
    }
}
