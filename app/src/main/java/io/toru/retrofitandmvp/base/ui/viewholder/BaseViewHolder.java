package io.toru.retrofitandmvp.base.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.view.View;
import android.widget.AbsListView;

/**
 * Created by toru on 2016. 8. 15..
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder{

    public BaseViewHolder(View itemView) {
        super(itemView);
    }
    public abstract void updateView(Object obj);
}
