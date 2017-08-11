package com.example.mahmoudshaeer.taskahmedboghdady.adapter.adapterRecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mahmoudshaeer.taskahmedboghdady.R;
import com.example.mahmoudshaeer.taskahmedboghdady.model.apiResponse.Results;

import java.util.ArrayList;

/**
 * Created by Mahmoud Shaeer on 11/08/2017.
 */

public class AdapterAllSubject extends RecyclerView.Adapter<AdapterAllSubject.MyViewHolder> {

    private ArrayList<Results> allSubjectAsObj;
    private Context context;

    public AdapterAllSubject(ArrayList<Results> allSubjectAsObj, Context context) {
        this.allSubjectAsObj = allSubjectAsObj;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView subjectGrade, subjectName, subjectTeacher;

        public MyViewHolder(View itemView) {
            super(itemView);
            subjectGrade = (TextView) itemView.findViewById(R.id.itemAllSubject_TextView_grade_by_integer);
            subjectName = (TextView) itemView.findViewById(R.id.itemAllSubject_TextView_nameSubject);
            subjectTeacher = (TextView) itemView.findViewById(R.id.itemAllSubject_TextView_nameOfTeacher);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_all_subject, parent, false);
        MyViewHolder holder = new MyViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Results results = allSubjectAsObj.get(position);
        holder.subjectGrade.setText(results.getT_result_total() + " / " + results.getT_result_value());
        holder.subjectName.setText(results.getCourse_name());
        holder.subjectTeacher.setText(results.getTeacher_name());
    }

    @Override
    public int getItemCount() {
        return allSubjectAsObj.size();
    }

}
