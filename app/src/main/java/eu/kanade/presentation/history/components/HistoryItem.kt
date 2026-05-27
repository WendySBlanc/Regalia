package eu.kanade.presentation.history.components

import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableFloatState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import eu.kanade.presentation.manga.components.DotSeparatorText
import eu.kanade.presentation.manga.components.MangaCover
import eu.kanade.presentation.manga.components.MangaCoverHide
import eu.kanade.presentation.manga.components.RatioSwitchToPanorama
import eu.kanade.presentation.theme.TachiyomiPreviewTheme
import eu.kanade.presentation.util.formatChapterNumber
import eu.kanade.tachiyomi.util.lang.toTimestampString
import exh.debug.DebugToggles
import tachiyomi.domain.history.model.HistoryWithRelations
import tachiyomi.i18n.MR
import tachiyomi.i18n.kmk.KMR
import tachiyomi.presentation.core.components.material.DISABLED_ALPHA
import tachiyomi.presentation.core.components.material.padding
import tachiyomi.presentation.core.i18n.stringResource

private val HistoryItemHeight = 82.dp

@Composable
fun HistoryItem(
    history: HistoryWithRelations,
    onClickCover: () -> Unit,
    // KMK -->
    onClick: () -> Unit,
    onLongClick: () -> Unit,
    // KMK <--
    onClickDelete: () -> Unit,
    onClickFavorite: () -> Unit,
    modifier: Modifier = Modifier,
    // KMK -->
    selected: Boolean,
    readProgress: String?,
    hasUnread: Boolean,
    usePanoramaCover: Boolean,
    coverRatio: MutableFloatState = remember(history.mangaId) {
        mutableFloatStateOf(history.coverData.ratio?.let { 1f / it } ?: 1f)
    },
    // KMK <--
) {
    // KMK -->
    val haptic = LocalHapticFeedback.current
    val textAlpha = if (history.read) DISABLED_ALPHA else 1f
    // KMK <--
    Row(
        modifier = modifier
            // KMK -->
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(
                if (selected) {
                    MaterialTheme.colorScheme.primaryContainer
                } else {
                    MaterialTheme.colorScheme.surfaceContainerHigh
                },
            )
            .combinedClickable(
                onClick = onClick,
                onLongClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    onLongClick()
                },
            )
            // KMK <--
            .heightIn(min = HistoryItemHeight)
            .padding(start = 12.dp, top = 10.dp, end = 8.dp, bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // KMK -->
        val mangaCover = history.coverData
        val coverIsWide = coverRatio.floatValue <= RatioSwitchToPanorama
        val bgColor = mangaCover.dominantCoverColors?.first?.let { Color(it) }
        val onBgColor = mangaCover.dominantCoverColors?.second
        if (DebugToggles.HIDE_COVER_IMAGE_ONLY_SHOW_COLOR.enabled) {
            MangaCoverHide.Book(
                modifier = Modifier.size(width = 52.dp, height = 72.dp),
                bgColor = bgColor ?: MaterialTheme.colorScheme.surface.takeIf { selected },
                tint = onBgColor,
                size = MangaCover.Size.Medium,
            )
        } else {
            if (usePanoramaCover && coverIsWide) {
                MangaCover.Panorama(
                    modifier = Modifier.size(width = 92.dp, height = 62.dp)
                        // KMK -->
                        .combinedClickable(
                            onClick = onClickCover,
                            onLongClick = {
                                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                onLongClick()
                            },
                        ),
                    // KMK <--
                    data = mangaCover,
                    // KMK -->
                    bgColor = bgColor,
                    tint = onBgColor,
                    size = MangaCover.Size.Medium,
                    onCoverLoaded = { _, result ->
                        val image = result.result.image
                        coverRatio.floatValue = image.height.toFloat() / image.width
                    },
                    // KMK <--
                )
            } else {
                // KMK <--
                MangaCover.Book(
                    modifier = Modifier.size(width = 52.dp, height = 72.dp)
                        // KMK -->
                        .combinedClickable(
                            onClick = onClickCover,
                            onLongClick = {
                                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                onLongClick()
                            },
                        ),
                    // KMK <--
                    data = mangaCover,
                    // KMK -->
                    bgColor = bgColor,
                    tint = onBgColor,
                    size = MangaCover.Size.Medium,
                    onCoverLoaded = { _, result ->
                        val image = result.result.image
                        coverRatio.floatValue = image.height.toFloat() / image.width
                    },
                    // KMK <--
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = MaterialTheme.padding.medium, end = MaterialTheme.padding.small),
        ) {
            Text(
                text = history.title,
                // KMK -->
                color = LocalContentColor.current.copy(alpha = textAlpha),
                // KMK <--
                fontWeight = FontWeight.SemiBold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium,
            )
            val readAt = remember { history.readAt?.toTimestampString() ?: "" }
            // KMK -->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 4.dp),
            ) {
                if (hasUnread) {
                    Icon(
                        imageVector = Icons.Filled.Circle,
                        contentDescription = stringResource(KMR.strings.action_filter_unfinished_manga),
                        modifier = Modifier
                            .height(8.dp)
                            .padding(end = 4.dp),
                        tint = MaterialTheme.colorScheme.primary,
                    )
                }
                // KMK <--
                Text(
                    text = if (history.chapterNumber > -1) {
                        stringResource(
                            MR.strings.recent_manga_time,
                            formatChapterNumber(history.chapterNumber),
                            readAt,
                        )
                    } else {
                        readAt
                    },
                    // KMK -->
                    color = LocalContentColor.current.copy(alpha = textAlpha),
                    style = MaterialTheme.typography.bodySmall,
                    // KMK <--
                )
                // KMK -->
                if (readProgress != null) {
                    DotSeparatorText()
                    Text(
                        text = readProgress,
                        maxLines = 1,
                        color = LocalContentColor.current.copy(alpha = textAlpha),
                        style = MaterialTheme.typography.bodySmall,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
                // KMK <--
            }
        }

        if (!history.coverData.isMangaFavorite) {
            IconButton(onClick = onClickFavorite) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = stringResource(MR.strings.add_to_library),
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        }

        IconButton(onClick = onClickDelete) {
            Icon(
                imageVector = Icons.Outlined.Delete,
                contentDescription = stringResource(MR.strings.action_delete),
                tint = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun HistoryItemPreviews(
    @PreviewParameter(HistoryWithRelationsProvider::class)
    historyWithRelations: HistoryWithRelations,
) {
    TachiyomiPreviewTheme {
        Surface {
            HistoryItem(
                history = historyWithRelations,
                onClickCover = {},
                // KMK -->
                onClick = {},
                onLongClick = {},
                // KMK <--
                onClickDelete = {},
                onClickFavorite = {},
                readProgress = "Page 5",
                // KMK -->
                hasUnread = true,
                selected = true,
                usePanoramaCover = false,
                // KMK <--
            )
        }
    }
}
