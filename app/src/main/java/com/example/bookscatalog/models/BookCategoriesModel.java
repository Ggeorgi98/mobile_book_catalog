package com.example.bookscatalog.models;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bookscatalog.R;
import com.example.bookscatalog.entities.Book;

public class BookCategoriesModel extends Fragment {
    private Button fantasyCat, thrillerCat, historicCat;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.books_categories, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        fantasyCat = getView().findViewById(R.id.fantasy_category);
        thrillerCat = getView().findViewById(R.id.thriller_category);
        historicCat = getView().findViewById(R.id.historic_category);
        fantasyCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putString("Category", Book.Categories.Fantasy.name());
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                BooksPerCategoryModel booksPerCatFragment = new BooksPerCategoryModel();
                booksPerCatFragment.setArguments(data);
                transaction.replace(R.id.fragment_container, booksPerCatFragment);
                transaction.commit();
            }
        });

        thrillerCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putString("Category", Book.Categories.Thriller.name());
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                BooksPerCategoryModel booksPerCatFragment = new BooksPerCategoryModel();
                booksPerCatFragment.setArguments(data);
                transaction.replace(R.id.fragment_container, booksPerCatFragment);
                transaction.commit();
            }
        });

        historicCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putString("Category", Book.Categories.Historic.name());
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                BooksPerCategoryModel booksPerCatFragment = new BooksPerCategoryModel();
                booksPerCatFragment.setArguments(data);
                transaction.replace(R.id.fragment_container, booksPerCatFragment);
                transaction.commit();
            }
        });
    }
}
