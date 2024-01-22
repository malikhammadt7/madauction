package com.example.madauctionapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.madauctionapp.R;
import com.example.madauctionapp.databinding.ActivityItemDetailBinding;
import com.example.madauctionapp.databinding.ActivityLoginBinding;
import com.example.madauctionapp.databinding.DialogItembidBinding;
import com.example.madauctionapp.databinding.DialogSuccessfulBinding;

public class ItemDetailActivity extends AppCompatActivity {
	
	//region Attributes
	private ActivityItemDetailBinding binding;
	private final String TAG = "ItemDetailActivity";
	//endregion Attributes
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = ActivityItemDetailBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
		
		binding.toolbar.btnBack.setOnClickListener(view -> {
			Intent intent = new Intent(this, HomeActivity.class);
			startActivity(intent);
		});
		
		binding.btnBid.setOnClickListener(view -> {
			showBidDialog();
		});
	}
	
	public void showBidDialog() {
		DialogItembidBinding dialogBinding = DialogItembidBinding.inflate(LayoutInflater.from(this));
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
		
		dialogBinding.btnCancel.setOnClickListener(view -> {
			bidDialog.dismiss();
		});
		
		dialogBinding.btnPlaceBid.setOnClickListener(view -> {
			bidDialog.dismiss();
			showBidSuccessDialog();
		});
	}
	
	public void showBidSuccessDialog(){
		DialogSuccessfulBinding dialogBinding = DialogSuccessfulBinding.inflate(LayoutInflater.from(this));
		Dialog successDialog = new Dialog(this);
		
		successDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		successDialog.setContentView(dialogBinding.getRoot());
		
		successDialog.show();
		
		Window window = successDialog.getWindow();
		if (window != null) {
			WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
			layoutParams.copyFrom(window.getAttributes());
			layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
			layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
			window.setAttributes(layoutParams);
		}
		
		dialogBinding.buttonCloseSuccessDialog.setOnClickListener(view -> {
			successDialog.dismiss();
		});
	}
}