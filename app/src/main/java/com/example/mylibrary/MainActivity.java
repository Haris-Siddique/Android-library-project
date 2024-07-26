package com.example.mylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private Button btnSeeAllBooks, btnCurrentReadingBook, btnAlreadyReadBook, btnYourWishlist, btnSeeYourFavourite, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnSeeAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SeeAllBooksActivity.class);
                startActivity(intent);

            }
        });


        btnAlreadyReadBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlreadyReadBookActivity.class);
                startActivity(intent);
            }
        });



        Utils.getInstance();

    }

    private void initViews(){
        btnSeeAllBooks = findViewById(R.id.btnSeeAllBooks);
        btnCurrentReadingBook = findViewById(R.id.btnCurrentReadingBook);
        btnAlreadyReadBook = findViewById(R.id.btnAlreadyReadBook);
        btnYourWishlist = findViewById(R.id.btnYourWishlist);
        btnSeeYourFavourite = findViewById(R.id.btnSeeYourFavourite);
        btnAbout = findViewById(R.id.btnAbout);
    }

}