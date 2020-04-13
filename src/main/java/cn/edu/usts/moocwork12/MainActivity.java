package cn.edu.usts.moocwork12;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {

    private Integer[] mFunctionPics = {R.drawable.boy1,R.drawable.boy2,
            R.drawable.boy3,R.drawable.figure01,R.drawable.figure02
            ,R.drawable.scenery01,R.drawable.scenery02,R.drawable.scene01,R.drawable.girl1};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ViewFlipper viewFlipper = (ViewFlipper) this.findViewById(R.id.viewFlipper);
        GridView gridView= (GridView) this.findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });



    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater inflater;

        private class GridHolder {
            ImageView phone_function_pic;

        }

        public ImageAdapter(Context c){
            mContext = c;
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mFunctionPics.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            GridHolder holder;
            if(convertView == null) {
                convertView = inflater.inflate(R.layout.gridview_item, null);
                holder = new GridHolder();
                holder.phone_function_pic = (ImageView) convertView.findViewById(R.id.view);

                convertView.setTag(holder);
            } else {
                holder = (GridHolder) convertView.getTag();
            }
            holder.phone_function_pic.setImageResource(mFunctionPics[position]);

            return convertView;
        }

    }

}

