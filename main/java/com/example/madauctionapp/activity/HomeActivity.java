package com.example.madauctionapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.madauctionapp.R;
import com.example.madauctionapp.databinding.ActivityHomeBinding;
import com.example.madauctionapp.databinding.ActivityLoginBinding;

public class HomeActivity extends AppCompatActivity {
	
	//region Attributes
	private ActivityHomeBinding binding;
	private final String TAG = "HomeActivity";
	//endregion Attributes
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = ActivityHomeBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
		
		binding.itemAuction.getRoot().setOnClickListener(view -> {
			Intent intent = new Intent(this, ItemDetailActivity.class);
			startActivity(intent);
		});
		binding.fab.setOnClickListener(view -> {
			Intent intent = new Intent(this, AddPostActivity.class);
			startActivity(intent);
		});
		
	}
}