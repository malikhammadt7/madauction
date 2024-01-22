package com.example.madauctionapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;

import com.example.madauctionapp.R;
import com.example.madauctionapp.databinding.ActivityAddPostBinding;
import com.example.madauctionapp.databinding.ActivityHomeBinding;
import com.example.madauctionapp.databinding.DialogItembidBinding;
import com.example.madauctionapp.databinding.DialogPostedBinding;

public class AddPostActivity extends AppCompatActivity {
	
	//region Attributes
	private ActivityAddPostBinding binding;
	private final String TAG = "AddPostActivity";
	//endregion Attributes
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = ActivityAddPostBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
		
		binding.btnPostItem.setOnClickListener(view -> {
			showPostedDialog();
		});
		
		binding.toolbar.btnBack.setOnClickListener(view -> {
			Intent intent = new Intent(this, HomeActivity.class);
			startActivity(intent);
		});
		
	}
	
	public void showPostedDialog() {
		DialogPostedBinding dialogBinding = DialogPostedBinding.inflate(LayoutInflater.from(this));
		Dialog bidDialog = new Dialog(this);
		
		bidDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		bidDialog.setContentView(dialogBinding.getRoot());
		
		bidDialog.show();
		
		Window window = bidDialog.getWindow();
		if (window != null) {
			WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
			layoutParams.copyFrom(window.getAttributes());
			layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
			layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
			window.setAttributes(layoutParams);
		}
		
		dialogBinding.buttonClosePostedDialog.setOnClickListener(view -> {
			bidDialog.dismiss();
			Intent intent = new Intent(this, HomeActivity.class);
			startActivity(intent);
		});
	}
	
}