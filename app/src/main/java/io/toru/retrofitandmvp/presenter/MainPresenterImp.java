package io.toru.retrofitandmvp.presenter;

import android.util.Log;

import com.google.gson.Gson;

import io.toru.retrofitandmvp.network.operator.NetworkOperator;
import io.toru.retrofitandmvp.network.task.StackOverFlowQuestion;
import io.toru.retrofitandmvp.view.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by toru on 2016. 8. 11..
 */
public class MainPresenterImp implements MainPresenter {
    private static final String TAG = MainPresenterImp.class.getSimpleName();

    private MainView mainView;
    public MainPresenterImp(MainView mainView) {
        this.mainView = mainView;
    }

    // click action 의 핸들링
    @Override
    public void onClick() {
        // 메인 액티비티에 있는 화면의 버튼을 누르면 이쪽에서 rest api 를 태우고, 화면을 갱신해 주도록 한다
        NetworkOperator.getTaggedArticle("android", new Callback<StackOverFlowQuestion>() {
            @Override
            public void onResponse(Call<StackOverFlowQuestion> call, Response<StackOverFlowQuestion> response) {
                if(response.code() == 200){
                    StackOverFlowQuestion questionResult = response.body();
                    Log.w(TAG, "onResponse: size :: " + questionResult.items.size());
                    Log.w(TAG, "onResponse: " + new Gson().toJson(questionResult));

                    mainView.onUpdateRecyclerView(questionResult.items);
                }
                else{
                    // network fail case?
                }
            }

            @Override
            public void onFailure(Call<StackOverFlowQuestion> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    // view initializing.
    @Override
    public void onInitView() {
        mainView.onInitView();
    }
}