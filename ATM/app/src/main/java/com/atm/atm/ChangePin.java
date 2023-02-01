package com.atm.atm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePin extends AppCompatActivity {
    private static final String TAG = "ChangePin";
    private EditText editTextPin, editTextName;
    private Button buttonSave;
    TextView textViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pin);

        textViewName = findViewById(R.id.displayNameForUpdate);
        editTextPin = findViewById(R.id.editTextPin);
        editTextName = findViewById(R.id.editTextName);
        buttonSave = findViewById(R.id.buttonSave);

        String UserName = getIntent().getStringExtra("username");
        Log.i(TAG, "User name from which user has been logged in: "+UserName);
        String welcomeText = "Welcome " + UserName + "!";
        textViewName.setText(welcomeText);



        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = editTextName.getText().toString().trim();
                String userPin = editTextPin.getText().toString().trim();

                Log.i(TAG, "Inserted name: "+ userName);

                if (userName.isEmpty()) {
                    editTextName.setError("Username is required");
                    editTextName.requestFocus();
                    return;
                } else if (userPin.isEmpty()) {
                    editTextPin.setError("Password is required");
                    editTextPin.requestFocus();
                    return;
                }

                if (UserName.equals(userName)) {

                    Log.i("ChangePin", "onClick: if is executed");
                    Pin pin = new Pin();

                    pin.setUserPin(Integer.parseInt(editTextPin.getText().toString()));
                    pin.setUserName(editTextName.getText().toString());

                    PinAPI pinAPI = APIClient.getClient().create(PinAPI.class);
                    pinAPI.save(pin).enqueue(new Callback<Pin>() {
                        @Override
                        public void onResponse(Call<Pin> call, Response<Pin> response) {
                            try {
                                if (response.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), getString(R.string.update), Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), response.errorBody().string(), Toast.LENGTH_LONG).show();
                                }
                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Pin> call, Throwable t) {
                            Log.e("Change Pin Activity", "Error!!!"+ t.getMessage());
                            Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }

                else{
                    
                    Toast.makeText(ChangePin.this,"You can't change the pin of another user", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    }
