package com.example.mylibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BooksRecViewAdapter extends RecyclerView.Adapter<BooksRecViewAdapter.ViewHolder> {

    private ArrayList<Book> books = new ArrayList<>();
    private Context mcontext;
    private String parentActivity;

    public BooksRecViewAdapter(Context mcontext, String parentActivity) {
        this.mcontext = mcontext;
        this.parentActivity=parentActivity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView parent;
        private ImageView ivBook, downArrow, upArrow;
        private TextView tvBook, tvAuthor, tvAutherName, tvShortDescription, btnDelete;
        private RelativeLayout expandedRelLayout, collapsedRelLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            ivBook = itemView.findViewById(R.id.ivBook);
            tvBook = itemView.findViewById(R.id.tvBook);
            downArrow = itemView.findViewById(R.id.downArrow);
            upArrow = itemView.findViewById(R.id.upArrow);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvAutherName = itemView.findViewById(R.id.tvAutherName);
            tvShortDescription = itemView.findViewById(R.id.tvShortDescription);
            expandedRelLayout = itemView.findViewById(R.id.expandedRelLayout);
            collapsedRelLayout = itemView.findViewById(R.id.collapsedRelLayout);
            btnDelete = itemView.findViewById(R.id.btnDelete);

            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.getIsExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.getIsExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });


        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvBook.setText(books.get(holder.getAdapterPosition()).getName());
        Glide.with(mcontext).asBitmap().load(books.get(holder.getAdapterPosition()).getImageUrl()).into(holder.ivBook);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(mcontext,books.get(holder.getAdapterPosition()).getName() + "Selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mcontext, BookActivity.class);
                intent.putExtra("bookId" ,books.get(holder.getAdapterPosition()).getId());
                mcontext.startActivity(intent);
            }
        });


        holder.tvAuthor.setText(books.get(holder.getAdapterPosition()).getAuthor());
        holder.tvShortDescription.setText(books.get(holder.getAdapterPosition()).getshortDesc());


        if (books.get(holder.getAdapterPosition()).getIsExpanded()) {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);

            if(parentActivity.equals("allBooks")){
                holder.btnDelete.setVisibility(View.GONE);
            }
            else if(parentActivity.equals("alreadyRead")){

                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);

                        builder.setMessage("Are you want to delete " + books.get(holder.getAdapterPosition()).getName() + "?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if(Utils.getInstance().removeFromAlreadyRead(books.get(holder.getAdapterPosition()))){
                                    Toast.makeText(mcontext, "Book was removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                                else{
                                    Toast.makeText(mcontext,"Somthing went wrong", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        builder.create().show();

                    }
                });
            }


            else if(parentActivity.equals("wantToRead")){

                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);

                        builder.setMessage("Are you want to delete " + books.get(holder.getAdapterPosition()).getName() + "?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if(Utils.getInstance().removeFromWantToRead(books.get(holder.getAdapterPosition()))){
                                    Toast.makeText(mcontext, "Book was removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                                else{
                                    Toast.makeText(mcontext,"Somthing went wrong", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        builder.create().show();

                    }
                });

            }
            else if(parentActivity.equals("currentlyReading")){

                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);

                        builder.setMessage("Are you want to delete " + books.get(holder.getAdapterPosition()).getName() + "?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if(Utils.getInstance().removeFromCurrentlyRead(books.get(holder.getAdapterPosition()))){
                                    Toast.makeText(mcontext, "Book was removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                                else{
                                    Toast.makeText(mcontext,"Somthing went wrong", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        builder.create().show();

                    }
                });

            }
            else if(parentActivity.equals("favoriteBook")){


                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);

                        builder.setMessage("Are you want to delete " + books.get(holder.getAdapterPosition()).getName() + "?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if(Utils.getInstance().removeFromFavorite(books.get(holder.getAdapterPosition()))){
                                    Toast.makeText(mcontext, "Book was removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                                else{
                                    Toast.makeText(mcontext,"Somthing went wrong", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        builder.create().show();

                    }
                });


            }

        } else {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }


}
