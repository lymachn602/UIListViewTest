package com.example.linyuming.uilistviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       initFruits();
        FruitAdapter adapter  = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits() {
        for(int i=0;i<4;i++){
            Fruit apple = new Fruit("apple",R.drawable.blackcar);
            fruitList.add(apple);
            Fruit banana = new Fruit("banana",R.drawable.blackshot);
            fruitList.add(banana);
            Fruit orange = new Fruit("orange",R.drawable.bpeople);
            fruitList.add(orange);
            Fruit watermenlon = new Fruit("watermenlon",R.drawable.fcar);
            fruitList.add(watermenlon);
        }
    }
}
