package com.king.nowweather;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCityActivity extends AppCompatActivity {

    private EditText mCityEditText;
    private Button mAddCityButton;

    private String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);
        initViews();
        initData();
    }

    private void initData() {
        mCityEditText.addTextChangedListener(mCityEditTextWatcher);
        mAddCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, cityName, Snackbar.LENGTH_LONG).show();
            }
        });
    }


    private void initViews() {
        mCityEditText = (EditText) findViewById(R.id.add_city_edittext);
        mAddCityButton = (Button) findViewById(R.id.add_city_button);
    }


    private TextWatcher mCityEditTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            cityName = s.toString().trim();
        }
    };


}
