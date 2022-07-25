package com.example.portfoliokeatprichar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnContactInformationListenerMethod();
        btnOnlinePresenceListenerMethod();
        btnOnlinePresence2ListenerMethod();
        btnPlacesYouveBeenListenerMethod();
        btnPlacesYouveBeen2ListenerMethod();
        btnPlacesYouveBeen3ListenerMethod();
    }


    private void btnPlacesYouveBeenListenerMethod() {
        ImageButton btnPlacesYouveBeen = findViewById(R.id.btnPlacesYouveBeen);
        Uri map = Uri.parse("geo:0,0?q=-46.2044, 6.1432(Geneva)");
        Intent intent = new Intent(Intent.ACTION_VIEW, map);
        btnPlacesYouveBeen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    private void btnPlacesYouveBeen2ListenerMethod() {
        ImageButton btnPlacesYouveBeen2 = findViewById(R.id.btnPlacesYouveBeen2);
        Uri map2 = Uri.parse("geo:0,0?q=Chiang+Mai");
        Intent intent = new Intent(Intent.ACTION_VIEW, map2);
        btnPlacesYouveBeen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
    private void btnPlacesYouveBeen3ListenerMethod() {
        ImageButton btnPlacesYouveBeen3 = findViewById(R.id.btnPlacesYouveBeen3);
        Uri map3 = Uri.parse("geo:0,0?q=Cebu+city");
        Intent intent = new Intent(Intent.ACTION_VIEW, map3);
        btnPlacesYouveBeen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }

    private void btnOnlinePresenceListenerMethod() {
        ImageButton btnOnlinePresence = findViewById(R.id.btnOnlinePresence);
        Uri webpage = Uri.parse("https://www.youtube.com/channel/UCKpeVECX3C2p0LnMTfdz24w");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        btnOnlinePresence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }

    private void btnOnlinePresence2ListenerMethod() {
        ImageButton btnOnlinePresence2 = findViewById(R.id.btnOnlinePresence2);
        Uri webpage = Uri.parse("https://www.deviantart.com/jkeatprichar7");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        btnOnlinePresence2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }

    private void btnContactInformationListenerMethod() {
        Intent intent = new Intent(this, ProfileActivity.class);
        ImageButton btnContactInformation = findViewById(R.id.btnContactInformation);

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == RESULT_OK){
                            Intent outIntent = result.getData();
                            boolean good = outIntent.getBooleanExtra(ProfileActivity.EXTRA_RESULT, false);
                        }
                    }
                });

        btnContactInformation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView tvOpName = findViewById(R.id.tvOpName);
                String OpName = tvOpName.getText().toString();
                intent.putExtra(ProfileActivity.EXTRA_NAME, OpName);
                launcher. launch(intent);
            }
        });

    }
}
