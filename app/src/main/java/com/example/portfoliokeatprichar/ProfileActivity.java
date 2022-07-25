package com.example.portfoliokeatprichar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "com.example.portfoliokeatprichar.NAME";
    public static final String EXTRA_RESULT = "com.example.portfoliokeatprichar.RESULT";

    @Override
    protected  void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        String name = intent.getStringExtra(EXTRA_NAME);
        TextView tvName = findViewById(R.id.tvName);
        tvName.setText(name);

        btnPhoneNumberListenerMethod();
    }

    private void btnPhoneNumberListenerMethod() {
        Button btnPhoneNumber = findViewById(R.id.btnPhoneNumber);
        Uri number = Uri.parse("tel:09667357235");
        Intent intent = new Intent(Intent.ACTION_DIAL, number);
        btnPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
