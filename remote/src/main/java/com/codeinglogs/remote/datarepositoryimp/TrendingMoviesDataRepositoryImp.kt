package com.codeinglogs.remote.datarepositoryimp

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.movies.movieslist.Movies
import com.codeinglogs.data.model.movies.movieslist.MoviesListResponce
import com.codeinglogs.data.repository.trendingmovies.RemoteTrendingMoviesData
import com.codeinglogs.remote.model.movies.movieslist.toDataMoviesListResponce
import com.codeinglogs.remote.pagingsource.TrendingMoviePagingSource
import com.codeinglogs.remote.request.MoviesRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TrendingMoviesDataRepositoryImp @Inject constructor (
    private val moviesRequest: MoviesRequest,
    private val trendingMoviePagingSource: TrendingMoviePagingSource
) :
    RemoteTrendingMoviesData {
    override fun getTrendingMovies(): Flow<State<MoviesListResponce>> = flow <State<MoviesListResponce>>{
        emit(State.loading())
        val trendingMovie = moviesRequest.getTrendingMovie()
        emit(State.success(trendingMovie.toDataMoviesListResponce()))
    }.catch {
        emit(State.failed(it.message?:""))
    }

    override fun getPagingTrendingMovies(): Flow<PagingData<Movies>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { trendingMoviePagingSource }
        ).flow
    }

}