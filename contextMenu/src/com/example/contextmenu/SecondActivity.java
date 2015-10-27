package com.example.contextmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.AdapterContextMenuInfo;

public class SecondActivity extends Activity {

	private ListView lv;
	private String[] menuStrs;
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		lv = (ListView) this.findViewById(R.id.lv);
		initListView();
		this.registerForContextMenu(lv);
	}

	private void initListView() {
		menuStrs = new String[] { "�������괺", "���Ӿ����ذ��꿤", "Խ����", "��ͨ�˺�" };
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, menuStrs);
		lv.setAdapter(adapter);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("�����ɶ��");
		menu.setHeaderIcon(R.drawable.a4c);
		menu.add(0, 0, Menu.NONE, "��");
		menu.add(0, 1, Menu.NONE, "��");
		menu.add(0, 2, Menu.NONE, "¥");
		menu.add(1, 3, Menu.NONE, "��");
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo menuInfo = (AdapterContextMenuInfo) item
				.getMenuInfo();
		switch (item.getItemId()) {
		case 0:
			menuStrs[menuInfo.position] += "��";
			break;
		case 1:
			menuStrs[menuInfo.position] += "��";
			break;
		case 2:
			menuStrs[menuInfo.position] += "¥";
			break;
		case 3:
			menuStrs[menuInfo.position] += "��";
			break;
		default:
			return super.onContextItemSelected(item);
		}
		adapter.notifyDataSetChanged();
		return true;
	}
}
