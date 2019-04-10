package com.dream71.android.anothertest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dream71.android.chart.IPieElement;
import com.dream71.android.chart.PieChartAnother;
import com.dream71.android.chart.TestEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        PieChartAnother pieChartAnother = (PieChartAnother) findViewById(R.id.another_one);


        TestEntity entity = new TestEntity(50, "#FF7F50", "断了的弦");
        TestEntity entity1 = new TestEntity(38, "#DC143C", "以父之名");
        TestEntity entity2 = new TestEntity(79, "#00008B", "青花瓷");
        TestEntity entity3 = new TestEntity(20, "#A9A9A9", "夜的第七章");
        TestEntity entity4 = new TestEntity(105, "#8B0000", "东风破");
        TestEntity entity5 = new TestEntity(53, "#9400D3", "稻香");
        TestEntity entity6 = new TestEntity(80, "#FFD700", "七里香");

        final List<IPieElement> list = new ArrayList<>();
        list.add(entity);
        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        list.add(entity4);
        list.add(entity5);
        list.add(entity6);
        pieChartAnother.setData(list);
        pieChartAnother.setTitleText("年终总结比例图");
        pieChartAnother.setAnimEnable(true);
        pieChartAnother.enableLegend(true);

        pieChartAnother.setOnItemClickListener(new PieChartAnother.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.e("pos", position + "");
                Toast.makeText(MainActivity.this, "position=" + position + "\n" + list.get(position).getValue(), Toast.LENGTH_LONG).show();
            }
        });
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
