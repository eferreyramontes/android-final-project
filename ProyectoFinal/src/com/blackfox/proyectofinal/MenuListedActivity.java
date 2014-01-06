package com.blackfox.proyectofinal;

import com.example.proyectofinal.R;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuListedActivity extends Activity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = new MenuInflater(this);
		inflater.inflate(R.menu.final_project_menu, menu);
		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText(this, item.getTitle(),Toast.LENGTH_SHORT).show();
		
        switch (item.getItemId()) {
        
	        case R.id.cursos:
	        	Intent i = new Intent(MenuListedActivity.this,CoursesList.class);
				startActivity(i);
	            return true;
	
	        case R.id.mis_cursos:
	        	i = new Intent(MenuListedActivity.this,MyCourses.class);
				startActivity(i);
	            return true;
	            
	        case R.id.mapa:
	        	i = new Intent(MenuListedActivity.this,Map.class);
				startActivity(i);
	            return true;
	    }
	    
	    return false;
		
//		return super.onOptionsItemSelected(item);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onStop()
	 */
	@Override
	protected void onStop() {
		// TODO Implements finish here! EMMA
		super.onStop();
	}
	
	
	
	
	
}
