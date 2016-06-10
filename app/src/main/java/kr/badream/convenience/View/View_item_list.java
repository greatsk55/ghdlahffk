package kr.badream.convenience.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import kr.badream.convenience.Adapter.Adapter_list_view;
import kr.badream.convenience.Adapter.Item_list_view;
import kr.badream.convenience.R;

/**
 * Created by Administrator on 2016-06-04.
 */
public class View_item_list extends AppCompatActivity {


    View drawerView;
    DrawerLayout dlDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        ListView listview;
        Adapter_list_view adapter;

        // Adapter 생성
        adapter = new Adapter_list_view();

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.item_list);
        listview.setAdapter(adapter);


        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.item1),
                "Good", "1000원");
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.item2),
                "Circle", "2000원");
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.item1),
                "XXX", "3000원");


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                Item_list_view item = (Item_list_view) parent.getItemAtPosition(position);

                String titleStr = item.getItem_name();
                String descStr = item.getItem_price();

                Log.e("abc", "abc" + titleStr + descStr);


                // TODO : use item data.

                Intent ctgview_intent = new Intent(getApplicationContext(), Activity_ctgView.class);
                startActivity(ctgview_intent);
            }
        });

        setCustomActionbar();
    }

    private void setCustomActionbar() {

        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        //set custom view layout
        View mCustomView = LayoutInflater.from(this).inflate(R.layout.actionbar_main, null);
        actionBar.setCustomView(mCustomView);

        // set no padding both side
        Toolbar parent = (Toolbar) mCustomView.getParent();
        parent.setContentInsetsAbsolute(0, 0);

        // set actionbar backgroung image
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.activity_main_background));

        //set actionbar layout layoutparams
//        ActionBar.LayoutParams params = new ActionBar.LayoutParams((ActionBar.LayoutParams.MATCH_PARENT));
//        actionBar.setCustomView(mCustomView, params);


        // setNavigation--------------------------------------------------

        // navigation 으로 동작할 화면
        drawerView = (View) findViewById(R.id.drawer);

        // Drawer layout
        dlDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        //actionbar에서 내비 제어할 버튼
        ImageButton btn_menu = (ImageButton) mCustomView.findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dlDrawer.openDrawer(drawerView);
            }
        });


    }
}