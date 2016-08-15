package io.toru.retrofitandmvp.kotlin.repository

import io.toru.retrofitandmvp.kotlin.repository.model.StackOverFlowQuestion
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable
import javax.inject.Inject


class StackOverFlowApi @Inject constructor(private val retrofit: Retrofit) {

    fun loadQuestions(@Query("tagged") tags: String): Observable<StackOverFlowQuestion> {
        return retrofit.create(Api::class.java).loadQuestions(tags)
    }

    fun loadQuestioniOS(@Query("tagged") tags: String): Observable<StackOverFlowQuestion> {
        return retrofit.create(Api::class.java).loadQuestioniOS(tags)
    }

    interface Api {
        @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
        fun loadQuestions(@Query("tagged") tags: String): Observable<StackOverFlowQuestion>

        @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
        fun loadQuestioniOS(@Query("tagged") tags: String): Observable<StackOverFlowQuestion>
    }
}