package com.example.myfirstapp;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GameButton {
	private boolean flipped;
	private final static Integer EMPTY_BUTTON = R.drawable.empty;
	private Integer setImage;
	private final Button gameButton;
	
	public GameButton(Button button) {
		this.gameButton = button;
		flipped = false;
	}
	
	public void setImage(Integer image) {
		setImage = image;
		
		setClickListener();
	}
	
	public void setFlipped () {
		if (flipped) {
			gameButton.setBackgroundResource(R.drawable.empty);
			flipped = false;
		} else {
			gameButton.setBackgroundResource(setImage);
			flipped = true;
		}
	}
	
	public void setClickListener() {
		gameButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// When stop is clicked, show start again and hide stop
				if (flipped) {
					gameButton.setBackgroundResource(EMPTY_BUTTON);
					flipped = false;
				} else {
					gameButton.setBackgroundResource(setImage);
					flipped = true;
				}
			}
		});
	}
}
