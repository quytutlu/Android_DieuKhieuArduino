package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FindPeopleFragment extends Fragment {

	Button btnonoff,btnmute,btn1,btn2,btn3,btnaudio,btn4,btn5,btn6,btntvra,btn7,btn8,btn9,btn0;
	Button btnmenu,btnexit,btnchc,btnvolc,btncht,btnvolt,btnok;
	public FindPeopleFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_find_people,
				container, false);
		Init(rootView);
		LangNgheSuKien();
		return rootView;
	}

	private void LangNgheSuKien() {
		btnonoff.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btnmute.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btn3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btn4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btn5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btn6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btn7.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btn8.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btn9.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btn0.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btnaudio.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btntvra.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btnmenu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btnexit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btnchc.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btnvolc.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btncht.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btnvolt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		btnok.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			}
		});
	}

	private void Init(View rootView) {
		btnonoff=(Button) rootView.findViewById(R.id.btnonoff);
		btnmute=(Button) rootView.findViewById(R.id.btnmute);
		btn1=(Button) rootView.findViewById(R.id.btn1);
		btn2=(Button) rootView.findViewById(R.id.btn2);
		btn3=(Button) rootView.findViewById(R.id.btn3);
		btn4=(Button) rootView.findViewById(R.id.btn4);
		btn5=(Button) rootView.findViewById(R.id.btn5);
		btn6=(Button) rootView.findViewById(R.id.btn6);
		btn7=(Button) rootView.findViewById(R.id.btn7);
		btn8=(Button) rootView.findViewById(R.id.btn8);
		btn9=(Button) rootView.findViewById(R.id.btn9);
		btn0=(Button) rootView.findViewById(R.id.btn0);
		btnaudio=(Button) rootView.findViewById(R.id.btnaudio);
		btntvra=(Button) rootView.findViewById(R.id.btntvra);
		btnmenu=(Button) rootView.findViewById(R.id.btnmenu);
		btnexit=(Button) rootView.findViewById(R.id.btnexit);
		btnchc=(Button) rootView.findViewById(R.id.btnchc);
		btnvolc=(Button) rootView.findViewById(R.id.btnvolc);
		btncht=(Button) rootView.findViewById(R.id.btncht);
		btnvolt=(Button) rootView.findViewById(R.id.btnvolt);
		btnok=(Button) rootView.findViewById(R.id.btnok);
	}
}