package com.demox.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.demox.feature.main.presentation.ui.MainScreens
import com.demox.feature.main.presentation.ui.mainNavScreens
import com.demox.weather.ui.theme.WeatherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private var keepSplashOnScreen = true
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashscreen = installSplashScreen()
        splashscreen.setKeepOnScreenCondition { keepSplashOnScreen }
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            val viewModel: MainActivityViewModel  = hiltViewModel()
            val splashScreen by viewModel.keepSplashOnScreen.collectAsState()
            keepSplashOnScreen = splashScreen

            if (splashScreen.not()) {
                WeatherTheme {
                    val navController = rememberNavController()

                    Scaffold(
                        modifier = Modifier.fillMaxSize().systemBarsPadding(),
                    ) { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = MainScreens.MainScreen.route,
                            modifier = Modifier.padding(innerPadding),
                        ) {
                            mainNavScreens(navController)

                        }
                    }
                }
            }
        }
    }
}
