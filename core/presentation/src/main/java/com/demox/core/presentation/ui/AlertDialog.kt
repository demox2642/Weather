package com.demox.core.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun AlertDialog(
    modifier: Modifier = Modifier,
    title: String = "Возникла ошибка:",
    message: String,
    closeDialog: () -> Unit,
) {

    Dialog(
        onDismissRequest = {},
        content = {

            Card(
                modifier = Modifier.dropShadow(
                    RoundedCornerShape(30.dp),
                    shadow = Shadow(
                        radius = 3.dp,
                        color = Color.DarkGray,
                        spread = 0.dp,
                        offset = DpOffset(-3.dp, -3.dp)
                    ),
                )
                    .dropShadow(
                        RoundedCornerShape(30.dp),
                        shadow = Shadow(
                            radius = 3.dp,
                            color = Color.Black,
                            spread = 0.dp,
                            offset = DpOffset(3.dp, 3.dp)
                        ),

                        ),
                colors = CardDefaults.cardColors().copy(
                    containerColor = Color(0xFF1B1D21)
                )
            ) {
                Column(
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                            Text(
                                text = title,
                                textAlign = TextAlign.Center,
                                modifier =
                                    Modifier
                                        .padding(top = 5.dp)
                                        .fillMaxWidth(),
                                style = MaterialTheme.typography.titleSmall,
                                overflow = TextOverflow.Ellipsis,
                                color = Color.White
                            )

                        Text(
                            text = message,
                            textAlign = TextAlign.Center,
                            modifier =
                                Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth(),
                            color = Color.White
                        )
                    }
                    Divider(modifier = Modifier.fillMaxWidth().height(1.dp), color = Color.Black)
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        TextButton(
                            onClick = closeDialog,
                        ) {
                            Text(
                                text = "Закрыть",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                            )
                        }
                    }
                }
            }
        },
    )
}

