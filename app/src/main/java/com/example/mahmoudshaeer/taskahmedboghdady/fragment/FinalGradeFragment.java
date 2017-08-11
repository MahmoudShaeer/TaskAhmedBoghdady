package com.example.mahmoudshaeer.taskahmedboghdady.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mahmoudshaeer.taskahmedboghdady.R;
import com.example.mahmoudshaeer.taskahmedboghdady.activity.ResultActivtiy;
import com.example.mahmoudshaeer.taskahmedboghdady.adapter.adapterRecycler.AdapterAllSubject;
import com.example.mahmoudshaeer.taskahmedboghdady.model.apiResponse.Results;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Mahmoud Shaeer on 11/08/2017.
 */

public class FinalGradeFragment extends Fragment {

    private RecyclerView allSubject;
    private ArrayList<Results> allSubjectObj;
    private TextView finalResult;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.final_grade_fragment, container, false);
        initViews(view);
        fillAllSubject();
        calCulateResult();
        AdapterAllSubject adapterItemInOrder = new AdapterAllSubject(allSubjectObj, getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        allSubject.setLayoutManager(mLayoutManager);
        allSubject.setItemAnimator(new DefaultItemAnimator());
        allSubject.setAdapter(adapterItemInOrder);

        return view;
    }

    private void initViews(View view) {
        allSubject = (RecyclerView) view.findViewById(R.id.AllSubjects_RecyclerView_allSubject);
        finalResult = (TextView) view.findViewById(R.id.AllSubjects_TextView_totalGrade);
    }

    void fillAllSubject() {
        Gson gson = new Gson();
        ResultActivtiy activity = (ResultActivtiy) getActivity();
        String allSubject = activity.getMyData();
        Type type = new TypeToken<ArrayList<Results>>() {
        }.getType();
        allSubjectObj = gson.fromJson(allSubject, type);
    }

    void calCulateResult() {
        int totalGet = 0;
        int tootalShould = 0;
        for (int i = 0; i < allSubjectObj.size(); i++) {
            totalGet+=Integer.valueOf(allSubjectObj.get(i).getT_result_value());
            tootalShould+=Integer.valueOf(allSubjectObj.get(i).getT_result_total());
        }
        finalResult.setText(tootalShould + " / "+totalGet);
    }
}
