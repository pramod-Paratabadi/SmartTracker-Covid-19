package com.smarttracker.coronatracker;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import io.kommunicate.Kommunicate;
import io.kommunicate.callbacks.KmCallback;

public class WebView1 extends AppCompatActivity {
    List<String> agentList = new ArrayList();
    List<String> botList = new ArrayList();
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Kommunicate.init(this, "177c9ffe594c9dd7a5f9f036632a2838c");
        agentList.add("72b5a579-6dbc-44c9-9c6e-fe6590b4d0fa"); //add your agentID
        botList.add("pramodp-mhrks");


        Kommunicate.launchSingleChat(this, "Support", Kommunicate.getVisitor(), false, true, agentList, botList, new KmCallback() {
            @Override
            public void onSuccess(Object message) {
                Log.d(TAG, "Success");
            }

            @Override
            public void onFailure(Object error) {
                Log.d(TAG, "Fail");
            }
        });
    }
}