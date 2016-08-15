package io.toru.retrofitandmvp.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import io.toru.retrofitandmvp.R;
import io.toru.retrofitandmvp.base.ui.viewholder.BaseViewHolder;
import io.toru.retrofitandmvp.model.Question;

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
    public void updateView(Object obj) {
        Question question = (Question)obj;
        textView = (TextView)itemView.findViewById(R.id.main_adapter_link);
        textView.setText(question.toString());
    }
}