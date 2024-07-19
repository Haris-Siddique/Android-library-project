package com.example.mylibrary;

import java.util.ArrayList;

public class Utils {
    private static Utils instance;

    private static ArrayList<Book> allBooks;
    private Utils() {
        if(null==allBooks){
            allBooks=new ArrayList<>();
            initData();
        }
    }

    private void initData() {

        //TODO: add initial data.
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
}
