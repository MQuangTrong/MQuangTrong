package book;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_ngang.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ImageViewHolder>{

    private List<Book> mBook;

    public void setData(List<Book> list){
        this.mBook = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Book book = mBook.get(position);
        if(book == null){
            return;
        }

        holder.img_anh.setImageResource(book.getResoureId());
        holder.tv_anh.setText(book.getTitle());

    }

    @Override
    public int getItemCount() {
        if(mBook != null){
            return mBook.size();
        }
        return 0;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{

        ImageView img_anh;
        TextView tv_anh;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            img_anh = itemView.findViewById(R.id.img_anh);
            tv_anh = itemView.findViewById(R.id.tv_anh);
        }
    }
}
