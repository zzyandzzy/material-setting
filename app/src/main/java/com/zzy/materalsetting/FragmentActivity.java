package com.zzy.materalsetting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by zzyandzzy on 2017/1/17.
 */

public class FragmentActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private MainFragment mainFragment;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfragment);
        initViews();
        initFragment();
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("MaterialFragment");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initFragment() {
        fragmentManager = this.getSupportFragmentManager();
        mainFragment = new MainFragment();
        fragmentManager.beginTransaction().replace(R.id.main_fragment,mainFragment).commit();
    }
}
