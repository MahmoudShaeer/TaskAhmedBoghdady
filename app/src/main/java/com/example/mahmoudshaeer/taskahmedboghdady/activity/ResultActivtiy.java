package com.example.mahmoudshaeer.taskahmedboghdady.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import com.example.mahmoudshaeer.taskahmedboghdady.R;
import com.example.mahmoudshaeer.taskahmedboghdady.adapter.utils.ViewPagerAdapter;
import com.example.mahmoudshaeer.taskahmedboghdady.fragment.FinalGradeFragment;
import com.example.mahmoudshaeer.taskahmedboghdady.fragment.GradeRecyclerFragment;

import io.fabric.sdk.android.Fabric;

public class ResultActivtiy extends AppCompatActivity {

    private ViewPager resultActivityViewpager;
    private String titleFinalGrafe;
    private String titleRecyclerGrade;
    private TabLayout ResultActivityTabLayoutTabs;
    private String myData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_result_activtiy);
        titleFinalGrafe = getString(R.string.title_tab_final_Grade);
        titleRecyclerGrade = getString(R.string.title_tab_recycler_Grade);
        Intent intent = getIntent();
        if (intent != null) {
            myData = intent.getStringExtra("allSubject");
        }
        initViews();
        setupViewPager(resultActivityViewpager);
        ResultActivityTabLayoutTabs.setupWithViewPager(resultActivityViewpager);
    }

    public String getMyData() {
        return myData;
    }

    private void initViews() {
        resultActivityViewpager = (ViewPager) findViewById(R.id.ResultActivity_viewPager);
        ResultActivityTabLayoutTabs = (TabLayout) findViewById(R.id.ResultActivity_tabLayout_tabs);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FinalGradeFragment(), titleFinalGrafe);
        adapter.addFragment(new GradeRecyclerFragment(), titleRecyclerGrade);
        viewPager.setAdapter(adapter);
    }

}
