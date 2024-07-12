package com.example.mylibrary;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SeeAllBooksActivity extends AppCompatActivity {

    private RecyclerView booksRecView;
    private BooksRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_books);

        booksRecView = findViewById(R.id.booksRecView);
        adapter = new BooksRecViewAdapter(this);

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1,"1 BookOfStory","Haris",150,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlAkmuLe5t04pqAdlj0YB8eH2fuikKN6eumA&s","ShortDes","LongDes"));
        books.add(new Book(2,"2 BookOfStory","Haris",150,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlAkmuLe5t04pqAdlj0YB8eH2fuikKN6eumA&s","ShortDes","LongDes"));
        books.add(new Book(3,"3 BookOfStory","Haris",150,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlAkmuLe5t04pqAdlj0YB8eH2fuikKN6eumA&s","ShortDes","LongDes"));
        books.add(new Book(4,"4 BookOfStory","Haris",150,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlAkmuLe5t04pqAdlj0YB8eH2fuikKN6eumA&s","ShortDes","LongDes"));

        adapter.setBooks(books);
        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new LinearLayoutManager(this));




    }
}