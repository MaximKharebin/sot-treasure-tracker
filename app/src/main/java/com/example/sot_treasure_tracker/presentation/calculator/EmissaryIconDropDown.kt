package com.example.sot_treasure_tracker.presentation.calculator

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.presentation.calculator.models.DropDownItem
import com.example.sot_treasure_tracker.presentation.utils.theme.fontSize
import com.example.sot_treasure_tracker.presentation.utils.theme.spacing

@Composable
fun EmissaryDropDownIcon(
    selectedEmissaryIndex: Int,
    modifier: Modifier = Modifier,
    onDropDownItemClick: (DropDownItem) -> Unit,
) {

    var isContextMenuVisible by rememberSaveable { mutableStateOf(false) }
    var pressOffset by remember { mutableStateOf(DpOffset.Zero) }
    var itemHeight by remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current

    EmissaryIcon(
        drawableId = dropDownItems[selectedEmissaryIndex].icon,
        contentDescription = null,
        modifier = modifier
            .size(48.dp)
            .onSizeChanged { itemHeight = with(density) { it.height.toDp() } }
            .pointerInput(true) {
                detectTapGestures(
                    onTap = {
                        isContextMenuVisible = true
                        pressOffset = DpOffset(it.x.toDp(), it.y.toDp())
                    }
                )
            }
    )


    DropdownMenu(
        expanded = isContextMenuVisible,
        onDismissRequest = { isContextMenuVisible = false }
    ) {
        dropDownItems.forEach { item ->
            DropdownMenuItem(
                leadingIcon = {
                    EmissaryIcon(
                        drawableId = item.icon,
                        contentDescription = null,
                        modifier = Modifier
                            .size(36.dp)
                            .clip(shape = RoundedCornerShape(50.dp))
                    )
                },
                text = {
                    Text(
                        text = stringResource(id = item.title),
                        fontSize = MaterialTheme.fontSize.body,
                        fontWeight = FontWeight.Bold,
                    )
                },
                onClick = {
                    onDropDownItemClick(item)
                    isContextMenuVisible = false
                },
                modifier = Modifier.padding(vertical = MaterialTheme.spacing.extraSmall)
            )
        }
    }
}

private val dropDownItems = listOf(
    DropDownItem(
        id = 0,
        title = R.string.gold_hoarders,
        icon = R.drawable.logo_gh
    ),
    DropDownItem(
        id = 1,
        title = R.string.order_of_souls,
        icon = R.drawable.logo_oos
    ),
    DropDownItem(
        id = 2,
        title = R.string.merchant_alliance,
        icon = R.drawable.logo_ma
    ),
    DropDownItem(
        id = 3,
        title = R.string.athena_fortune,
        icon = R.drawable.logo_af
    ),
    DropDownItem(
        id = 4,
        title = R.string.reaper_bones,
        icon = R.drawable.logo_rb
    ),
    DropDownItem(
        id = 5,
        title = R.string.guild,
        icon = R.drawable.logo_br
    ),
    DropDownItem(
        id = 6,
        title = R.string.unselect,
        icon = R.drawable.logo_br
    )
)