package com.example.bookscatalog.helpers;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.bookscatalog.R;
import com.example.bookscatalog.ReadBookActivity;
import com.example.bookscatalog.entities.Book;

import java.util.List;

public class BookRecyclerViewAdapter  extends RecyclerView.Adapter<BookRecyclerViewAdapter.BookViewHolder> {

    private Context mContext ;
    private List<Book> books ;

    public BookRecyclerViewAdapter(Context mContext, List<Book> books) {
        this.mContext = mContext;
        this.books = books;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card_view_book,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, final int position) {
        final Book book = books.get(position);
        String pages = "Pages:" + book.getPages();
        Bitmap bitmap = BitmapFactory.decodeStream(mContext.getResources().openRawResource(book.getThumbnails()));
        holder.img_book_thumbnail.setImageBitmap(bitmap);
        holder.book_category.setText(book.getCategory());
        holder.books_pages_count.setText(pages);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, ReadBookActivity.class);
                intent.putExtra("Title",book.getTitle());
                intent.putExtra("Link",book.getLink());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class BookViewHolder extends ViewHolder {

        TextView book_category;
        TextView books_pages_count;
        ImageView img_book_thumbnail;
        CardView cardView ;

        public BookViewHolder(View itemView) {
            super(itemView);

            book_category = itemView.findViewById(R.id.book_category);
            img_book_thumbnail = itemView.findViewById(R.id.book_img_id);
            books_pages_count = itemView.findViewById(R.id.book_pages_count);
            cardView = itemView.findViewById(R.id.book_card);
        }
    }
}
