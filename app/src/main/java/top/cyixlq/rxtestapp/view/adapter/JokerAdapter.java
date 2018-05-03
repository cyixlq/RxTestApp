package top.cyixlq.rxtestapp.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import top.cyixlq.rxtestapp.R;
import top.cyixlq.rxtestapp.model.bean.Joker;

/**
 * Created by 24215 on 2018/3/17.
 */

public class JokerAdapter extends RecyclerView.Adapter<JokerAdapter.MyViewHolder> {

    private List<Joker.DataBean> list;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public JokerAdapter(List<Joker.DataBean> list,Context context){
        this.list=list;
        this.mContext=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.joker_rec_item,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.txt_title.setText(list.get(position).getName());
        holder.txt_content.setText(list.get(position).getText());
        Glide.with(mContext).load(list.get(position).getBimageuri()).into(holder.img);
        if(mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_title;
        TextView txt_content;
        ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);
            txt_title=itemView.findViewById(R.id.title);
            txt_content=itemView.findViewById(R.id.content);
            img=itemView.findViewById(R.id.img);
        }
    }

    //建立点击事件接口
    public interface OnItemClickListener{
        void onClick( int position);
    }

    //对外暴露设置点击事件
    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this.mOnItemClickListener=onItemClickListener;
    }
}
