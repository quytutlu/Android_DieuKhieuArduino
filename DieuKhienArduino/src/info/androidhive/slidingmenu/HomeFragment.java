package info.androidhive.slidingmenu;

import java.util.ArrayList;
import java.util.List;

import Object.ThietBi;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ViewHolder") public class HomeFragment extends ArrayAdapter<ThietBi> {

	Switch DenComPac, DenTuypDai, QuatDien1, QuatDien2, Tivi;
	Vibrator vibrator;
	TextView NhietDo, textViewCoNguoi, textViewDenComPac, textViewDenTuypDai,
			textViewQuatDien1, textViewQuatDien2, textViewTivi;
	ImageView home;
	CheckBox CoNguoi;
	ProgressDialog dialog;
	String nd = "", dcp = "", dtd = "", qd1 = "", qd2 = "", tv = "", cn = "",url;
	List<ThietBi> tb;
	String lableBatTat;
	boolean flag;
	
	private Context context;
	@SuppressWarnings("unused")
	private int layoutId;
	public HomeFragment(Context context, int layoutId,List<ThietBi> ThietBi) {
		super(context, layoutId,ThietBi);
		tb = new ArrayList<ThietBi>();
		this.context = context;
		this.layoutId = layoutId;
		this.tb = ThietBi;
		dialog = new ProgressDialog(getContext());
		vibrator = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
	}
	@Override
	public int getCount() {
		return 1;
	}
	@SuppressLint("InflateParams") @Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if(position!=0)
		{
			View tempView = inflater.inflate(android.R.layout.simple_expandable_list_item_1, null);
			tempView.setEnabled(false);
			return tempView;
		}
		View rowView = inflater.inflate(R.layout.fragment_home, parent, false);
		DenComPac = (Switch) rowView.findViewById(R.id.switchDenComPac);
		DenTuypDai = (Switch) rowView.findViewById(R.id.switchDenTuypDai);
		QuatDien1 = (Switch) rowView.findViewById(R.id.switchQuatDien1);
		QuatDien2 = (Switch) rowView.findViewById(R.id.switchQuatDien2);
		Tivi = (Switch) rowView.findViewById(R.id.switchTivi);
		NhietDo = (TextView) rowView.findViewById(R.id.textViewNhietDo);
		CoNguoi = (CheckBox) rowView.findViewById(R.id.checkBoxCoNguoi);
		textViewCoNguoi=(TextView) rowView.findViewById(R.id.textViewCoNguoi);
		textViewDenComPac=(TextView) rowView.findViewById(R.id.textViewDenComPac);
		textViewDenTuypDai=(TextView) rowView.findViewById(R.id.textViewDenTuypDai);
		textViewQuatDien1=(TextView) rowView.findViewById(R.id.textViewQuatDien1);
		textViewQuatDien2=(TextView) rowView.findViewById(R.id.textViewQuatDien2);
		textViewTivi=(TextView) rowView.findViewById(R.id.textViewTivi);
		home=(ImageView) rowView.findViewById(R.id.imageView1);
		WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		@SuppressWarnings("deprecation")
		int h=windowManager.getDefaultDisplay().getHeight();
		rowView.setMinimumHeight(h-150);
		DenComPac.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (textViewDenComPac.getText().equals("true")) {
					textViewDenComPac.setText("false");
					url = "http://192.99.66.193:1234/Arduino/?cmd=tatthietbi&tenthietbi=dencompac";
					lableBatTat = "Tắt đèn compact...";
				} else {
					textViewDenComPac.setText("true");
					url = "http://192.99.66.193:1234/Arduino/?cmd=batthietbi&tenthietbi=dencompac";
					lableBatTat = "Bật đèn compact...";
				}
				vibrator.vibrate(100);
				new ParseJSONTaskBatTat().execute();
			}
		});
		DenTuypDai.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (textViewDenTuypDai.getText().equals("true")) {
					textViewDenTuypDai.setText("false");
					url = "http://192.99.66.193:1234/Arduino/?cmd=tatthietbi&tenthietbi=dentuypdai";
					lableBatTat = "Tắt đèn tuýp dài...";
				} else {
					textViewDenTuypDai.setText("true");
					url = "http://192.99.66.193:1234/Arduino/?cmd=batthietbi&tenthietbi=dentuypdai";
					lableBatTat = "Bật đèn tuýp dài...";
				}
				vibrator.vibrate(100);
				new ParseJSONTaskBatTat().execute();
			}
		});
		QuatDien1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (textViewQuatDien1.getText().equals("true")) {
					textViewQuatDien1.setText("false");
					url = "http://192.99.66.193:1234/Arduino/?cmd=tatthietbi&tenthietbi=quatdien1";
					lableBatTat = "Tắt quạt điện 1...";
				} else {
					textViewQuatDien1.setText("true");
					url = "http://192.99.66.193:1234/Arduino/?cmd=batthietbi&tenthietbi=quatdien1";
					lableBatTat = "Bật quạt điện 1...";
				}
				vibrator.vibrate(100);
				new ParseJSONTaskBatTat().execute();
			}
		});
		QuatDien2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (textViewQuatDien2.getText().equals("true")) {
					textViewQuatDien2.setText("false");
					url = "http://192.99.66.193:1234/Arduino/?cmd=tatthietbi&tenthietbi=quatdien2";
					lableBatTat = "Tắt quạt điện 2...";
				} else {
					textViewQuatDien2.setText("true");
					url = "http://192.99.66.193:1234/Arduino/?cmd=batthietbi&tenthietbi=quatdien2";
					lableBatTat = "Bật quạt điện 2...";
				}
				vibrator.vibrate(100);
				new ParseJSONTaskBatTat().execute();
			}
		});
		Tivi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (textViewTivi.getText().equals("true")) {
					textViewTivi.setText("false");
					url = "http://192.99.66.193:1234/Arduino/?cmd=tatthietbi&tenthietbi=tivi";
					lableBatTat = "Tắt đèn tivi...";
				} else {
					textViewTivi.setText("true");
					url = "http://192.99.66.193:1234/Arduino/?cmd=batthietbi&tenthietbi=tivi";
					lableBatTat = "Bật đèn tivi...";
				}
				vibrator.vibrate(100);
				new ParseJSONTaskBatTat().execute();
			}
		});
		CoNguoi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (textViewCoNguoi.getText().equals("true")) {
					textViewCoNguoi.setText("false");
					url = "http://192.99.66.193:1234/Arduino/?cmd=rangoai";
					lableBatTat = "Ra ngoài...";
					DenComPac.setChecked(false);
					DenTuypDai.setChecked(false);
					QuatDien1.setChecked(false);
					QuatDien2.setChecked(false);
					Tivi.setChecked(false);
					textViewDenComPac.setText("false");
					textViewDenTuypDai.setText("false");
					textViewQuatDien1.setText("false");
					textViewQuatDien2.setText("false");
					textViewTivi.setText("false");
				} else {
					textViewCoNguoi.setText("true");
					url = "http://192.99.66.193:1234/Arduino/?cmd=batthietbi&tenthietbi=conguoionha";
					lableBatTat = "Đang kích hoạt...";
				}
				vibrator.vibrate(100);
				new ParseJSONTaskBatTat().execute();
			}
		});
		for (int i = 0; i < tb.size(); i++) {
			String TenThietBi = tb.get(i).TenThietBi;
			if (TenThietBi.compareTo("NhietDo") == 0) {
				nd = tb.get(i).TrangThai;
			}
			if (TenThietBi.compareTo("CoNguoiONha") == 0) {
				cn = tb.get(i).TrangThai;
			}
			if (TenThietBi.compareTo("DenComPac") == 0) {
				dcp = tb.get(i).TrangThai;
			}
			if (TenThietBi.compareTo("DenTuypDai") == 0) {
				dtd = tb.get(i).TrangThai;
			}
			if (TenThietBi.compareTo("QuatDien1") == 0) {
				qd1 = tb.get(i).TrangThai;
			}
			if (TenThietBi.compareTo("QuatDien2") == 0) {
				qd2 = tb.get(i).TrangThai;
			}
			if (TenThietBi.compareTo("Tivi") == 0) {
				tv = tb.get(i).TrangThai;
			}
		}
		NhietDo.setText(nd);
		if (cn.compareTo("1") == 0) {
			CoNguoi.setChecked(true);
			textViewCoNguoi.setText("true");
		} else {
			CoNguoi.setChecked(false);
			textViewCoNguoi.setText("false");
		}
		if (dcp.compareTo("dcp1") == 0) {
			DenComPac.setChecked(true);
			textViewDenComPac.setText("true");
		} else {
			DenComPac.setChecked(false);
			textViewDenComPac.setText("false");
		}
		if (dtd.compareTo("dtd1") == 0) {
			DenTuypDai.setChecked(true);
			textViewDenTuypDai.setText("true");
		} else {
			DenTuypDai.setChecked(false);
			textViewDenTuypDai.setText("false");
		}
		if (qd1.compareTo("qd11") == 0) {
			QuatDien1.setChecked(true);
			textViewQuatDien1.setText("true");
		} else {
			QuatDien1.setChecked(false);
			textViewQuatDien1.setText("false");
		}
		if (qd2.compareTo("qd21") == 0) {
			QuatDien2.setChecked(true);
			textViewQuatDien2.setText("true");
		} else {
			QuatDien2.setChecked(false);
			textViewQuatDien2.setText("false");
		}
		if (tv.compareTo("tv1") == 0) {
			Tivi.setChecked(true);
			textViewTivi.setText("true");
		} else {
			Tivi.setChecked(false);
			textViewTivi.setText("false");
		}
		return rowView;
	}
	
	private class ParseJSONTaskBatTat extends AsyncTask<Void, Void, Boolean> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog.setMessage(lableBatTat);
			// dialog.setCancelable(false);
			dialog.show();
		}

		@Override
		protected Boolean doInBackground(Void... params) {
			WebServiceHandler webServiceHandler = new WebServiceHandler();
			String jsonstr = webServiceHandler.getJSONData(url);
			if (jsonstr == null) {
				return false;
			}
			try {

				return true;
			} catch (Exception e) {
				Toast.makeText(getContext(), "Không kết nối được server",
						Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			}
			return false;
		}

		@Override
		protected void onPostExecute(Boolean result) {
			super.onPostExecute(result);
			if (dialog.isShowing()) {
				dialog.dismiss();
			}
			if (result == false) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						getContext());
				builder.setTitle("Lỗi!");
				builder.setMessage("Kiểm tra kết nối mạng");
				builder.show();
				return;
			}
		}
	}
}
