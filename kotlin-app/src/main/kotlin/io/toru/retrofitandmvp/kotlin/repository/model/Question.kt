package io.toru.retrofitandmvp.kotlin.repository.model

import com.google.auto.value.AutoValue
import com.google.gson.Gson
import com.google.gson.TypeAdapter


@AutoValue
abstract class Question {

    abstract fun title(): String
    abstract fun link(): String

    companion object {
        @JvmStatic fun typeAdapter(gson: Gson): TypeAdapter<Question> {
            return AutoValue_Question.GsonTypeAdapter(gson)
        }
    }

}