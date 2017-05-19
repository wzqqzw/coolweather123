package com.example.wzq.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private String[]  city0={"滁州","合肥","芜湖","马鞍山","蚌埠"};
    private String[] city17={"wu"};
    private  String[] data2={"来安县","全椒县","定远县","明光县","天长县"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String p=getIntent().getStringExtra("p");
        String[] data=null;
        if("安徽".equals(p)){
            data=city0;
        }else{
            data=city17;
        }
        TextView tv=(TextView) findViewById(R.id.textView);
        tv.setText(p);
        ListView listView = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String>adapter=
                new ArrayAdapter<String>(Main2Activity.this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);

    }
}
