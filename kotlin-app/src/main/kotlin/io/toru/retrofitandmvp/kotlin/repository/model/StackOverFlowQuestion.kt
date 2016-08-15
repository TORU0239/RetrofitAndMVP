package io.toru.retrofitandmvp.kotlin.repository.model

import com.google.auto.value.AutoValue
import com.google.gson.Gson
import com.google.gson.TypeAdapter


@AutoValue
abstract class StackOverFlowQuestion {
    abstract fun items(): List<Question>

    companion object {
        @JvmStatic fun typeAdapter(gson: Gson): TypeAdapter<StackOverFlowQuestion> {
            return AutoValue_StackOverFlowQuestion.GsonTypeAdapter(gson)
        }
    }
}