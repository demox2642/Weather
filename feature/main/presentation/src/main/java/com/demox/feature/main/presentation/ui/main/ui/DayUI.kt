package com.demox.feature.main.presentation.ui.main.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.demox.core.data.ext.toShortDataString
import com.demox.core.presentation.ext.toTempCelsii
import com.demox.feature.main.domain.models.DayData
import kotlinx.coroutines.Dispatchers

@Composable
internal fun DayUI(dayData: DayData) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 3.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = dayData.date.toShortDataString(), style = MaterialTheme.typography.labelMedium)
            Spacer(modifier = Modifier.width(3.dp))
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(dayData.condition.icon)
                    .diskCacheKey("condition${dayData.condition.code}")
                    .crossfade(true)
                    .memoryCachePolicy(
                        CachePolicy.ENABLED
                    )
                    .fetcherCoroutineContext(Dispatchers.IO)
                    .build(),
                contentDescription = dayData.condition.text,
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(text = dayData.avgTempC.toString().toTempCelsii(), style = MaterialTheme.typography.labelMedium)
            Spacer(modifier = Modifier.width(3.dp))
            Column() {
                Text(text ="min: " + dayData.minTempC.toString().toTempCelsii(), style = MaterialTheme.typography.labelMedium)
                Spacer(modifier = Modifier.height(6.dp))
                Text(text ="max: " + dayData.maxTempC.toString().toTempCelsii(), style = MaterialTheme.typography.labelMedium)
            }
            Spacer(modifier = Modifier.width(3.dp))
            Text(text = "ветер: ", style = MaterialTheme.typography.labelMedium)
            Spacer(modifier = Modifier.width(3.dp))
            Column() {
                Text(text ="avg: ${dayData.avgVisKm}км", style = MaterialTheme.typography.labelMedium)
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "max: ${dayData.maxWindKph}км", style = MaterialTheme.typography.labelMedium)
            }
            Spacer(modifier = Modifier.width(3.dp))

        }
    }
}