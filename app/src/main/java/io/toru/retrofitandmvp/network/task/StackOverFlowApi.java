package io.toru.retrofitandmvp.network.task;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by toru on 2016. 8. 15..
 */
public interface StackOverFlowApi {
    @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
    Call<StackOverFlowQuestion> loadQuestions(@Query("tagged") String tags);

    @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
    Call<StackOverFlowQuestion> loadQuestioniOS(@Query("tagged") String tags);
}