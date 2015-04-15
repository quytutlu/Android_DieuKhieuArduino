package info.androidhive.slidingmenu;

import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ThongTinCaNhan extends Fragment {

	TextView tvMaTaiKhoan,tvTenDangNhap,tvEmail,tvSDT,tvNguoiTao,tvVaiTro;
	String MaTaiKhoan,TenDangNhap,Email,SDT,NguoiTao,VaiTro;
	String url;
	ProgressDialog dialog;
	public ThongTinCaNhan(String idNguoiDung) {
		url="http://192.99.66.193:1234/kltn_arduino/?cmd=laythongtinnguoidung&id="+idNguoiDung;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.thong_tin_ca_nhan,
				container, false);
		tvMaTaiKhoan=(TextView) rootView.findViewById(R.id.tvMaTaiKhoan);
		tvTenDangNhap=(TextView) rootView.findViewById(R.id.tvTenDangNhap);
		tvEmail=(TextView) rootView.findViewById(R.id.tvEmail);
		tvSDT=(TextView) rootView.findViewById(R.id.tvSDT);
		tvNguoiTao=(TextView) rootView.findViewById(R.id.tvNguoiTao);
		tvVaiTro=(TextView) rootView.findViewById(R.id.tvVaiTro);
		dialog=new ProgressDialog(getActivity());
		new ParseJSONTask().execute();
		return rootView;
	}
	private class ParseJSONTask extends AsyncTask<Void, Void, Boolean> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog.setMessage("Loading...");
			dialog.setCancelable(false);
			dialog.show();
		}

		@Override
		protected Boolean doInBackground(Void... params) {
			WebServiceHandler webServiceHandler = new WebServiceHandler();
			String jsonstr = webServiceHandler.getJSONData(url);
			try {
				JSONObject object=new JSONObject(jsonstr);
				MaTaiKhoan=object.getString("id");
				TenDangNhap=object.getString("TenDangNhap");
				Email=object.getString("Email");
				SDT=object.getString("SDT");
				NguoiTao=object.getString("NguoiTao");
				VaiTro=object.getString("VaiTro");
				return true;
			} catch (Exception e) {
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
			if(result==false){
				AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
				builder.setTitle("Lỗi!");
				builder.setMessage("Kiểm tra kết nối mạng");
				builder.show();
				return;
			}
			tvMaTaiKhoan.setText("Mã tài khoản: "+MaTaiKhoan);
			tvTenDangNhap.setText("Tên đăng nhập: "+TenDangNhap);
			tvEmail.setText("Email: "+Email);
			tvSDT.setText("SĐT: "+SDT);
			tvNguoiTao.setText("Người tạo: "+NguoiTao);
			tvVaiTro.setText("Vai trò: "+VaiTro);
		}
	}
}