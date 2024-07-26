package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class FavoriteBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_book);

        RecyclerView recyclerView = findViewById(R.id.booksRecView);
        BooksRecViewAdapter adapter = new BooksRecViewAdapter(this, "favoriteBook");
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setBooks(Utils.getFavoriteBooks());

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(FavoriteBookActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}