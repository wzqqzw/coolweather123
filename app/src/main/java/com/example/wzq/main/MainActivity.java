package com.example.wzq.main;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private String[] provinces = new String[]{"安徽", "江苏", "浙江", "上海", "北京",
            "天津", "云南", "河北", "河南", "吉林",
            "辽林", "海南", "湖北", "湖南"};
    private String[] city01 = new String[]{"安徽"};
    private String[] city17 = new String[]{"滁州", "合肥", "芜湖", "马鞍山", "蚌埠"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button=(Button) findViewById(R.id.button);
        final Button button2=(Button) findViewById(R.id.button2);


  //      button.setVisibility(View.GONE);

        ArrayAdapter adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1, provinces);

        final ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, MainActivity.this.provinces[position], Toast.LENGTH_LONG).show();
//                ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,MainActivity.this.city17);
//                listView.setAdapter(adapter);
//            }
//        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                button.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                if("北京".equals(MainActivity.this.provinces[position])){
                    ArrayAdapter adapter=
                            new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,city01);
                    listView.setAdapter(adapter);
                }else {
                    ArrayAdapter adapter=
                            new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,city17);
                    listView.setAdapter(adapter);
                }
//                    Intent intent = new Intent();
//                    intent.setClass(MainActivity.this, Main2Activity.class);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter adapter=
                        new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,provinces);
                listView.setAdapter(adapter);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://baidu.com"));
                startActivity(intent);
            }
        });
    }
}

