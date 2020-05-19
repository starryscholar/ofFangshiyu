package cn.edu.usts.moocwork21;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 11616 on 2020/5/14.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
     TextView tvname,tvtel,tvaddress;
    public MyViewHolder(View itemView) {
        super(itemView);
        tvname = (TextView) itemView.findViewById(R.id.item_tvname);
        tvtel = (TextView) itemView.findViewById(R.id.item_tvtel);
        tvaddress = (TextView) itemView.findViewById(R.id.item_tvaddress);

    }
}
