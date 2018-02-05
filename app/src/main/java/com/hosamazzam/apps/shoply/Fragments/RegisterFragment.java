package com.hosamazzam.apps.shoply.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.hosamazzam.apps.shoply.R;

/**
 * Created by Hosam Azzam on 30/01/2018.
 */

public class RegisterFragment extends Fragment {
    EditText email, username, password, address;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_register, container, false);

        email = rootview.findViewById(R.id.user_email);
        password = rootview.findViewById(R.id.user_password);
        username = rootview.findViewById(R.id.user_name);
        address = rootview.findViewById(R.id.user_address);

        rootview.findViewById(R.id.register_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!email.getText().toString().equals("") && !password.getText().toString().equals("") &&
                        !address.getText().toString().equals("") && !username.getText().toString().equals("")) {
                    register(email.getText().toString(), password.getText().toString(), address.getText().toString(), username.getText().toString());
                } else {
                    Toast.makeText(getContext(), "Please fill all boxes", Toast.LENGTH_LONG).show();
                }
            }
        });

        rootview.findViewById(R.id.have_account).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (getFragmentManager() != null) {
                        getFragmentManager().popBackStack();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        rootview.findViewById(R.id.fb_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        rootview.findViewById(R.id.gplus_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        rootview.findViewById(R.id.twt_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return rootview;
    }

    private void register(String email, String pass, String address, String username) {
    }
}
