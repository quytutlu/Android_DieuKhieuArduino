package info.androidhive.slidingmenu;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class PhotosFragment extends Fragment {
	Button btnTat1,btnBat1,btnTat2,btnBat2;
	ProgressDialog dialog;
	String url="";
	public PhotosFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_photos, container, false);

        btnTat1=(Button) rootView.findViewById(R.id.btnTat1);
        btnBat1=(Button) rootView.findViewById(R.id.btnBat1);
        btnTat2=(Button) rootView.findViewById(R.id.btnTat2);
        btnBat2=(Button) rootView.findViewById(R.id.btnBat2);
        dialog=new ProgressDialog(getActivity());
        btnTat1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				try {
//					MainActivity.outStream.write("D_off1p".getBytes());
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
				url="http://192.99.66.193:2012/Arduino.ashx?cmd=tatbongden";
				new ParseJSONTask().execute();
			}
		});
        btnBat1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				try {
//					MainActivity.outStream.write("D_on1p".getBytes());
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				url="http://192.99.66.193:2012/Arduino.ashx?cmd=batbongden";
				new ParseJSONTask().execute();
			}
		});
        btnTat2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/*try {
					MainActivity.outStream.write("D_off2p".getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}*/
			}
		});
        btnBat2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/*try {
					MainActivity.outStream.write("D_on2p".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		});
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
			if(jsonstr==null){
				return false;
			}
			try {
				
				return true;
			} catch (Exception e) {
				Toast.makeText(getActivity(),
						"Không kết nối được server", Toast.LENGTH_SHORT).show();
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
		}
	}
}
