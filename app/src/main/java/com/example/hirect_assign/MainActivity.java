package com.example.hirect_assign;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import com.example.hirect_assign.databinding.ActivityMainBinding;
import com.example.hirect_assign.fragments.Fragment1;
import com.example.hirect_assign.fragments.Fragment2;
import com.example.hirect_assign.pojo.Model1;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<Model1> list = new ArrayList<>();
    private FragmentTransaction transaction;
    private Fragment1 fragment1 = null;
    private Fragment2 fragment2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        SetUpFragments();
    }

    private void SetUpFragments(){
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayout,getFragment1(),"fragment1").commit();
        binding.bottomNavBar.setOnNavigationItemSelectedListener(selectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            transaction = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()){
                case R.id.home:
                    transaction.replace(R.id.frameLayout,getFragment1(),"fragment1");
                    break;
                case R.id.attachi:
                    transaction.replace(R.id.frameLayout,getFragment2(),"fragment2");
                    break;
            }
            transaction.commit();
            return true;
        }
    };

    private Fragment1 getFragment1(){
        if (fragment1==null){
            fragment1 = new Fragment1();
        }
        return fragment1;
    }

    public Fragment2 getFragment2() {
        if(fragment2==null){
            fragment2 = new Fragment2();
        }
        return fragment2;
    }
}