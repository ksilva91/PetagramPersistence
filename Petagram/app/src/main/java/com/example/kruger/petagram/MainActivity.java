package com.example.kruger.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kruger.petagram.adapters.PageAdapter;
import com.example.kruger.petagram.fragments.GridListFragment;
import com.example.kruger.petagram.fragments.ListFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.action_bar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
        setUpViewPager();

    }

    private ArrayList<Fragment> addFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ListFragment());
        fragments.add(new GridListFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),addFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_home);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_dog);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_star:
                Intent intent = new Intent(MainActivity.this, FavoritePetsActivity.class);
                startActivity(intent);
                break;
            case R.id.mContact:
                Intent intent2 = new Intent(MainActivity.this, ContactoActivity.class);
                startActivity(intent2);
                break;
            case R.id.mAbout:
                Intent intent3 = new Intent(MainActivity.this, AboutUsActivity.class);
                startActivity(intent3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
