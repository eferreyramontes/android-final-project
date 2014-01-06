package com.blackfox.proyectofinal;

import com.example.proyectofinal.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MyCourses extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_courses);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.final_project_menu, menu);
		return true;
	}

}
