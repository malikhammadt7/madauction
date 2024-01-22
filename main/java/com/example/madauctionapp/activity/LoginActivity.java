package com.example.madauctionapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.madauctionapp.R;
import com.example.madauctionapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
	
	//region Attributes
	private ActivityLoginBinding binding;
	private final String TAG = "LoginActivity";
	//endregion Attributes
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = ActivityLoginBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
		
		binding.btnSignup.setOnClickListener(view -> {
			Intent intent = new Intent(this, SignupActivity.class);
			startActivity(intent);
		});
	
		binding.btnLogin.setOnClickListener(view -> {
			Intent intent = new Intent(this, HomeActivity.class);
			startActivity(intent);
		});
	
	}
}