package com.demox.feature.main.presentation.ui.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demox.feature.main.domain.models.LocationData

@Composable
internal fun LocationUI(locationData: LocationData){
    Column {
        Text(text = locationData.country, style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = locationData.name, style = MaterialTheme.typography.headlineMedium)
    }

}

@Composable
@Preview(showBackground = true)
fun LocationUIPreview(){
    val location = LocationData(
        name = "Russia",
        country = "Москва"
    )

    LocationUI(locationData = location)
}