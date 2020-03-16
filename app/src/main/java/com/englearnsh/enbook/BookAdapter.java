package com.englearnsh.enbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private Context mContext;

    private List<Book> mBookList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView bookView;
        ImageView bookImage;
        TextView bookName;

        public ViewHolder(View view) {
            super(view);
            bookView = (CardView) view;
            bookImage = view.findViewById(R.id.book_image);
            bookName = view.findViewById(R.id.book_name);
        }
    }

    public BookAdapter(List<Book> bookList) {
        mBookList = bookList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.bookView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Book book = mBookList.get(position);
                Toast.makeText(view.getContext(), R.string.unavailable, Toast.LENGTH_SHORT).show();
            }
        });
        holder.bookImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Book book = mBookList.get(position);
                Toast.makeText(view.getContext(), R.string.unavailable, Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = mBookList.get(position);
        holder.bookImage.setImageResource(book.getImageId());
        holder.bookName.setText(book.getName());
    }

    @Override
    public int getItemCount() {
        return mBookList.size();
    }


}
