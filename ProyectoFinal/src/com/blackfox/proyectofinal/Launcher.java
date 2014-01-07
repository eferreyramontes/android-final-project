package com.blackfox.proyectofinal;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.blackfox.proyectofinal.backend.Backend;
import com.blackfox.proyectofinal.backend.DatabaseHelper;
import com.blackfox.proyectofinal.entities.Course;
import com.example.proyectofinal.R;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

public class Launcher extends MenuListedActivity {
	ProgressBar progress;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.launcher);
		
		progress = (ProgressBar)findViewById(R.id.progressBar1);
		
		new ProgressBarShow().execute();
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return false;
	}
	
	public class ProgressBarShow extends AsyncTask<Void, Void, Boolean> 
    {
        
        @Override
        protected Boolean doInBackground(Void... unused) 
        {
        	loadCourses();
//        	try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
            return null;
        }
        
        /* (non-Javadoc)
		 * @see android.os.AsyncTask#onProgressUpdate(Progress[])
		 */
		@Override
		protected void onProgressUpdate(Void... values) {
			
		}

		@Override
        protected void onPreExecute() 
        {
        	 progress.setVisibility(View.VISIBLE);
        }
        
        @Override
        protected void onPostExecute(Boolean bool) 
        {
        	 runOnUiThread(new Runnable() {
				public void run() {
					progress.setVisibility(View.GONE);
				}
			});
        	 
        	 System.out.println("done");
        }
        
        private void loadCourses()
        {
        	// Getting the list of courses from the JSON Service
        	List<Course> courses = Backend.getInstance().getCursosWithGSON();
        	// Putting it into the database
        	DatabaseHelper.getDatabaseInstance(getApplicationContext()).insertCourses(courses);
        }
    }
}
