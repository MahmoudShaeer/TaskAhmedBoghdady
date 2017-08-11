package com.example.mahmoudshaeer.taskahmedboghdady.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mahmoudshaeer.taskahmedboghdady.R;

/**
 * Created by Mahmoud Shaeer on 11/08/2017.
 */

public class GradeRecyclerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grade_recycler_fragment, container, false);
        return view;
    }
}
