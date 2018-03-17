package top.cyixlq.rxtestapp.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import top.cyixlq.rxtestapp.R;
import top.cyixlq.rxtestapp.model.bean.Joker;

/**
 * Created by 24215 on 2018/3/17.
 */

public class JokerAdapter extends RecyclerView.Adapter<JokerAdapter.MyViewHolder> {

    private List<Joker.DataBean> list;

    public JokerAdapter(List<Joker.DataBean> list){
        this.list=list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.joker_rec_item,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txt_title.setText(list.get(position).getName());
        holder.txt_content.setText(list.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_title;
        TextView txt_content;

        public MyViewHolder(View itemView) {
            super(itemView);
            txt_title=itemView.findViewById(R.id.title);
            txt_content=itemView.findViewById(R.id.content);
        }
    }
}
