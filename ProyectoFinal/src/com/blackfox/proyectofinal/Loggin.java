package com.blackfox.proyectofinal;

import com.example.proyectofinal.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Loggin extends MenuListedActivity {

	static final int NEW_USER_DIALOG = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loggin);
		
		OnClickListener onClick = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(Loggin.this, "Logged", Toast.LENGTH_SHORT).show();
				
				EditText username = (EditText)findViewById(R.id.username);
				EditText password = (EditText)findViewById(R.id.password);
				
				Intent i = new Intent(Loggin.this,CoursesList.class);
				startActivity(i);
				
			}
		};
		
		Button button1 = (Button)this.findViewById(R.id.logginButton);
		button1.setOnClickListener(onClick);
		
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return false;
	}
	
	public void clickCreateUserButton(View view){
		showDialog(NEW_USER_DIALOG);
	}

	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {
		
		Dialog returnedDialog = null;
		switch(id){
		case NEW_USER_DIALOG:
			
			final Dialog dialog =  new Dialog(this);
			dialog.setContentView(R.layout.new_user_layout);
			dialog.setTitle("Nuevo Usuario");
			
			Button cancelButton = (Button)dialog.findViewById(R.id.cancelButton);
			cancelButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					dismissDialog(NEW_USER_DIALOG);
					
				}
			});
			
			Button createButton = (Button) dialog.findViewById(R.id.createButton);
			createButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					String name = ((EditText)dialog.findViewById(R.id.new_user_name)).getText().toString();
					String username = ((EditText)dialog.findViewById(R.id.new_user_username)).getText().toString();
					String password = ((EditText)dialog.findViewById(R.id.new_user_password)).getText().toString();
					String passwordCheck = ((EditText)dialog.findViewById(R.id.new_user_password_again)).getText().toString();

					// Checking if everything is OK!
					String msj = "";
					if(!password.equals("")){
						// highlight password and passwordCheck field in red
						msj += "Debe ingresar una contraseña\n";
					}
					if(!password.equals(passwordCheck)){
						// highlight password and passwordCheck field in red
						msj += "La contraseña no coincide\n";
					}
					if(!checkIfExists(username)){
						msj += "El nombre de usuario no está disponible\n";
					}
					if(!msj.equals("")){
						Toast.makeText(Loggin.this, msj, Toast.LENGTH_SHORT).show();
					}else{
						// Complete the new user transaction
						createNewUser(name,username,password);
					}
				}
			});
			returnedDialog = dialog;
			break;
		}
		return returnedDialog;
	}
	
	private boolean checkIfExists(String username){
		// TODO: Check in DB if the username already exists
		return true;
	}
	
	private void createNewUser(String name, String username,
			String password) {
		// TODO Insert new user into DB
	}
}
