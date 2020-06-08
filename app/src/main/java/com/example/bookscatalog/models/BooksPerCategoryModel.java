package com.example.bookscatalog.models;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookscatalog.R;
import com.example.bookscatalog.helpers.BooksTableHelper;

public class BooksPerCategoryModel extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.books_table, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        TableLayout booksTable = getView().findViewById(R.id.books_table);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String clickedCat = bundle.getString("Category");
            BooksTableHelper.PopulateTable(clickedCat, booksTable, getContext());
        }
    }
}
