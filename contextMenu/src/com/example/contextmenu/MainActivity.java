package com.example.contextmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;
import android.widget.AdapterView.AdapterContextMenuInfo;

public class MainActivity extends Activity {

	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) this.findViewById(R.id.tv);
		this.registerForContextMenu(tv);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("�����ɶ��");
		menu.setHeaderIcon(R.drawable.a4c);
		menu.add(0, 0, Menu.NONE, "����");
		menu.add(0, 1, Menu.NONE, "����");
		menu.add(0, 2, Menu.NONE, "������");
		menu.add(1, 3, Menu.NONE, "ȥ�µ�Activity");
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 0:
			tv.setText(item.getTitle().toString());
			break;
		case 1:
			tv.setText(item.getTitle().toString());
			break;
		case 2:
			tv.setText(item.getTitle().toString());
			break;
		case 3:
			tv.setText(item.getTitle().toString());
			startActivity(new Intent(this, SecondActivity.class));
			break;
		default:
			return super.onContextItemSelected(item);
		}
		return true;
	}
}
