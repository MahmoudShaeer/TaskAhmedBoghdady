package com.example.mahmoudshaeer.taskahmedboghdady.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.mahmoudshaeer.taskahmedboghdady.R;
import com.example.mahmoudshaeer.taskahmedboghdady.model.apiRequest.RequestShowResult;
import com.example.mahmoudshaeer.taskahmedboghdady.model.apiResponse.ResponseShowResult;
import com.google.gson.Gson;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText studentId;
    private EditText xApiKey;
    private Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initViews();
        show.setOnClickListener(this);
    }

    private void initViews() {
        studentId = (EditText) findViewById(R.id.SplashActivity_EditeText_StidentId);
        show = (Button) findViewById(R.id.SplashActivity_Button_Show);
        xApiKey = (EditText) findViewById(R.id.SplashActivity_EditeText_xApiKey);
    }

    void callApi(RequestShowResult requestShowResult, String xApiKey) {
        String pleaseWait = getString(R.string.message_dialog_api);
        final ProgressDialog dialog;
        dialog = new ProgressDialog(this);
        dialog.setMessage(pleaseWait);
        dialog.show();
        dialog.setCancelable(false);
        AndroidNetworking.post("http://index-soft.com/hh-school/term")
                .addHeaders("x-api-key", xApiKey)
                .addApplicationJsonBody(requestShowResult)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsObject(ResponseShowResult.class, new ParsedRequestListener<ResponseShowResult>() {
                    @Override
                    public void onResponse(ResponseShowResult response) {
                        if (response.isSuccess()) {
                            Intent intent = new Intent(SplashActivity.this, ResultActivtiy.class);
                            Gson gson = new Gson();
                            intent.putExtra("allSubject", gson.toJson(response.getResults()));
                            startActivity(intent);
                            dialog.dismiss();
                        } else {
                            Toast.makeText(SplashActivity.this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(SplashActivity.this, R.string.error_server, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.SplashActivity_Button_Show) {
            if (studentId.getText().toString().isEmpty()) {
                studentId.setError(getString(R.string.studentId));
            } else {
                RequestShowResult requestShowResult = new RequestShowResult(studentId.getText().toString());
                if (xApiKey.getText().toString().isEmpty()) {
                    callApi(requestShowResult, "123");
                } else {
                    callApi(requestShowResult, xApiKey.getText().toString());
                }
            }
        }
    }
}
