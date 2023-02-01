package com.atm.atm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Dashboard extends AppCompatActivity {
    Button Change_Pin, Check_Balance, Cash_Withdraw, View_Details, Cash_Deposit, Loan;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Change_Pin = findViewById(R.id.change_pin);
        Check_Balance = findViewById(R.id.check_balance);
        Cash_Deposit = findViewById(R.id.cash_deposit);
        Cash_Withdraw = findViewById(R.id.cash_withdraw);
        View_Details = findViewById(R.id.view_details);
        Loan = findViewById(R.id.loan);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        String UserName = getIntent().getStringExtra("username");

        String welcomeText = "Welcome " + UserName + "!";
        TextView tvWelcome = findViewById(R.id.tvWelcome);
        tvWelcome.setText(welcomeText);

        View_Details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, ViewDetails.class).putExtra("username", UserName));
            }
        });

        Change_Pin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, ChangePin.class).putExtra("username", UserName));
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_search:
                        Intent intentA = new Intent(Dashboard.this, Search.class);
                        startActivity(intentA);
                        return true;
                    case R.id.action_notification:
                        Intent intentB = new Intent(Dashboard.this, Notification.class);
                        startActivity(intentB);
                        return true;
                    case R.id.action_profile:
                        Intent intentC = new Intent(Dashboard.this, Profile.class);
                        startActivity(intentC);
                        return true;

                }
                return false;
            }
        });


    }
}