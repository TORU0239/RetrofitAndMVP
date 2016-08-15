package io.toru.retrofitandmvp.presenter;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import io.toru.retrofitandmvp.network.StackOverFlowApi;
import io.toru.retrofitandmvp.network.StackOverFlowQuestion;
import io.toru.retrofitandmvp.view.MainView;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by toru on 2016. 8. 11..
 */
public class MainPresenterImp implements MainPresenter, Callback<StackOverFlowQuestion>{
    private static final String TAG = MainPresenterImp.class.getSimpleName();

    private MainView mainView;

    public MainPresenterImp(MainView mainView) {
        this.mainView = mainView;
    }

    // click action 의 핸들링
    @Override
    public void onClick() {
        // 메인 액티비티에 있는 화면의 버튼을 누르면 이쪽에서 rest api 를 태우고, 화면을 갱신해 주도록 한다
        OkHttpClient okClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        okhttp3.Response response = chain.proceed(chain.request());
                        return response;
                    }
                })
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com")
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // prepare call in Retrofit 2.0
        StackOverFlowApi stackOverflowAPI = retrofit.create(StackOverFlowApi.class);
        Call<StackOverFlowQuestion> call = stackOverflowAPI.loadQuestions("android");
        Log.w(TAG, "onClick: url :: " + stackOverflowAPI.loadQuestions("android").request().url().toString());

        //asynchronous call
        call.enqueue(this);
    }

    // view initializing.
    @Override
    public void onInitView() {
        mainView.onInitView();
    }

    @Override
    public void onResponse(Call<StackOverFlowQuestion> call, Response<StackOverFlowQuestion> response) {
        Log.w(TAG, "onResponse: code :: " + response.code());
        Log.w(TAG, "onResponse: message :: " + response.message());

        StackOverFlowQuestion questionResult = response.body();
        Log.w(TAG, "onResponse: size :: " + questionResult.items.size());

        Log.w(TAG, "onResponse: " + new Gson().toJson(questionResult));
        mainView.onWriteTextView();
    }

    @Override
    public void onFailure(Call<StackOverFlowQuestion> call, Throwable t) {
        t.printStackTrace();
    }
}