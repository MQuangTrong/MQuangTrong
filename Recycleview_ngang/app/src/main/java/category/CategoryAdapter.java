package category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_ngang.R;

import java.util.List;

import book.BookAdapter;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

    private Context mContext;
    private List<Category> mcategoryList;

    public CategoryAdapter(Context mContext){
        this.mContext = mContext;
    }

    public void setData(List<Category> list){
        this.mcategoryList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = mcategoryList.get(position);
        if(category == null){
            return;
        }

        holder.tv_name_category.setText(category.getNameCategory());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
        holder.rcv_image.setLayoutManager(linearLayoutManager);

        BookAdapter bookAdapter = new BookAdapter();
        bookAdapter.setData(category.getBooks());
        holder.rcv_image.setAdapter(bookAdapter);

    }

    @Override
    public int getItemCount() {
        if(mcategoryList != null){
            return mcategoryList.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name_category;
        RecyclerView rcv_image;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name_category = itemView.findViewById(R.id.tv_name_category);
            rcv_image = itemView.findViewById(R.id.rcv_img);

        }
    }
}
