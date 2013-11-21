package com.example.myfirstapp;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GameButton {
	private boolean flipped;
	private Integer[] randomizedThumbs;
	
	public GameButton(Button button, boolean flippedOrNot, Integer[] thumbs, Integer image) {
		randomizedThumbs = thumbs;
		final Integer imageSelected = image;
		final Button gameButton = button;
		flipped = flippedOrNot;
		
		gameButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// When stop is clicked, show start again and hide stop
				if (flipped) {
					gameButton.setBackgroundResource(R.drawable.empty);
					flipped = false;
				} else {
					gameButton.setBackgroundResource(randomizedThumbs[imageSelected]);
					flipped = true;
				}
			}
		});
	}
	
	public void setFlipped (boolean flip) {
		flipped = flip;
	}
}
