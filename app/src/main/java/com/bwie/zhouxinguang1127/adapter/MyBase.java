package com.bwie.zhouxinguang1127.adapter;
/*
 *@auther:周鑫光
 *@Date: 2019/11/27
 *@Time:9:11
 *@Description:${DESCRIPTION}
 * */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bwie.zhouxinguang1127.MainActivity;
import com.bwie.zhouxinguang1127.R;
import com.bwie.zhouxinguang1127.bean.StudentBean;

import java.util.List;

public class MyBase extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final List<StudentBean.ResultBean> list;
    private final int pager1 = 1;
    private final int pager2 = 2;

    public MyBase(Context context, List<StudentBean.ResultBean> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder holder = null;
        View view = null;
        switch (i) {
            case pager1:
                view = View.inflate(context, R.layout.item, null);
                holder = new OneHolder(view);
                break;
            case pager2:
                view = View.inflate(context, R.layout.item1, null);
                holder = new TwoHolder(view);
                break;


        }

        return holder;
    }

    class OneHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView;
        private final TextView textView1;

        public OneHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image1);
            textView = itemView.findViewById(R.id.text1);
            textView1 = itemView.findViewById(R.id.text2);

        }
    }

    class TwoHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView;
        private final TextView textView1;

        public TwoHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image1);
            textView = itemView.findViewById(R.id.text1);
            textView1 = itemView.findViewById(R.id.text2);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof OneHolder) {
            ((OneHolder) viewHolder).textView.setText(list.get(i).getCommodityName());
            ((OneHolder) viewHolder).textView1.setText(list.get(i).getPrice() + "");
            Glide.with(context).load(list.get(i).getMasterPic())
                    .error(R.mipmap.ic_launcher)
                    .priority(Priority.HIGH)
                    .placeholder(R.mipmap.ic_launcher)
                    .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                    .into(((OneHolder) viewHolder).imageView);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setClick.onSetClick(i);
                }
            });
        } else if (viewHolder instanceof TwoHolder) {
            if (viewHolder instanceof OneHolder) {
                ((TwoHolder) viewHolder).textView.setText(list.get(i).getCommodityName());
                ((TwoHolder) viewHolder).textView1.setText(list.get(i).getPrice() + "");
                Glide.with(context).load(list.get(i).getMasterPic())
                        .error(R.mipmap.ic_launcher)
                        .priority(Priority.HIGH)
                        .placeholder(R.mipmap.ic_launcher)
                        .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                        .into(((TwoHolder) viewHolder).imageView);
            }

        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return pager1;
        } else {
            return pager2;
        }

    }

    public interface SetClick {
        void onSetClick(int position);
    }

    public SetClick setClick;

    public void onSetname(SetClick setClick) {
        this.setClick = setClick;
    }
}
