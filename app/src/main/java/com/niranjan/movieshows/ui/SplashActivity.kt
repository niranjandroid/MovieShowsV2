package com.niranjan.movieshows.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.niranjan.movieshows.R
import com.niranjan.movieshows.ui.theme.MovieShowsTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//TODO: After pager fix this
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieShowsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Greeting()
                }
            }
        }

        waitAndProceedToHome()

    }

    private fun waitAndProceedToHome() {
      CoroutineScope(Dispatchers.Main).launch {
          delay(2000L)
          startActivity(Intent(this@SplashActivity, MainActivity::class.java))
          finish()
      }
    }
}

@Composable
fun Greeting() {
    Image(
        modifier = Modifier.width(IntrinsicSize.Max).height(IntrinsicSize.Max),
        painter = painterResource(id = R.drawable.splash),
        contentDescription = stringResource(id = R.string.cd_splash_image),
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovieShowsTheme {
        Greeting()
    }
}