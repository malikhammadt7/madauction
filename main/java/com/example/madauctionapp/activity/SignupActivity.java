package com.example.madauctionapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.madauctionapp.R;
import com.example.madauctionapp.databinding.ActivityLoginBinding;
import com.example.madauctionapp.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {
	
	//region Attributes
	private ActivitySignupBinding binding;
	private final String TAG = "SignupActivity";
	//endregion Attributes
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = ActivitySignupBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
		
		binding.btnLogin.setOnClickListener(view -> {
			Intent intent = new Intent(this, LoginActivity.class);
			startActivity(intent);
		});
		
		binding.btnSignup.setOnClickListener(view -> {
			Intent intent = new Intent(this, HomeActivity.class);
			startActivity(intent);
		});
		
	}
	
}