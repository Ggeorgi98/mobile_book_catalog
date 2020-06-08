package com.example.bookscatalog.models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookscatalog.R;


public class UserProfileModel extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        Bitmap bitmap = BitmapFactory.decodeStream(getContext().getResources().openRawResource(R.drawable.profile_pic_man));
        ImageView profile_pic = getView().findViewById(R.id.profile_image);
        profile_pic.setImageBitmap(bitmap);
    }
}
