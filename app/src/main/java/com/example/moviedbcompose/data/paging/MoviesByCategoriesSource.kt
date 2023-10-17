package com.example.moviedbcompose.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.moviedbcompose.data.model.Movie
import com.example.moviedbcompose.data.network.ApiService
import retrofit2.HttpException
import java.io.IOException

class MoviesByCategoriesSource(private val api: ApiService, val category: String) :
    PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPage = params.key ?: 1
            val popularMovies =
                api.getMoviesByCategories(page = nextPage, category = category)
            LoadResult.Page(
                data = popularMovies.results,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (popularMovies.results.isEmpty()) null else popularMovies.page + 1
            )
        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }
}