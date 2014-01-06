package com.blackfox.proyectofinal;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Launcher extends MenuListedActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO DO SOMETHING!!!
				Intent intent = new Intent(Launcher.this, Loggin.class);
				startActivity(intent);
			}
		}, 5000);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return false;
	}
}
