package com.example.linyuming.uilistviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {
    private  int resourceId;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewholder;
        if (convertView==null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewholder = new ViewHolder();
            viewholder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewholder.fruitName=(TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewholder);
        }else{
            view = convertView;
            viewholder = (ViewHolder) view.getTag();
        }
        viewholder.fruitImage.setImageResource(fruit.getImageId());
        viewholder.fruitName.setText(fruit.getName());
        return view;
    }

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId,objects);
        resourceId=textViewResourceId;

    }
    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
