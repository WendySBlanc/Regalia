package eu.kanade.tachiyomi.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.hazeEffect
import eu.kanade.presentation.util.Tab
import tachiyomi.presentation.core.util.pressFeedback

/**
 * YouTube-like bottom navigation for Regalia's main destinations.
 */
@Composable
fun FloatingNavigationBar(
    tabs: List<Tab>,
    selectedIndex: Int,
    alwaysShowLabel: Boolean,
    onSelect: (Int) -> Unit,
    onReselect: (Int) -> Unit,
    modifier: Modifier = Modifier,
    badge: @Composable (Tab) -> Unit = {},
    hazeState: HazeState? = null,
) {
    if (tabs.isEmpty()) return

    val selectedContentColor = MaterialTheme.colorScheme.onSurface
    val inactiveContentColor = MaterialTheme.colorScheme.onSurfaceVariant
    val navTint = MaterialTheme.colorScheme.surface.copy(alpha = 0.42f)
    val showLabels = alwaysShowLabel || tabs.size <= 5

    Box(
        modifier = modifier
            .fillMaxWidth()
            .then(
                if (hazeState != null) {
                    Modifier.hazeEffect(
                        state = hazeState,
                        style = HazeStyle(
                            backgroundColor = Color.Transparent,
                            tint = HazeDefaults.tint(navTint),
                            blurRadius = 40.dp,
                        ),
                    )
                } else {
                    Modifier
                },
            )
            .windowInsetsPadding(NavigationBarDefaults.windowInsets),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(if (showLabels) YouTubeBarHeight else YouTubeCompactBarHeight)
                .padding(horizontal = 4.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            tabs.fastForEachIndexed { index, tab ->
                val selected = index == selectedIndex
                val options = tab.options
                val itemInteractionSource = remember(index) { MutableInteractionSource() }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .height(if (showLabels) YouTubeItemHeight else YouTubeCompactItemHeight)
                        .pressFeedback(
                            interactionSource = itemInteractionSource,
                            pressedScale = 0.92f,
                        )
                        .clickable(
                            interactionSource = itemInteractionSource,
                            indication = null,
                            onClick = { if (selected) onReselect(index) else onSelect(index) },
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = IconSlotWidth, height = IconSlotHeight),
                        contentAlignment = Alignment.Center,
                    ) {
                        BadgedBox(badge = { badge(tab) }) {
                            Icon(
                                painter = options.icon!!,
                                contentDescription = options.title,
                                tint = if (selected) selectedContentColor else inactiveContentColor,
                                modifier = Modifier.size(if (selected) SelectedIconSize else IconSize),
                            )
                        }
                    }
                    if (showLabels) {
                        Text(
                            text = options.title,
                            modifier = Modifier.padding(top = 2.dp),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
                            color = if (selected) selectedContentColor else inactiveContentColor,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                }
            }
        }
    }
}

private val YouTubeBarHeight = 58.dp
private val YouTubeCompactBarHeight = 48.dp
private val YouTubeItemHeight = 54.dp
private val YouTubeCompactItemHeight = 44.dp
private val IconSlotWidth = 64.dp
private val IconSlotHeight = 30.dp
private val IconSize = 24.dp
private val SelectedIconSize = 26.dp
