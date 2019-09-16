package com.liyanlei.qimolianxi.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liyanlei.qimolianxi.R;
import com.liyanlei.qimolianxi.bean.HomeBean;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private final FragmentActivity activity;
    private final ArrayList<HomeBean.DataBean.CurrentCategoryBean.SubCategoryListBean> list;

    public HomeAdapter(final FragmentActivity activity, final ArrayList<HomeBean.DataBean.CurrentCategoryBean.SubCategoryListBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.layout_item, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        HomeBean.DataBean.CurrentCategoryBean.SubCategoryListBean subCategoryListBean = list.get(i);
        ViewHolder holder = viewHolder;
        holder.title.setText(subCategoryListBean.getName());
        Glide.with(activity)
                .load(subCategoryListBean.getWap_banner_url())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView title;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
        }
    }
}
