/**
 * 
 */
package com.blackfox.proyectofinal.adapter;

import java.util.List;

import com.blackfox.proyectofinal.entities.Course;
import com.example.proyectofinal.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @author Emmanuel
 *
 */
public class RowAdapter extends BaseAdapter {
	
	private List<Course> courses = null;
	private Context context;
	private LayoutInflater inflater;
	
	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		return courses.size();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int id) {
		courses.get(id);
		return null;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int selectedId, View view, ViewGroup viewGroup) {
		View v = view;
		Course course = courses.get(selectedId);
		
		if(v == null)
		{

			ViewHolder holder = new ViewHolder();
			v = inflater.inflate(R.layout.row, null);
			holder.name = (TextView)v.findViewById(R.layout.row);
			v.setTag(holder);
		}
		
		ViewHolder holder = (ViewHolder)v.getTag();
		holder.name.setText(course.getName());
		holder.description.setText(course.getDescription());
		
		return v;
	}
	
	class ViewHolder
	{
		TextView name;
		TextView description;
	}

}
