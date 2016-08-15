package io.toru.retrofitandmvp.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import io.toru.retrofitandmvp.base.ui.viewholder.BaseViewHolder;

/**
 * Created by toru on 2016. 8. 15..
 */
public class MainViewHolder extends BaseViewHolder{
    public ImageView   imageView;
    public TextView    textView;

    public MainViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void updateView(Object obj) {}
}