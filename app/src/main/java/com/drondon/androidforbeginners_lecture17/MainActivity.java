package com.drondon.androidforbeginners_lecture17;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnItemClickListener {

    boolean showed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.container, new FirstFragment());
            transaction.commit();
        }

        View button = findViewById(R.id.textView);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toggleFragment();
                }
            });
        }
    }


    private void toggleFragment() {

        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.container);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (fragment == null) {
            transaction.add(R.id.container, new FirstFragment()).addToBackStack(null);
        } else {
            transaction.remove(fragment);
        }
        transaction.commit();
    }

    @Override
    public void onClicked(int position) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, new SecondFragment()).addToBackStack(null);
        transaction.commit();
    }
}
