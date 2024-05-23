package com.example.sot_treasure_tracker.calculator.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.components.presentation.theme.fontSize
import com.example.sot_treasure_tracker.components.presentation.theme.spacing

@Composable
fun CostValues(
    minGoldAmount: Int,
    maxGoldAmount: Int,
    doubloonsAmount: Int,
    emissaryValueAmount: Int,
) {
    Column(
        modifier = Modifier.padding(bottom = MaterialTheme.spacing.small)
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = MaterialTheme.spacing.extraSmall)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(end = MaterialTheme.spacing.medium)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_currency_gold),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = MaterialTheme.spacing.extraSmall)
                )
                Text(
                    text = "$minGoldAmount–$maxGoldAmount",
                    fontWeight = FontWeight.Normal,
                    fontSize = MaterialTheme.fontSize.body
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_currency_doubloons),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = MaterialTheme.spacing.extraSmall)
                )
                Text(
                    text = "$doubloonsAmount",
                    fontWeight = FontWeight.Normal,
                    fontSize = MaterialTheme.fontSize.body
                )
            }
        }

        Text(
            text = stringResource(
                id = R.string.emissary_value,
                formatArgs = arrayOf(emissaryValueAmount)
            ),
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.fontSize.body
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CostValuesPreview() {
    CostValues(
        minGoldAmount = 10000,
        maxGoldAmount = 25000,
        doubloonsAmount = 300,
        emissaryValueAmount = 250700
    )
}