package com.demox.feature.main.presentation.ui.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.demox.core.data.ext.toTimeString
import com.demox.core.presentation.ext.toTempCelsii
import com.demox.feature.main.domain.models.HourData
import kotlinx.coroutines.Dispatchers
import java.util.Date

@Composable
internal fun HourUI(hoursData: List<HourData>) {
    val currentDate = Date.from(java.time.Instant.now())
    val nextHourData = hoursData.firstOrNull  { it.timeEpoch * 1000 > currentDate.time }

    val scrollposition = rememberLazyListState(
        initialFirstVisibleItemIndex = if (nextHourData==null) 0 else hoursData.indexOf(nextHourData)
    )

    LazyRow(
        state = scrollposition,
        contentPadding = PaddingValues(horizontal = 5.dp)
    ) {
        items(items = hoursData, key ={ item -> item.timeEpoch }){
            HourListItem(
                hourData = it,
                itFutureData = it.timeEpoch*1000 > currentDate.time
            )
        }
    }
}

@Composable
private fun HourListItem(hourData: HourData,itFutureData: Boolean){

    Card(
        modifier = Modifier.padding(horizontal = 4.dp),
        colors = if (itFutureData.not()) CardDefaults.cardColors().copy(containerColor = Color(0x2D75A8F5)) else  CardDefaults.cardColors().copy(containerColor = Color(0x673d92f4))
    ) {
        Column(
            modifier = Modifier.padding( 6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = hourData.timeEpoch.toTimeString())
            Spacer(modifier = Modifier.height(3.dp))
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(hourData.condition.icon)
                    .diskCacheKey("condition${hourData.condition.code}")
                    .crossfade(true)
                    .memoryCachePolicy(
                        CachePolicy.ENABLED
                    )
                    .fetcherCoroutineContext(Dispatchers.IO)
                    .build(),
                contentDescription = hourData.condition.text,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(60.dp)
                    .graphicsLayer {
                        alpha =   if (itFutureData){
                            1f
                        } else{
                            0.5f
                        }

                    }
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = hourData.tempC.toString().toTempCelsii())
        }
    }
}