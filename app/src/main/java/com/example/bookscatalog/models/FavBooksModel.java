package com.example.bookscatalog.models;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookscatalog.R;
import com.example.bookscatalog.entities.Book;
import com.example.bookscatalog.helpers.BookRecyclerViewAdapter;

public class FavBooksModel extends Fragment {
    private Button moreBooksBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fav_books, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        RecyclerView booksContainer = getView().findViewById(R.id.favBooksContainer);
        BookRecyclerViewAdapter booksAdapter = new BookRecyclerViewAdapter(getActivity(), Book.books);
        booksContainer.setLayoutManager(new GridLayoutManager(getActivity(),3));
        booksContainer.setAdapter(booksAdapter);


        moreBooksBtn = getView().findViewById(R.id.moreBooks);
        moreBooksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BookCategoriesModel()).commit();
            }
        });
    }
}
