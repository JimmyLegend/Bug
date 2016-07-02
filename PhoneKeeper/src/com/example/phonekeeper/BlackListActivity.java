package com.example.phonekeeper;

import java.util.List;

import edu.sdut.phonekeeper.db.dao.BlackNumberDao;
import edu.sdut.phonekeeper.domain.BlackNumInfo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class BlackListActivity extends Activity {

	private ListView lvBlackList;
	private Button btnAddBlack;
	private List<BlackNumInfo> arrBlack;
	private BlackNumberDao blackDao;
	private BlackAdapter blackAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_black_list);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.black_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	class BlackAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return arrBlack.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return arrBlack.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			BlackNumInfo blackNum=(BlackNumInfo) getItem(arg0);
			TextView tvBlackNum=null;
			if(arg1==null){
				arg1=View.inflate(BlackListActivity.this,R.layout.item_blacknum,null);
				tvBlackNum=(TextView) arg1.findViewById(R.id.tv_blacknum);
				arg1.setTag(tvBlackNum);
			}
			else{
				tvBlackNum=(TextView) arg1.getTag();
			}
			tvBlackNum.setText(blackNum.getNum());
			return arg1;
		}
		
	}
}
