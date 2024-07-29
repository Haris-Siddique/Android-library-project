package com.example.mylibrary;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {
    private static final String All_BOOKS_KEY = "all books";
    private static final String AlREADY_READ_BOOKS_KEY = "already read books";
    private static final String WANT_TO_READ_BOOKS_KEY = "want to read books";
    private static final String CURRENTLY_READ_BOOKS_KEY = "currently read books";
    private static final String FAVORITE_BOOKS_KEY= "favorite books";
    private static Utils instance;

//    private static ArrayList<Book> allBooks;
//    private static ArrayList<Book> alreadyReadBooks;
//    private static ArrayList<Book> wantToReadBooks;
//    private static ArrayList<Book> currentlyReadingBooks;
//    private static ArrayList<Book> favoriteBooks;

    private SharedPreferences sharedPreferences;

    private Utils(Context context) {
        sharedPreferences = context.getSharedPreferences("alternative_db", Context.MODE_PRIVATE);

        if (null == getAllBooks()) {

            initData();
        }

        Gson gson = new Gson();
        SharedPreferences.Editor editer = sharedPreferences.edit();

        if (null == getAlreadyReadBooks()) {

            editer.putString(AlREADY_READ_BOOKS_KEY,gson.toJson(new ArrayList<>()));
            editer.commit();
        }
        if (null == getWantToReadBooks()) {

            editer.putString(WANT_TO_READ_BOOKS_KEY,gson.toJson(new ArrayList<>()));
            editer.commit();
        }

        if (null == getCurrentlyReadingBooks()) {

            editer.putString(CURRENTLY_READ_BOOKS_KEY,gson.toJson(new ArrayList<>()));
            editer.commit();
        }
        if (null == getFavoriteBooks()) {

            editer.putString(FAVORITE_BOOKS_KEY,gson.toJson(new ArrayList<>()));
            editer.commit();
        }
    }

    public static Utils getInstance(Context context) {

        if (null != instance) {
            return instance;
        } else {
            instance = new Utils(context);
            return instance;
        }
    }

    private void initData() {

        ArrayList<Book> books = new ArrayList<>();

        //TODO: add initial data.
        books.add(new Book(1, "1 BookOfStory", "Haris", 150, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlAkmuLe5t04pqAdlj0YB8eH2fuikKN6eumA&s", "1 ShortDes", "1 LongDes"));
        books.add(new Book(2, "2 BookOfStory", "Haris", 150, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlAkmuLe5t04pqAdlj0YB8eH2fuikKN6eumA&s", "2 ShortDes", "2 LongDes"));
        books.add(new Book(3, "3 BookOfStory", "Haris", 150, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlAkmuLe5t04pqAdlj0YB8eH2fuikKN6eumA&s", "3 ShortDes", "3 LongDes"));
        books.add(new Book(4, "4 BookOfStory", "Haris", 150, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlAkmuLe5t04pqAdlj0YB8eH2fuikKN6eumA&s", "4 ShortDes", "4 LongDes"));

        SharedPreferences.Editor editer = sharedPreferences.edit();
        Gson gson = new Gson();
        editer.putString(All_BOOKS_KEY, gson.toJson(books));
        editer.commit();

    }

    public ArrayList<Book> getAllBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>() {}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(All_BOOKS_KEY, null), type);
        return books;
    }

    public  ArrayList<Book> getAlreadyReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>() {}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(AlREADY_READ_BOOKS_KEY, null), type);
        return books;
    }

    public  ArrayList<Book> getWantToReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>() {}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(WANT_TO_READ_BOOKS_KEY, null), type);
        return books;
    }

    public  ArrayList<Book> getCurrentlyReadingBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>() {}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READ_BOOKS_KEY, null), type);
        return books;
    }

    public  ArrayList<Book> getFavoriteBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>() {}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(FAVORITE_BOOKS_KEY, null), type);
        return books;
    }

    public Book getBookById(int bookId) {
        ArrayList<Book> book = getAllBooks();

        if(book != null) {
            for (Book b : book) {
                if (b.getId() == bookId) {
                    return b;
                }
            }
        }
        return null;
    }

    public boolean addToAlreadyRead(Book book) {
        ArrayList<Book> books = getAlreadyReadBooks();

        if(books != null){
            if(books.add(book)){

                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(AlREADY_READ_BOOKS_KEY);
                editor.putString(AlREADY_READ_BOOKS_KEY, gson.toJson(books));
                editor.commit();
                return true;
            }

        }
        return false;
    }

    public boolean addToWantToRead(Book book) {
        ArrayList<Book> books = getWantToReadBooks();

        if(books != null){
            if(books.add(book)){

                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(WANT_TO_READ_BOOKS_KEY);
                editor.putString(WANT_TO_READ_BOOKS_KEY, gson.toJson(books));
                editor.commit();
                return true;
            }

        }
        return false;
    }

    public boolean addToFavorite(Book book) {
        ArrayList<Book> books = getFavoriteBooks();

        if(books != null){
            if(books.add(book)){

                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(FAVORITE_BOOKS_KEY);
                editor.putString(FAVORITE_BOOKS_KEY, gson.toJson(books));
                editor.commit();
                return true;
            }

        }
        return false;
    }

    public boolean addToCurrentlyRead(Book book) {
        ArrayList<Book> books = getCurrentlyReadingBooks();

        if(books != null){
            if(books.add(book)){

                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(CURRENTLY_READ_BOOKS_KEY);
                editor.putString(CURRENTLY_READ_BOOKS_KEY, gson.toJson(books));
                editor.commit();
                return true;
            }

        }
        return false;
    }

    public boolean removeFromAlreadyRead(Book book) {
        ArrayList<Book> books = getAlreadyReadBooks();

        if(books != null){

            for(Book b: books){
                if(b.getId()==book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(AlREADY_READ_BOOKS_KEY);
                        editor.putString(AlREADY_READ_BOOKS_KEY, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public boolean removeFromWantToRead(Book book) {
        ArrayList<Book> books = getWantToReadBooks();

        if(books != null){

            for(Book b: books){
                if(b.getId()==book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(WANT_TO_READ_BOOKS_KEY);
                        editor.putString(WANT_TO_READ_BOOKS_KEY, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public boolean removeFromFavorite(Book book) {
        ArrayList<Book> books = getFavoriteBooks();

        if(books != null){

            for(Book b: books){
                if(b.getId()==book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(FAVORITE_BOOKS_KEY);
                        editor.putString(FAVORITE_BOOKS_KEY, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public boolean removeFromCurrentlyRead(Book book) {
        ArrayList<Book> books = getCurrentlyReadingBooks();

        if(books != null){

            for(Book b: books){
                if(b.getId()==book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(CURRENTLY_READ_BOOKS_KEY);
                        editor.putString(CURRENTLY_READ_BOOKS_KEY, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }

        }
        return false;
    }


}
