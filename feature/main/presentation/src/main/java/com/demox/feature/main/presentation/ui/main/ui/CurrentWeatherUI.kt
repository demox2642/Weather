package com.demox.feature.main.presentation.ui.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil3.compose.SubcomposeAsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.demox.core.data.ext.toLongDataString
import com.demox.core.presentation.ext.toTempCelsii
import com.demox.feature.main.domain.models.CurrentData
import kotlinx.coroutines.Dispatchers

@Composable
internal fun CurrentWeatherUI(currentData: CurrentData){
    Text(text = "Обновлено: ${currentData.lastUpdatedEpoch.toLongDataString()}")
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(
            modifier = Modifier.fillMaxWidth(0.5f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = currentData.tempC.toString().toTempCelsii(),
                style = MaterialTheme.typography.headlineMedium.copy(fontSize = 45.sp, fontWeight = FontWeight.Bold))
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(currentData.condition.icon)
                    .diskCacheKey("condition${currentData.condition.code}")
                    .crossfade(true)
                    .memoryCachePolicy(
                        CachePolicy.ENABLED
                    )
                    .fetcherCoroutineContext(Dispatchers.IO)
                    .build(),
                contentDescription = currentData.condition.text,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
    Text(text = "Ветер: ${currentData.windKph} Км.ч.",
        style = MaterialTheme.typography.headlineMedium)


}