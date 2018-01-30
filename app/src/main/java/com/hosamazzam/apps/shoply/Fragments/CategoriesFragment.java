package com.hosamazzam.apps.shoply.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hosamazzam.apps.shoply.R;

/**
 * Created by Hosam Azzam on 30/01/2018.
 */

public class CategoriesFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_categroies, container, false);

        return rootview;
    }
}