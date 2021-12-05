package com.codeinglogs.data.model.trendingmovies

import com.codeinglogs.domain.model.trendingmovies.Result as Domain

data class Result(
    val id: Double,
    val original_language: String,
    val original_name: String,
    val original_title: String,
    val poster_path: String,
    val title: String,
)

fun Result.toDomainTrendingMoviesResult() = Domain(
    id = id,
    original_language = original_language,
    original_name = original_name,
    original_title = original_title,
    poster_path = poster_path,
    title =title
)

