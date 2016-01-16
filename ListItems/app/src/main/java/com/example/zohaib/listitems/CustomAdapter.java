package com.example.zohaib.listitems;

import android.content.ContentResolver;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by zohaib on 12/6/15.
 */
public class CustomAdapter extends BaseAdapter {
    Context context;
    DataClass d = new DataClass();
    List<DataClass> codeLearnChapterList = d.getDataForListView();
    @Override
    public int getCount() {
        return codeLearnChapterList.size();
    }

    public CustomAdapter(Context c)
    {
        context = c;
    }

    @Override
    public Object getItem(int position) {
        return codeLearnChapterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listit , parent , false);
        }
        ImageView img = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView t = (TextView) convertView.findViewById(R.id.textView1);
        img.setImageResource(codeLearnChapterList.get(position).ChapterImage);
        t.setText(codeLearnChapterList.get(position).chapterName);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You clicked " + codeLearnChapterList.get(position).chapterName, Toast.LENGTH_SHORT);
            }
        });
        return convertView;
    }
}
