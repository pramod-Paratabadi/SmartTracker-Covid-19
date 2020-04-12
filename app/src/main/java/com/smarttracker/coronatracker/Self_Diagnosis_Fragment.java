package com.smarttracker.coronatracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;


public class Self_Diagnosis_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private WebView webView;
    private String Load_url = "https://covid.apollo247.com/?utm_source=linkedin&utm_medium=organic&utm_campaign=bot_scanner";
    //"https://www.arcgis.com/apps/opsdashboard/index.html#/85320e2ea5424dfaaa75ae62e5c06e61";
    private final static long threshold = 150000;


    public Self_Diagnosis_Fragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static Self_Diagnosis_Fragment newInstance(String param1, String param2) {
        Self_Diagnosis_Fragment fragment = new Self_Diagnosis_Fragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_self__diagnosis_, container, false);

        return v;

    }


}
