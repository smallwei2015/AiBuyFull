package com.vode.aibuy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.vode.aibuy.R;

public class SearchActivity extends AppCompatActivity {

    public EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        search = findViewById(R.id.search_edit);
        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                switch (actionId) {

                    case EditorInfo.IME_ACTION_SEARCH:

                        break;

                }
                return false;
            }
        });
    }
}
