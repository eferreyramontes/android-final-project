package com.blackfox.proyectofinal.backend;

import java.util.ArrayList;
import java.util.List;

import com.blackfox.proyectofinal.entities.Course;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{

	private final static String DATABASE_NAME_COURSES_TABLE = "Course";
    private final static String DATABASE_CREATE_STATEMENT = "CREATE TABLE "+ DATABASE_NAME_COURSES_TABLE +"(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, description TEXT, enrolled INTEGER, image TEXT)";
    private final static String DATABASE_NAME = "FinalProject";
    private final static String DATABASE_DROP_STATEMENT = "DROP TABLE IF EXISTS " + DATABASE_NAME;    
    private Context context;
    private static DatabaseHelper databaseInstance;
	
    /**
     * Get the unique instance
     * @param context
     * @return
     */
    public static DatabaseHelper getDatabaseInstance(Context context)
    {
    	if(databaseInstance == null)
    	{
    		databaseInstance = new DatabaseHelper(context.getApplicationContext());
    	}
    	return databaseInstance;
    }
    
    /**
     * Constructor of defect
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    private DatabaseHelper(Context context, String name, CursorFactory factory, int version) 
    {
        super(context, name, factory, version);      
        this.context = context;
    }
    
    /**
     * Constructor that uses only context
     * @param context
     */
    private DatabaseHelper(Context context)
    {
    	super(context, DATABASE_NAME, null, 1);    	
    }
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE_STATEMENT);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DATABASE_DROP_STATEMENT); 
        db.execSQL(DATABASE_CREATE_STATEMENT);
	}
	
    public Boolean databaseExists()
    {
    	if(SQLiteDatabase.openDatabase(context.getDatabasePath(DATABASE_NAME).getPath(), null, 0) != null)
    	{
    		this.close();
    		return true;
    	}
    	return false;    			
    }
    
    /**
     * Function to insert courses into the database based on a List of courses
     * @param courses
     */
    public void insertCourses(List<Course> courses)
    {
    	if(courses == null){
    		Log.w("INSERT_COURSES", "The list of courses is null");
    		return;
    	}
    	for(Course course : courses)
    	{
    		ContentValues values = new ContentValues();
    		values.put("name", course.getName());
    		values.put("description", course.getDescription());
    		values.put("enrolled", course.getEnrolled());
    		values.put("image", course.getImage());
    		getWritableDatabase().insert(DATABASE_NAME_COURSES_TABLE,null, values);
    	}
    }
    
    /**
     * Function to get the list of courses contained into the database
     * @return a list of courses
     */
    public List<Course> readCourses(){
    	Cursor cursor = getReadableDatabase().query(DATABASE_NAME_COURSES_TABLE, null, null, null, null, null, null);
    	if(cursor == null){
    		Log.w("READ_COURSES", "The cursor is null");
    		return new ArrayList<Course>();
    	}
    	ArrayList<Course> courses = new ArrayList<Course>();
    	while(cursor.moveToNext()){
    		Course course = new Course();
    		course.setName(cursor.getString(cursor.getColumnIndex("name")));
    		course.setDescription(cursor.getString(cursor.getColumnIndex("description")));
    		course.setEnrolled(cursor.getInt(cursor.getColumnIndex("enrrolled")));
    		course.setImage(cursor.getString(cursor.getColumnIndex("image")));
    		
    		courses.add(course);
    	}
    	return courses;
    }

}
