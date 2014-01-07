package com.blackfox.proyectofinal.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.blackfox.proyectofinal.entities.Course;
import com.google.gson.Gson;

import android.util.Log;

	
public class Backend
{
	private static Backend instance;
	
	public static Backend getInstance()
	{
		return obtainInstance();
	}	
	
	private static synchronized Backend obtainInstance()
	{
		if(instance == null)
		{
			instance = new Backend();
		}
		return instance;
	}
	
	public InputStreamReader getFromServer()
	{	
		HttpResponse httpResponse;
		
		InputStreamReader response = null;
			
		HttpClient httpclient = new DefaultHttpClient();  
		
        try 
        {  
        	//  TODO: Change it for a property saved in a properties file
        	httpResponse = httpclient.execute(new HttpGet("http://maps.googleapis.com/maps/api/directions/json?origin=Toronto&destination=Montreal&sensor=false"));
            
            response = new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8");
        } 
        catch (ClientProtocolException e) 
        {  
            e.printStackTrace();  
        } 
        catch (IOException e) 
        {  
            e.printStackTrace();  
        }  
        
        return response;
	}
	
	public InputStreamReader callWebService(HttpRequest request, StringEntity params)
	{	
		HttpResponse httpResponse;
		
		InputStreamReader response = null;
			
		HttpClient httpclient = new DefaultHttpClient();  
		
        request.setHeader("Accept", "application/json");
        
        request.setHeader("Content-type", "application/json");     

        request.getParams().setParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE,Boolean.FALSE);
        
        if(params != null)
        {
        	((HttpEntityEnclosingRequestBase) request).setEntity(params);
        }
        
        try 
        {  
        	httpResponse = httpclient.execute((HttpUriRequest) request);
            
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            
            response = new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8");
        } 
        catch (ClientProtocolException e) 
        {  
            e.printStackTrace();  
        } 
        catch (IOException e) 
        {  
            e.printStackTrace();  
        }  
        
        return response;
	}
	
	public void getCursos()
	{
		InputStreamReader response = getFromServer();
		if(response != null)
		{	
			try 
			{
				//System.out.println(getStringFromInputStream(response));
				JSONArray array = new JSONArray(new JSONTokener(getStringFromInputStream(response)));
				
				for (int i = 0; i < array.length(); i++) 
				{
					JSONObject obj = (JSONObject) array.get(i);
					System.out.println(obj);
				}
			} 
			catch (JSONException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public List<Course> getCursosWithGSON()
	{
		InputStreamReader response = getFromServer();
		if(response != null)
		{
			Gson gson = new Gson();
			Course[] courses = gson.fromJson(response, Course[].class);
			
			for (Course course : courses) {
				Log.d("NOMBRE", course.getName());
			}
			return Arrays.asList(courses);
		}
		return new ArrayList<Course>();
	}
	
	
	public static String getStringFromInputStream(InputStreamReader isr) 
	{
	    BufferedReader reader = new BufferedReader(isr);
	    StringBuilder sb = new StringBuilder();
	    String line = null;
	    
	    try 
	    {
			while ((line = reader.readLine()) != null) 
			{
			  sb.append(line + "\n");
			}
			isr.close();
		} 
	    catch (IOException e) 
	    {		
			e.printStackTrace();
		}
	    return sb.toString();
	}
}
