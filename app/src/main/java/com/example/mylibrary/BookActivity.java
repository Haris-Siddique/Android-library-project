package com.example.mylibrary;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {

    private ImageView imgBook;
    private Button btnAddToFavorite, btnAddToAlreadyReadList, btnAddToCurrentlyReading, btnAddToWantToReadList;
    private TextView tvBookName, tvAuthorName, tvPages, tvDescription, tvLongDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initView();

        Book book = new Book(1, "1 BookOfStory", "Haris", 150, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlAkmuLe5t04pqAdlj0YB8eH2fuikKN6eumA&s", "ShortDes", "LongDesdjhlfakhfjlsdgfljasdgfkjadgsfkudgsufhgsdalfgljsdgfjsdgakfjgsadljfgljdsgfjlasdgfljhgsdafljgdslfgasdjgflsajdgfljsdagfjlgsdljfglsadjgfljsadgfljasgdkfgsadjfglsadjgfljsadgflgsdafjlgsdljfgalhdfglajsgdfljasgdlfsaldjgfkasdgf    LongDesdjhlfakhfjlsdgfljasdgfkjadgsfkudgsufhgsdalfgljsdgfjsdgakfjgsadljfgljdsgfjlasdgfljhgsdafljgdslfgasdjgflsajdgfljsdagfjlgsdljfglsadjgfljsadgfljasgdkfgsadjfglsadjgfljsadgflgsdafjlgsdljfgalhdfglajsgdfljasgdlfsaldjgfkasdgf   LongDesdjhlfakhfjlsdgfljasdgfkjadgsfkudgsufhgsdalfgljsdgfjsdgakfjgsadljfgljdsgfjlasdgfljhgsdafljgdslfgasdjgflsajdgfljsdagfjlgsdljfglsadjgfljsadgfljasgdkfgsadjfglsadjgfljsadgflgsdafjlgsdljfgalhdfglajsgdfljasgdlfsaldjgfkasdgf   LongDesdjhlfakhfjlsdgfljasdgfkjadgsfkudgsufhgsdalfgljsdgfjsdgakfjgsadljfgljdsgfjlasdgfljhgsdafljgdslfgasdjgflsajdgfljsdagfjlgsdljfglsadjgfljsadgfljasgdkfgsadjfglsadjgfljsadgflgsdafjlgsdljfgalhdfglajsgdfljasgdlfsaldjgfkasdgf      LongDesdjhlfakhfjlsdgfljasdgfkjadgsfkudgsufhgsdalfgljsdgfjsdgakfjgsadljfgljdsgfjlasdgfljhgsdafljgdslfgasdjgflsajdgfljsdagfjlgsdljfglsadjgfljsadgfljasgdkfgsadjfglsadjgfljsadgflgsdafjlgsdljfgalhdfglajsgdfljasgdlfsaldjgfkasdgf       LongDesdjhlfakhfjlsdgfljasdgfkjadgsfkudgsufhgsdalfgljsdgfjsdgakfjgsadljfgljdsgfjlasdgfljhgsdafljgdslfgasdjgflsajdgfljsdagfjlgsdljfglsadjgfljsadgfljasgdkfgsadjfglsadjgfljsadgflgsdafjlgsdljfgalhdfglajsgdfljasgdlfsaldjgfkasdgf      LongDesdjhlfakhfjlsdgfljasdgfkjadgsfkudgsufhgsdalfgljsdgfjsdgakfjgsadljfgljdsgfjlasdgfljhgsdafljgdslfgasdjgflsajdgfljsdagfjlgsdljfglsadjgfljsadgfljasgdkfgsadjfglsadjgfljsadgflgsdafjlgsdljfgalhdfglajsgdfljasgdlfsaldjgfkasdgf");
        setData(book);

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