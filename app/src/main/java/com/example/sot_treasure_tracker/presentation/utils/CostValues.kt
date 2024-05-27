package com.example.sot_treasure_tracker.presentation.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.example.compose.SotTreasureTrackerTheme
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.presentation.utils.theme.fontSize
import com.example.sot_treasure_tracker.presentation.utils.theme.spacing

@Composable
fun CostValues(
    minGoldAmount: Int,
    maxGoldAmount: Int,
    doubloonsAmount: Int,
<<<<<<< Updated upstream:app/src/main/java/com/example/sot_treasure_tracker/components/presentation/CostValues.kt
    emissaryValueAmount: Int
=======
    emissaryValueAmount: Int,
    doShowPrice: Boolean = false,
    doShowEmissaryValue: Boolean = false,
    modifier: Modifier = Modifier
>>>>>>> Stashed changes:app/src/main/java/com/example/sot_treasure_tracker/presentation/utils/CostValues.kt
) {
    Column {
        Row {
<<<<<<< Updated upstream:app/src/main/java/com/example/sot_treasure_tracker/components/presentation/CostValues.kt
            PriceWithCurrency(
                currencyDrawable = R.drawable.img_currency_gold,
                cost = "$minGoldAmount–$maxGoldAmount"
            )

            Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))

            PriceWithCurrency(
                currencyDrawable = R.drawable.img_currency_doubloons,
                cost = "$doubloonsAmount"
            )
        }

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))
=======
            if ((minGoldAmount > 0 || maxGoldAmount > 0) || doShowPrice) {
                PriceWithCurrency(
                    currencyDrawable = R.drawable.img_currency_gold,
                    cost = "$minGoldAmount–$maxGoldAmount",
                    modifier = Modifier.padding(end = MaterialTheme.spacing.small)
                )
            }

            if (doubloonsAmount > 0 || doShowPrice)
                PriceWithCurrency(
                    currencyDrawable = R.drawable.img_currency_doubloons,
                    cost = "$doubloonsAmount"
                )
        }

        if (emissaryValueAmount > 0 || doShowEmissaryValue) {
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))
>>>>>>> Stashed changes:app/src/main/java/com/example/sot_treasure_tracker/presentation/utils/CostValues.kt

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

@Composable
private fun PriceWithCurrency(
    currencyDrawable: Int,
    cost: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = currencyDrawable),
            contentDescription = null,
            modifier = Modifier
                .size(16.dp)
                .padding(end = MaterialTheme.spacing.extraSmall)
        )
        Text(
            text = cost,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.fontSize.body
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CostValuesPreview() {
    SotTreasureTrackerTheme {
        CostValues(
            minGoldAmount = 10000,
            maxGoldAmount = 25000,
            doubloonsAmount = 300,
            emissaryValueAmount = 250700
        )
    }
}