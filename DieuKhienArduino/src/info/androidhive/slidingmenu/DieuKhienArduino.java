package info.androidhive.slidingmenu;

import info.androidhive.slidingmenu.PullToRefreshListView.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Object.ArrThietBi;
import Object.ThietBi;
import android.app.AlertDialog;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class DieuKhienArduino extends Fragment{
	String url = "http://192.99.66.193:1234/Arduino/?cmd=laytrangthai";
	List<ArrThietBi> tb;
	PullToRefreshListView lv;
	HomeFragment adapter;
	public DieuKhienArduino() {
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.dieu_khien_arduino, container, false);
		if(!tb.isEmpty())
		{
			tb.clear();
		}
		new ParseJSONTask().execute();
		tb=new ArrayList<ArrThietBi>();
		lv=(info.androidhive.slidingmenu.PullToRefreshListView) rootView.findViewById(R.id.listrf);
		lv.setOnRefreshListener(new OnRefreshListener() {
			
			@Override
			public void onRefresh() {
				if(!tb.isEmpty())
				{
					tb.clear();
				}
				new ParseJSONTask().execute();
			}
		});
		adapter = new HomeFragment(getActivity(), R.layout.fragment_home, tb);
		lv.setAdapter(adapter);
        return rootView;
	}
	
	private class ParseJSONTask extends AsyncTask<Void, Void, Boolean> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected Boolean doInBackground(Void... params) {
			WebServiceHandler webServiceHandler = new WebServiceHandler();
			String jsonstr = webServiceHandler.getJSONData(url);
			if (jsonstr == null) {
				return false;
			}
			try {
				JSONObject object = new JSONObject(jsonstr);
				JSONArray array = object.getJSONArray("list");
				for (int i = 0; i < array.length(); i++) {
					JSONObject jsonObject = array.getJSONObject(i);
					ThietBi temp = new ThietBi();
					temp.TenThietBi = jsonObject.getString("TenThietBi");
					temp.TrangThai = jsonObject.getString("TrangThai");
					//tb.get(0).tb.add(temp);
				}
				return true;
			} catch (Exception e) {
				Toast.makeText(getActivity(), "Không kết nối được server",
						Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			}
			return false;
		}

		@Override
		protected void onPostExecute(Boolean result) {
			super.onPostExecute(result);
			if (result == false) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						getActivity());
				builder.setTitle("Lỗi!");
				builder.setMessage("Kiểm tra kết nối mạng");
				builder.show();
				return;
			}
			adapter.notifyDataSetChanged();
			lv.onRefreshComplete();
		}
	}
}