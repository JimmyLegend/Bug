package com.example.phonekeeper;

import java.util.List;

import com.example.phonekeeper.AppManageActivity.ViewHolder;

import edu.sdut.phonekeeper.db.dao.SMSFilterDao;
import edu.sdut.phonekeeper.domain.SMSInfo;

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

public class FilterActivity extends Activity {

	private Button btnBlackList;
	private ListView lvSMSFilter;
	private List<SMSInfo> arrSMS;
	private SMSFilterDao smsFilterDao;
	private SMSAdapter smsAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_filter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.filter, menu);
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
	class SMSAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return arrSMS.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return arrSMS.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			SMSInfo sms=(SMSInfo) getItem(position);
			ViewHolder viewHolder=null;
			if(convertView==null){
				convertView=View.inflate(FilterActivity.this,R.layout.item_smsfilter, null);
				viewHolder=new ViewHolder();
				viewHolder.tvNum=(TextView) convertView.findViewById(R.id.tv_num);
				viewHolder.tvTime=(TextView) convertView.findViewById(R.id.tv_time);
				viewHolder.tvContext=(TextView) convertView.findViewById(R.id.tv_context);
				convertView.setTag(viewHolder);
			}
			else{
				viewHolder=(ViewHolder) convertView.getTag();
			}
			viewHolder.tvContext.setText(sms.getContext());
			viewHolder.tvNum.setText(sms.getNum());
			viewHolder.tvTime.setText(sms.getTimeString());
			return convertView;
		}
		
	}
	class ViewHolder {
		TextView tvNum;
		TextView tvTime;
		TextView tvContext;
	}
}
