package io.toru.retrofitandmvp.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.toru.retrofitandmvp.R;
import io.toru.retrofitandmvp.base.ui.viewholder.BaseViewHolder;
import io.toru.retrofitandmvp.model.Question;

/**
 * Created by toru on 2016. 8. 15..
 */
public class MainViewHolder extends BaseViewHolder{

    @BindView(R.id.main_adapter_image)
    public ImageView imageView;

    @BindView(R.id.main_adapter_link)
    public TextView textView;

    public MainViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void updateView(Object obj) {
        Question question = (Question)obj;
        textView.setText(question.toString());
    }
}