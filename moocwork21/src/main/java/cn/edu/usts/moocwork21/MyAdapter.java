package cn.edu.usts.moocwork21;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 11616 on 2020/5/14.
 */

public class MyAdapter extends RecyclerView.Adapter <MyViewHolder>{
    private LayoutInflater layoutInflater;
    private Context mcontext;
    private List<String> myname;
    private List<String> mytel;
    private List<String> myaddress;
    public MyAdapter(Context context,List<String> myname,List<String> mytel,List<String> myaddress){
        this.mcontext = context;
        this.myname = myname;
        this.mytel = mytel;
        this.myaddress = myaddress;
        this.layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }




    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tvname.setText(myname.get(position));
        holder.tvtel.setText(mytel.get(position));
        holder.tvaddress.setText(myaddress.get(position));
        //实现点击效果
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return myname.size();
    }
    public void addDatas(int position){
       myname.add("新增");
        notifyItemInserted(position);

    }
    public void setDatas(int position,String name,String tel,String address){
        myname.set(position,name);
        mytel.set(position,tel);
        myaddress.set(position,address);
        notifyItemChanged(position);
    }

    public void removeDatas(int position){
        myname.remove(position);
        notifyItemInserted(position);
    }
    //私有属性
    private OnItemClickListener onItemClickListener = null;

    //setter方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    //回调接口
    public interface OnItemClickListener {
        void onItemClick( int position);
    }
}
