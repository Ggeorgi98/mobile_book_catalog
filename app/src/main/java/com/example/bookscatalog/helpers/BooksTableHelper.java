package com.example.bookscatalog.helpers;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.bookscatalog.R;
import com.example.bookscatalog.ReadBookActivity;
import com.example.bookscatalog.entities.Book;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


import java.util.List;

public class BooksTableHelper {
    public static void PopulateTable(final String bookCategory, TableLayout table, final Context context){
        List<Book> filteredBooks = Lists.newArrayList(Iterables.filter(Book.books, new Predicate<Book>() {
            @Override
            public boolean apply(Book book) {
                return book.getCategory() == bookCategory;
            }
        }));

        for (final Book book : filteredBooks) {
            View bookRow = LayoutInflater.from(context).inflate(R.layout.book_item_row,null,false);
            Bitmap bitmap = BitmapFactory.decodeStream(context.getResources().openRawResource(book.getThumbnails()));
            ImageView book_image  = bookRow.findViewById(R.id.book_cell_img);
            TextView book_title  = bookRow.findViewById(R.id.book_title_cell);
            TextView book_category = bookRow.findViewById(R.id.book_category_cell);
            TextView book_pages  = bookRow.findViewById(R.id.book_pages_cell);

            book_image.setImageBitmap(bitmap);
            book_title.setText(book.getTitle());
            book_category.setText(book.getCategory());
            book_pages.setText(String.valueOf(book.getPages()));

            bookRow.setClickable(true);

            bookRow.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(context, ReadBookActivity.class);
                    intent.putExtra("Title",book.getTitle());
                    intent.putExtra("Link",book.getLink());
                    context.startActivity(intent);
                }
            });

            table.addView(bookRow);
        }
    }
}
