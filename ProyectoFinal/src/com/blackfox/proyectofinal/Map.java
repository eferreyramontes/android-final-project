package com.blackfox.proyectofinal;

import com.example.proyectofinal.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

public class Map extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem item = (MenuItem)menu.findItem(R.id.mapa);
		
		item.setEnabled(false);
		
		getMenuInflater().inflate(R.menu.final_project_menu, menu);
		return true;
	}

}
