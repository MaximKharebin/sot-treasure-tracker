package com.example.sot_treasure_tracker.calculator.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.sot_treasure_tracker.calculator.presentation.models.DropDownItem
import com.example.sot_treasure_tracker.components.presentation.theme.fontSize
import com.example.sot_treasure_tracker.components.presentation.theme.spacing

@Composable
fun EmissaryItem(
    icon: Int,
    dropDownItems: List<DropDownItem>,
    modifier: Modifier = Modifier,
    onItemClick: (DropDownItem) -> Unit,
) {

    var isContextMenuVisible by rememberSaveable { mutableStateOf(false) }
    var pressOffset by remember { mutableStateOf(DpOffset.Zero) }
    var itemHeight by remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current

    Image(
        painter = painterResource(id = icon),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(48.dp)
            .background(
                MaterialTheme.colorScheme.inverseSurface,
                shape = RoundedCornerShape(topStart = 50.dp, bottomStart = 50.dp)
            )
            .padding(all = MaterialTheme.spacing.small)
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
                    Image(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(36.dp)
                            .background(
                                MaterialTheme.colorScheme.inverseSurface,
                                shape = RoundedCornerShape(50.dp)
                            )
                            .padding(all = MaterialTheme.spacing.small)
                    )
                },
                text = {
                    Text(
                        text = item.title,
                        fontSize = MaterialTheme.fontSize.body,
                        fontWeight = FontWeight.Bold,
                    )
                },
                onClick = {
                    onItemClick(item)
                    isContextMenuVisible = false
                },
                modifier = Modifier.padding(vertical = MaterialTheme.spacing.extraSmall)
            )
        }
    }
}