package com.nukleap.schoolchap;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class ActivityCommon extends AppCompatActivity {
	
	protected Toolbar toolbar;
	protected Snackbar snack;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}
	
	protected void setMaterialDesign(){
		toolbar = (Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
	}
	
	protected void showDashboard(){
		Intent intent = new Intent(this,ActivityDashboard.class);
		startActivity(intent);
		finish();
	}
	
	protected void showIcon(){
		getSupportActionBar().setIcon(R.drawable.ic_launcher);
	}
	
	protected void setMaterialTitle(String text){
		getSupportActionBar().setTitle(text);
	}
	
	protected void setMatHeaderCentre(){
		//((LayoutParams)toolbar.getLayoutParams()).gravity = Gravity.CENTER_HORIZONTAL;
	}
	
	protected void setMaterialBackAsClose(){
		toolbar.setNavigationIcon(R.drawable.ic_action_remove);
	}
	
	protected void setMaterialElevation(){
		getSupportActionBar().setElevation(4.25f);
	}
	
	protected void setMatBack(){
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
	}
	
	protected void showMsg(String text){
		if(snack!=null){
			snack.dismiss();
		}
		if(snack==null){
		snack = Snackbar.make(getWindow().getDecorView().findViewById(android.R.id.content), 
         text,
         Snackbar.LENGTH_LONG);
		}
		snack.setText(text);
        snack.show(); 
	}
	
	protected void showMsgAction(String text){
		if(snack!=null){
			snack.dismiss();
		}
		if(snack==null){
			snack = Snackbar.make(getWindow().getDecorView().findViewById(android.R.id.content), 
	         text,
	         Snackbar.LENGTH_LONG);
		}
		snack.setAction(text, measureClick);
		snack.setText(text);
	    snack.show(); 
	}
	
	protected OnClickListener measureClick = new OnClickListener() {
		
		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			snackActioned();
		}
	};
	
	protected void snackActioned(){
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		
		super.onPause();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		
		super.onDestroy();
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			makeFinish();
			break;
		default:
			break;
		}
		return true;
	}
	
	protected void animate(View view,Techniques tech){
		YoYo.with(tech).duration(Constants.DEFAULT_ANIMATION).playOn(view);
	}
	
	public void makeFinish(){
		setResult(RESULT_CANCELED);
		finish();
	}
	
	public void allowFinish(){
		setResult(RESULT_OK);
		finish();
	}

}
