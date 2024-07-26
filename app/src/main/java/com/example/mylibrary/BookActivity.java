package com.example.mylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private ImageView imgBook;
    private Button btnAddToFavorite, btnAddToAlreadyReadList, btnAddToCurrentlyReading, btnAddToWantToReadList;
    private TextView tvBookName, tvAuthorName, tvPages, tvDescription, tvLongDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initView();

//        Book book = new Book(1, "1 BookOfStory", "Haris", 150, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlAkmuLe5t04pqAdlj0YB8eH2fuikKN6eumA&s", "ShortDes", "LongDesdjhlfakhfjlsdgfljasdgfkjadgsfkudgsufhgsdalfgljsdgfjsdgakfjgsadljfgljdsgfjlasdgfljhgsdafljgdslfgasdjgflsajdgfljsdagfjlgsdljfglsadjgfljsadgfljasgdkfgsadjfglsadjgfljsadgflgsdafjlgsdljfgalhdfglajsgdfljasgdlfsaldjgfkasdgf    LongDesdjhlfakhfjlsdgfljasdgfkjadgsfkudgsufhgsdalfgljsdgfjsdgakfjgsadljfgljdsgfjlasdgfljhgsdafljgdslfgasdjgflsajdgfljsdagfjlgsdljfglsadjgfljsadgfljasgdkfgsadjfglsadjgfljsadgflgsdafjlgsdljfgalhdfglajsgdfljasgdlfsaldjgfkasdgf   LongDesdjhlfakhfjlsdgfljasdgfkjadgsfkudgsufhgsdalfgljsdgfjsdgakfjgsadljfgljdsgfjlasdgfljhgsdafljgdslfgasdjgflsajdgfljsdagfjlgsdljfglsadjgfljsadgfljasgdkfgsadjfglsadjgfljsadgflgsdafjlgsdljfgalhdfglajsgdfljasgdlfsaldjgfkasdgf   LongDesdjhlfakhfjlsdgfljasdgfkjadgsfkudgsufhgsdalfgljsdgfjsdgakfjgsadljfgljdsgfjlasdgfljhgsdafljgdslfgasdjgflsajdgfljsdagfjlgsdljfglsadjgfljsadgfljasgdkfgsadjfglsadjgfljsadgflgsdafjlgsdljfgalhdfglajsgdfljasgdlfsaldjgfkasdgf      LongDesdjhlfakhfjlsdgfljasdgfkjadgsfkudgsufhgsdalfgljsdgfjsdgakfjgsadljfgljdsgfjlasdgfljhgsdafljgdslfgasdjgflsajdgfljsdagfjlgsdljfglsadjgfljsadgfljasgdkfgsadjfglsadjgfljsadgflgsdafjlgsdljfgalhdfglajsgdfljasgdlfsaldjgfkasdgf       LongDesdjhlfakhfjlsdgfljasdgfkjadgsfkudgsufhgsdalfgljsdgfjsdgakfjgsadljfgljdsgfjlasdgfljhgsdafljgdslfgasdjgflsajdgfljsdagfjlgsdljfglsadjgfljsadgfljasgdkfgsadjfglsadjgfljsadgflgsdafjlgsdljfgalhdfglajsgdfljasgdlfsaldjgfkasdgf      LongDesdjhlfakhfjlsdgfljasdgfkjadgsfkudgsufhgsdalfgljsdgfjsdgakfjgsadljfgljdsgfjlasdgfljhgsdafljgdslfgasdjgflsajdgfljsdagfjlgsdljfglsadjgfljsadgfljasgdkfgsadjfglsadjgfljsadgflgsdafjlgsdljfgalhdfglajsgdfljasgdlfsaldjgfkasdgf");

        Intent intent = getIntent();

        if (intent != null) {
            int bookId = intent.getIntExtra("bookId", -1);
            if (bookId != -1) {

                Book incomingBook = Utils.getInstance().getBookById(bookId);

                if (incomingBook != null) {
                    setData(incomingBook);

                    handleAlreadyReadBook(incomingBook);
                    handleWantToReadBooks(incomingBook);
                    handleCurrentlyReadingBook(incomingBook);
                    handleFavoriteBooks(incomingBook);

                }

            }
        }


    }

    private void handleFavoriteBooks(Book book) {
        ArrayList<Book> favoriteBooks = Utils.getFavoriteBooks();


        boolean existInFavoriteBook = false;

        for (Book b : favoriteBooks) {
            if (b.getId() == book.getId()) {
                existInFavoriteBook = true;
            }
        }

        if (existInFavoriteBook) {
            btnAddToFavorite.setEnabled(false);
        } else {
            btnAddToFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance().addToFavorite(book)) {
                        Toast.makeText(BookActivity.this, "Book Addes", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, FavoriteBookActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Somthing wrong add book again", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }

    private void handleCurrentlyReadingBook(Book book) {
        ArrayList<Book> currentlyReadBooks = Utils.getCurrentlyReadingBooks();

        boolean existinCurrentlyReadBook = false;

        for (Book b : currentlyReadBooks) {
            if (b.getId() == book.getId()) {
                existinCurrentlyReadBook = true;
            }
        }

        if (existinCurrentlyReadBook) {
            btnAddToCurrentlyReading.setEnabled(false);
        } else {
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance().addToCurrentlyRead(book)) {
                        Toast.makeText(BookActivity.this, "Book Addes", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, CurrentBookReadingActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Somthing wrong add book again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleAlreadyReadBook(Book book) {
        ArrayList<Book> alreadyReadBook = Utils.getInstance().getAlreadyReadBooks();


        boolean existInAlreadyReadBook = false;

        for (Book b : alreadyReadBook) {
            if (b.getId() == book.getId()) {
                existInAlreadyReadBook = true;
            }
        }

        if (existInAlreadyReadBook) {
            btnAddToAlreadyReadList.setEnabled(false);
        } else {
            btnAddToAlreadyReadList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance().addToAlreadyRead(book)) {
                        Toast.makeText(BookActivity.this, "Book Addes", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, AlreadyReadBookActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Somthing wrong add book again", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

    }

    private void handleWantToReadBooks(Book book) {
        ArrayList<Book> wantToReadBooks = Utils.getWantToReadBooks();

        boolean existInWantToReadBook = false;

        for (Book b : wantToReadBooks) {
            if (b.getId() == book.getId()) {
                existInWantToReadBook = true;
            }
        }

        if (existInWantToReadBook) {
            btnAddToWantToReadList.setEnabled(false);
        } else {
            btnAddToWantToReadList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance().addToWantToRead(book)) {
                        Toast.makeText(BookActivity.this, "Book Addes", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, WantToReadActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Somthing wrong add book again", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

    }


    private void setData(Book book) {
        Glide.with(this).asBitmap().load(book.getImageUrl()).into(imgBook);
        tvBookName.setText(book.getName());
        tvAuthorName.setText(book.getAuthor());
        tvPages.setText(String.valueOf(book.getPages()));
        tvDescription.setText(book.getshortDesc());
        tvLongDescription.setText(book.getLongDesc());
    }

    private void initView() {
        imgBook = findViewById(R.id.imgBook);
        btnAddToFavorite = findViewById(R.id.btnAddToFavorite);
        btnAddToAlreadyReadList = findViewById(R.id.btnAddToAlreadyReadList);
        btnAddToCurrentlyReading = findViewById(R.id.btnAddToCurrentlyReading);
        btnAddToWantToReadList = findViewById(R.id.btnAddToWantToReadList);
        tvBookName = findViewById(R.id.tvBookName);
        tvAuthorName = findViewById(R.id.tvAuthorName);
        tvPages = findViewById(R.id.tvPages);
        tvDescription = findViewById(R.id.tvDescription);
        tvLongDescription = findViewById(R.id.tvLongDescription);
    }
}