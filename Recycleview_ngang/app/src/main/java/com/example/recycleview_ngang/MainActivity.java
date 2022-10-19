package com.example.recycleview_ngang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import book.Book;
import category.Category;
import category.CategoryAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvCategory;
    CategoryAdapter categoryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvCategory = (RecyclerView) findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
    }

    private List<Category> getListCategory() {
        List<Category> listCategory = new ArrayList<>();

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(R.drawable.anh1, "Book 1"));
        bookList.add(new Book(R.drawable.anh2, "Book 2"));
        bookList.add(new Book(R.drawable.anh3, "Book 3"));
        bookList.add(new Book(R.drawable.anh4, "Book 4"));
        bookList.add(new Book(R.drawable.anh5, "Book 5"));
        bookList.add(new Book(R.drawable.anh6, "Book 6"));


        bookList.add(new Book(R.drawable.anh1, "Book 1"));
        bookList.add(new Book(R.drawable.anh2, "Book 2"));
        bookList.add(new Book(R.drawable.anh3, "Book 3"));
        bookList.add(new Book(R.drawable.anh4, "Book 4"));
        bookList.add(new Book(R.drawable.anh5, "Book 5"));
        bookList.add(new Book(R.drawable.anh6, "Book 6"));

        listCategory.add(new Category("Category 1", bookList));
        listCategory.add(new Category("Category 2", bookList));
        listCategory.add(new Category("Category 3", bookList));
        listCategory.add(new Category("Category 4", bookList));
        listCategory.add(new Category("Category 5", bookList));


        return listCategory;
    }
}