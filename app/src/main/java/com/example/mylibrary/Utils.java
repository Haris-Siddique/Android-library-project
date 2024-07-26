package com.example.mylibrary;

import java.util.ArrayList;

public class Utils {
    private static Utils instance;
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favoriteBooks;

    private Utils() {
        if(null==allBooks){
            allBooks=new ArrayList<>();
            initData();
        }
        if(null==alreadyReadBooks){
            alreadyReadBooks=new ArrayList<>();

        }
        if(null==wantToReadBooks){
            wantToReadBooks=new ArrayList<>();

        }

        if(null==currentlyReadingBooks){
            currentlyReadingBooks=new ArrayList<>();
        }
        if(null==favoriteBooks){
            favoriteBooks=new ArrayList<>();

        }
    }

    public static Utils getInstance() {

        if(null!=instance) {
            return instance;
        }
        else{
            instance = new Utils();
            return instance;
        }
    }

    private void initData() {

        //TODO: add initial data.
        allBooks.add(new Book(1,"1 BookOfStory","Haris",150,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlAkmuLe5t04pqAdlj0YB8eH2fuikKN6eumA&s","1 ShortDes","1 LongDes"));
        allBooks.add(new Book(2,"2 BookOfStory","Haris",150,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlAkmuLe5t04pqAdlj0YB8eH2fuikKN6eumA&s","2 ShortDes","2 LongDes"));
        allBooks.add(new Book(3,"3 BookOfStory","Haris",150,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlAkmuLe5t04pqAdlj0YB8eH2fuikKN6eumA&s","3 ShortDes","3 LongDes"));
        allBooks.add(new Book(4,"4 BookOfStory","Haris",150,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlAkmuLe5t04pqAdlj0YB8eH2fuikKN6eumA&s","4 ShortDes","4 LongDes"));

    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public Book getBookById(int bookId){
        for(Book b: allBooks){
            if(b.getId()==bookId){
                return b;
            }
        }
        return null;
    }

    public boolean addToAlreadyRead(Book book){
        return alreadyReadBooks.add(book);
    }

    public boolean addToWantToRead(Book book){
        return wantToReadBooks.add(book);
    }

    public boolean addToFavorite(Book book){
        return favoriteBooks.add(book);
    }

    public boolean addToCurrentlyRead(Book book){
        return currentlyReadingBooks.add(book);
    }


}
