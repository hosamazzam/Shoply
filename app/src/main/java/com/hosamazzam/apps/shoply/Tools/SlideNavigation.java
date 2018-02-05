package com.hosamazzam.apps.shoply.Tools;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.TextView;

import com.alexzh.circleimageview.CircleImageView;
import com.hosamazzam.apps.shoply.Dialogs.About_Dialog;
import com.hosamazzam.apps.shoply.Fragments.CartFragment;
import com.hosamazzam.apps.shoply.Fragments.CategoriesFragment;
import com.hosamazzam.apps.shoply.Fragments.HistoryFragment;
import com.hosamazzam.apps.shoply.Fragments.HomeFragment;
import com.hosamazzam.apps.shoply.Fragments.HotFragment;
import com.hosamazzam.apps.shoply.Fragments.LoginFragment;
import com.hosamazzam.apps.shoply.Fragments.ProfileFragment;
import com.hosamazzam.apps.shoply.R;


/**
 * Created by hosamazzam on 22/02/17.
 */

public class SlideNavigation {
    int fragmnetholder;
    TextView user_name, home, hot, cart, category, about, logout, history;
    CircleImageView user_img;


    public SlideNavigation(int fragmnetholder) {
        this.fragmnetholder = fragmnetholder;
    }


    public void initSlideMenu(final Activity activity, final FragmentManager fragmentManager, final DrawerLayout drawerLayout) {

        user_img = activity.findViewById(R.id.user_img);
        home = activity.findViewById(R.id.menu_home);
        hot = activity.findViewById(R.id.menu_hot);
        cart = activity.findViewById(R.id.menu_cart);
        category = activity.findViewById(R.id.menu_cat);
        about = activity.findViewById(R.id.menu_about);
        history = activity.findViewById(R.id.menu_his);
        logout = activity.findViewById(R.id.menu_logout);
        user_name = activity.findViewById(R.id.user_name);


        user_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentManager
                        .beginTransaction()
                        .add(R.id.main_fragment_container, new ProfileFragment(), "ProfileFragment")
                        .addToBackStack("ProfileFragment")
                        .commit();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentManager
                        .beginTransaction()
                        .replace(fragmnetholder, new HomeFragment(), "HomeFragment")
                        .commit();
            }
        });

        hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentManager
                        .beginTransaction()
                        .replace(fragmnetholder, new HotFragment(), "HotFragment")
                        .addToBackStack("HotFragment")
                        .commit();

            }
        });

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentManager
                        .beginTransaction()
                        .replace(fragmnetholder, new CategoriesFragment(), "CategoriesFragment")
                        .addToBackStack("CategoriesFragment")
                        .commit();

            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentManager
                        .beginTransaction()
                        .replace(fragmnetholder, new CartFragment(), "CartFragment")
                        .addToBackStack("CartFragment")
                        .commit();
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentManager
                        .beginTransaction()
                        .replace(fragmnetholder, new HistoryFragment(), "HistoryFragment")
                        .addToBackStack("HistoryFragment")
                        .commit();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(GravityCompat.START);
                About_Dialog about_dialog = new About_Dialog();
                about_dialog.show(fragmentManager, about_dialog.getTag());
            }
        });

        user_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentManager
                        .beginTransaction()
                        .replace(fragmnetholder, new LoginFragment(), "LoginFragment")
                        .addToBackStack("LoginFragment")
                        .commit();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
