package io.toru.retrofitandmvp.network.operator;

import android.util.Log;

import java.io.IOException;

import io.toru.retrofitandmvp.network.task.StackOverFlowApi;
import io.toru.retrofitandmvp.network.task.StackOverFlowQuestion;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by toru on 2016. 8. 15..
 */
public class NetworkOperator {
    private static final String TAG = NetworkOperator.class.getSimpleName();
    public static final String BASE_URL = "https://api.stackexchange.com";

    public static void getTaggedArticle(String tagQuery, Callback<StackOverFlowQuestion> callback){
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
                .baseUrl(BASE_URL)
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // prepare call in Retrofit 2.0
        StackOverFlowApi stackOverflowAPI = retrofit.create(StackOverFlowApi.class);
        Call<StackOverFlowQuestion> call = stackOverflowAPI.loadQuestions(tagQuery);
        Log.w(TAG, "onClick: url :: " + stackOverflowAPI.loadQuestions(tagQuery).request().url().toString());

        //asynchronous call
        call.enqueue(callback);
    }
}