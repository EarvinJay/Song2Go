package com.itproject.android.song2go.Activities;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.itproject.android.song2go.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    String[] Items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView) findViewById(R.id.listView);

        final ArrayList<File> myVids = findVids(Environment.getExternalStorageDirectory());
        Items=new String[myVids.size()];

        for(int i=0 ; i < myVids.size() ; i++)
        {

            Items[i]=myVids.get(i).getName().toString().replace(".mp4","").replace("KAR","").replace(".mid","").replace(".mp3","");
        }

ArrayAdapter<String> adp= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,Items);
lv.setAdapter(adp);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(),Player.class).putExtra("pos",position).putExtra("videolist",myVids));
            }
        });
    }

    public ArrayList<File> findVids(File root)
    {
        ArrayList<File> arrayl=new ArrayList<File>();
        File[] files=root.listFiles();

        for(File singlefile : files)
        {
            if(singlefile.isDirectory() && !singlefile.isHidden())
            {
   arrayl.addAll(findVids(singlefile));
            }
            else {
            if(singlefile.getName().endsWith(".mp4") || singlefile.getName().endsWith("KAR") || singlefile.getName().endsWith(".mid") || singlefile.getName().endsWith(".mp3")  )
                {
                    arrayl.add(singlefile);
                }
            }
            }
return arrayl;
        }
    public void toast(String text)
    {
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }
    
        }