package com.codeinglogs.moviedetailsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codeinglogs.moviedetails.ui.activity.MovieDetailActivity
import com.codeinglogs.moviedetails.ui.activity.MoviesPagingActivity
import com.codeinglogs.presentation.model.movies.movieenum.MovieType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(MovieDetailActivity.getInstance(this,"524434"))
       //startActivity(MoviesPagingActivity.getInstance(this,MovieType.SEARCH))
    }
}