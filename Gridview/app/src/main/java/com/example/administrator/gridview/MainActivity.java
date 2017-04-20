package com.example.administrator.gridview;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("网络视图");
        GridView gv =(GridView)findViewById(R.id.grid_view);
        gv.setAdapter(new ImageAdapter(this));
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        public ImageAdapter(Context c) {
            mContext=c;
        }
        private  Integer[] mThumbIds={R.drawable.grid_view_01,R.drawable.grid_view_02,R.drawable.grid_view_03,
                R.drawable.grid_view_04,R.drawable.grid_view_05,R.drawable.grid_view_06,R.drawable.grid_view_07,
                R.drawable.grid_view_08,R.drawable.grid_view_09,R.drawable.grid_view_10,R.drawable.grid_view_11,
                R.drawable.grid_view_12,R.drawable.grid_view_13,R.drawable.grid_view_14,R.drawable.grid_view_15,
                R.drawable.sample_1,R.drawable.sample_2,R.drawable.sample_3,R.drawable.sample_4,R.drawable.sample_5,
                R.drawable.sample_6,R.drawable.sample_7,
        };
        @Override
        public int getCount() {
            return mThumbIds.length;
        }

        @Override
        public Object getItem(int arg0) {
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview;
            if(convertView==null){
                imageview=new ImageView(mContext);
                imageview.setLayoutParams(new GridView.LayoutParams(85,85));
                imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageview.setPadding(8,8,8,8);
            }else{
                imageview=(ImageView)convertView;
            }
            imageview.setImageResource(mThumbIds[position]);
            return imageview;
        }
    }
}
