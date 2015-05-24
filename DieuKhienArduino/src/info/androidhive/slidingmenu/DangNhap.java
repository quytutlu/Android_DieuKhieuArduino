package info.androidhive.slidingmenu;

import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DangNhap extends Activity {
	ProgressDialog dialog;
	EditText TenDangNhap, MatKhau;
	String url = "";
	String id = "";
	String Active = "";
	String VaiTro="";
	String Email="";
	String SDT="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dangnhap);
		Init();
	}

	private void Init() {
		dialog = new ProgressDialog(this);
		TenDangNhap = (EditText) findViewById(R.id.editTextTenDangNhap);
		MatKhau = (EditText) findViewById(R.id.editTextMatKhau);
	}

	public void Onclick(View v) {
		switch (v.getId()) {
		case R.id.buttonDangNhap:
			url = "http://92.222.72.172/index.php?cmd=dangnhap&tendangnhap="
					+ TenDangNhap.getText();
			url += "&matkhau=" + MatKhau.getText();
			new ParseJSONTask().execute();
			break;
		}
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
			if (jsonstr == null) {
				return false;
			}
			try {
				JSONObject object = new JSONObject(jsonstr);
				Active = object.getString("active");
				id = object.getString("id");
				VaiTro=object.getString("VaiTro");
				Email=object.getString("Email");
				SDT=object.getString("SDT");
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
			if (result == false) {
				Toast.makeText(DangNhap.this, id, Toast.LENGTH_LONG).show();
				AlertDialog.Builder builder = new AlertDialog.Builder(
						DangNhap.this);
				builder.setTitle("Lỗi!");
				builder.setMessage("Kiểm tra kết nối mạng");
				builder.show();
				return;
			}
			if (!id.equals("-1")) {
				if (!Active.equals("1")) {
					Toast.makeText(DangNhap.this, "Tài khoản đã hết hạn!",
							Toast.LENGTH_LONG).show();
				} else {
					// Toast.makeText(DangNhap.this, "Thành công"+id,
					// Toast.LENGTH_SHORT).show();
					Intent t = new Intent(DangNhap.this, MainActivity.class);
					t.putExtra("idNguoiDung", id);
					startActivity(t);
				}

			} else {
				Toast.makeText(DangNhap.this, "Đăng nhập thất bại",
						Toast.LENGTH_SHORT).show();
			}
		}
	}
}
