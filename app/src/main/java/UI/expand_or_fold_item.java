package UI;
import android.text.style.ImageSpan;

public class expand_or_fold_item {
    private ImageSpan Span1;
    private String Name;
    private String Rank;
    private String Comment;
    private ImageSpan Span2;

    public expand_or_fold_item() {
        }

        public expand_or_fold_item(ImageSpan span1,String name, String rank, String comment, ImageSpan span2) {

            this.Span1 = span1;
            this.Name = name;
            this.Rank = rank;
            this.Comment=comment;
            this.Span2 = span2;
        }

    public ImageSpan getSpan1() {
        return Span1;
    }

    public String getName() {
        return Name;
    }

    public String getRank() {
        return Rank;
    }

    public String getComment() {
        return Comment;
    }

    public ImageSpan getSpan2() {
        return Span2;
    }

    }
