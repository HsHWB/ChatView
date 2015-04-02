package com.example.chatlayout;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.adapter.ChatListAdapter;
import com.example.module.ChatModule;
import com.example.util.TimeUtil;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private ListView listView;
    private String chatTime;
    private int screenHeight = -1;
    private int screenWidth = -1;
    private DisplayMetrics displayMetrics;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    protected void initView(){

        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;

        listView = (ListView)this.findViewById(R.id.chat_listview);

    }

    protected void initData(){

        sharedPreferences = getSharedPreferences("Time", 0);
        chatTime  = (new TimeUtil(getApplicationContext())).getDate();
        sharedPreferences.edit().putString("lastTime", chatTime).commit();
        System.out.println("chatTime == "+sharedPreferences.getString("lastTime", null));

        ArrayList<ChatModule> moduleList = new ArrayList<ChatModule>();
        ChatModule chatModule1 = new ChatModule(getApplicationContext());
        chatModule1.setTypeId(0);
        chatModule1.setContent("我发出信息");
        moduleList.add(chatModule1);

        ChatModule chatModule2 = new ChatModule(getApplicationContext());
        chatModule2.setTypeId(1);
        chatModule2.setContent("别人发出信息321463431315616");
        moduleList.add(chatModule2);

        System.out.println("screenHeight  screenWidth == "+screenHeight+"         "+screenWidth);

        ChatListAdapter adapter = new ChatListAdapter(getApplicationContext(), screenHeight, screenWidth, moduleList);
        listView.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
