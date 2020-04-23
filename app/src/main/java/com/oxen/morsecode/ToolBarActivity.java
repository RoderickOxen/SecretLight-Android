package com.oxen.morsecode;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import com.google.android.material.tabs.TabLayout;
import java.util.Map;
import java.util.TreeMap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class ToolBarActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private Map<Integer, String> top_normal = new TreeMap<>();
    private Map<Integer, String> top_hard = new TreeMap<>();
    private ProgressDialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_bar);
        setup();
    }

    private void setup() {
        mSectionsPagerAdapter=  new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        setmViewPager(mViewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager );
    }

    public void setmViewPager(ViewPager mViewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LibraryFrag(), "Alphabet");
        adapter.addFragment(new WordFrag(), "Text");
        mViewPager.setAdapter(adapter);

    }
}
