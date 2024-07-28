package com.example.mylibrary;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private Button btnSeeAllBooks, btnCurrentReadingBook, btnAlreadyReadBook, btnYourWishlist, btnSeeYourFavourite, btnAbout;
    private String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();


        btnYourWishlist.setEnabled(false);


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

        btnCurrentReadingBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CurrentBookReadingActivity.class);
                startActivity(intent);
            }
        });

        btnSeeYourFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FavoriteBookActivity.class);
                startActivity(intent);
            }
        });


        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("This Mobile Application is designed by Haris Siddique");
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //TODO: show the webpage.
                        Intent intent = new Intent(MainActivity.this, WebsiteActivity.class);
                        URL="https://www.google.com";
                        intent.putExtra("url",URL);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.create().show();
            }
        });



        Utils.getInstance(this);

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