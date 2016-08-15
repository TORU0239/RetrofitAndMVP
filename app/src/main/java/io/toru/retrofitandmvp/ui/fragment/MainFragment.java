package io.toru.retrofitandmvp.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.toru.retrofitandmvp.R;
import io.toru.retrofitandmvp.model.Question;
import io.toru.retrofitandmvp.network.operator.NetworkOperator;
import io.toru.retrofitandmvp.network.task.StackOverFlowQuestion;
import io.toru.retrofitandmvp.presenter.MainPresenter;
import io.toru.retrofitandmvp.presenter.MainPresenterImp;
import io.toru.retrofitandmvp.ui.adapter.MainAdapter;
import io.toru.retrofitandmvp.view.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements MainView {

    @BindView(R.id.main_recyclerview)
    RecyclerView recyclerView;

    private MainAdapter adapter;
    private List<Question> questionList;
    private MainPresenter presenter;

    private Unbinder unbinder;

    public MainFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onClick();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        presenter = new MainPresenterImp(this);

        questionList = new ArrayList<>();

        adapter = new MainAdapter(questionList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onInitView() {}

    @Override
    public void onUpdateRecyclerView(Object obj) {
        questionList.addAll((List<Question>)obj);
        adapter.notifyDataSetChanged();
    }
}