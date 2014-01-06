package com.blackfox.proyectofinal;

import com.example.proyectofinal.R;

import android.view.Menu;
import android.view.MenuItem;

public class CoursesList extends MenuListedActivity {
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		MenuItem item = menu.findItem(R.id.cursos);
		
		item.setVisible(false);
		
		return super.onPrepareOptionsMenu(menu);
	}
}
