package com.atm.atm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewDetails extends AppCompatActivity {
    TextView Result, DisplayName;
    private static final String TAG = "ViewDetails";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        Result  = findViewById(R.id.result);
        DisplayName = findViewById(R.id.displayName);

        String UserName = getIntent().getStringExtra("username");
        String welcomeText = "Welcome " + UserName + "!";

        DisplayName.setText(welcomeText);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.3:8088/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceholderAPI jsonPlaceholderAPI = retrofit.create(JsonPlaceholderAPI.class);

        Call<List<Details>> call = jsonPlaceholderAPI.getData();
        call.enqueue(new Callback<List<Details>>() {
            @Override
            public void onResponse(Call<List<Details>> call, Response<List<Details>> response) {
                if(!response.isSuccessful()){
                    Log.e(TAG, "" + response );
                    Result.setText("code:"+ response);
                    return;
                }

                List<Details> details = response.body();

                for(Details detail: details){
                    String content = "" ;
                    content += "id is " + detail.getDetailsId() + "\n";
                    content += "account number is " + detail.getAccountNo() + "\n";
                    content += "name is " + detail.getUserName() + "\n";
                    content += "amount is " + detail.getAmount() + "\n";
                    content += "card no is " + detail.getCardNo() + "\n";
                    content += "phone number is " + detail.getPhoneNo() + "\n";


                    Result.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Details>> call, Throwable t) {
                Result.setText(t.getMessage());
            }
        });

    }
}