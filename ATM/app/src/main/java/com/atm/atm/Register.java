package com.atm.atm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private static final String TAG = "RegisterActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.etRUserName);
        etPassword = findViewById(R.id.etRPassword);

        findViewById(R.id.btnRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registerUser();
            }
        });

        findViewById(R.id.tvLoginLink).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });
    }

    private void registerUser() {
        String userName = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (userName.isEmpty()) {
            etUsername.setError("Username is required");
            etUsername.requestFocus();
            return;
        } else if (password.isEmpty()) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return;
        }

        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getAPI()
                .createUser(new User(userName, password));

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String s = "";
                try {
                    s = response.body().string();
                    Log.i(TAG, "onResponse A: "+ s);

                }
                catch (IOException e) {
                    Log.e(TAG,"IOException"+ e.getMessage());
                    e.printStackTrace();
                }

                if (s.equals("SUCCESS")) {
                    Log.i(TAG, "onResponse B: "+ s);
                    Toast.makeText(Register.this, "Successfully registered. Please login", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Register.this, Login.class));
                } else {
                    Toast.makeText(Register.this, "User already exists!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG,"Throwable error");
                Log.i(TAG,"Throwable error");
                Log.w(TAG,"Throwable error " + t.getMessage());
                Log.d(TAG,"Throwable error");
                Log.v(TAG,"Throwable error");
                Toast.makeText(Register.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}