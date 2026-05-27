package eu.kanade.presentation.more

import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ChromeReaderMode
import androidx.compose.material.icons.automirrored.outlined.HelpOutline
import androidx.compose.material.icons.automirrored.outlined.Label
import androidx.compose.material.icons.automirrored.outlined.PlaylistAdd
import androidx.compose.material.icons.outlined.CloudOff
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.CollectionsBookmark
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.GetApp
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Link
import androidx.compose.material.icons.outlined.NewReleases
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.QueryStats
import androidx.compose.material.icons.outlined.Security
import androidx.compose.material.icons.outlined.Storage
import androidx.compose.material.icons.outlined.Sync
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import eu.kanade.presentation.more.settings.screen.about.AboutScreen
import eu.kanade.presentation.more.settings.widget.SwitchPreferenceWidget
import eu.kanade.presentation.more.settings.widget.TextPreferenceWidget
import eu.kanade.tachiyomi.R
import eu.kanade.tachiyomi.ui.more.DownloadQueueState
import exh.assets.EhAssets
import exh.assets.ehassets.EhLogo
import exh.assets.ehassets.MangadexLogo
import exh.md.utils.MdUtil
import exh.pref.DelegateSourcePreferences
import exh.source.ExhPreferences
import tachiyomi.core.common.Constants
import tachiyomi.i18n.MR
import tachiyomi.i18n.kmk.KMR
import tachiyomi.i18n.sy.SYMR
import tachiyomi.presentation.core.components.ScrollbarLazyColumn
import tachiyomi.presentation.core.components.material.Scaffold
import tachiyomi.presentation.core.components.material.padding
import tachiyomi.presentation.core.i18n.pluralStringResource
import tachiyomi.presentation.core.i18n.stringResource
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get

@Composable
fun MoreScreen(
    downloadQueueStateProvider: () -> DownloadQueueState,
    downloadedOnly: Boolean,
    onDownloadedOnlyChange: (Boolean) -> Unit,
    incognitoMode: Boolean,
    onIncognitoModeChange: (Boolean) -> Unit,
    // SY -->
    showNavUpdates: Boolean,
    showNavHistory: Boolean,
    // SY <--
    onClickDownloadQueue: () -> Unit,
    onClickCategories: () -> Unit,
    onClickStats: () -> Unit,
    onClickBatchAdd: () -> Unit,
    onClickUpdates: () -> Unit,
    onClickHistory: () -> Unit,
    onClickAppearanceSettings: () -> Unit,
    onClickLibrarySettings: () -> Unit,
    onClickReaderSettings: () -> Unit,
    onClickDownloadSettings: () -> Unit,
    onClickTrackingSettings: () -> Unit,
    onClickConnectionSettings: () -> Unit,
    onClickBrowseSettings: () -> Unit,
    onClickDataSettings: () -> Unit,
    onClickSecuritySettings: () -> Unit,
    onClickEhSettings: () -> Unit,
    onClickMangadexSettings: () -> Unit,
    onClickAdvancedSettings: () -> Unit,
    onClickAbout: () -> Unit,
    // KMK -->
    onClickLibraryUpdateErrors: () -> Unit,
    // KMK <--
) {
    val uriHandler = LocalUriHandler.current
    // SY -->
    val exhPreferences = remember { Injekt.get<ExhPreferences>() }
    val delegateSourcePreferences = remember { Injekt.get<DelegateSourcePreferences>() }
    val showMangadexSettings = remember { MdUtil.getEnabledMangaDexs(Injekt.get()).isNotEmpty() }
    // SY <--

    Scaffold { contentPadding ->
        ScrollbarLazyColumn(
            // KMK: use contentPadding as preferable padding for ScrollbarLazyColumn when not using stickyHeader
            contentPadding = contentPadding,
        ) {
            item {
                SwitchPreferenceWidget(
                    title = stringResource(MR.strings.label_downloaded_only),
                    subtitle = stringResource(MR.strings.downloaded_only_summary),
                    icon = Icons.Outlined.CloudOff,
                    checked = downloadedOnly,
                    onCheckedChanged = onDownloadedOnlyChange,
                )
            }
            item {
                SwitchPreferenceWidget(
                    title = stringResource(MR.strings.pref_incognito_mode),
                    subtitle = stringResource(MR.strings.pref_incognito_mode_summary),
                    // KMK -->
                    icon = rememberAnimatedVectorPainter(
                        AnimatedImageVector.animatedVectorResource(R.drawable.anim_incognito),
                        incognitoMode,
                    ),
                    // KMK <--
                    checked = incognitoMode,
                    onCheckedChanged = onIncognitoModeChange,
                )
            }

            item { Spacer(modifier = Modifier.height(10.dp)) }

            // SY -->
            if (!showNavUpdates) {
                item {
                    TextPreferenceWidget(
                        title = stringResource(MR.strings.label_recent_updates),
                        icon = Icons.Outlined.NewReleases,
                        onPreferenceClick = onClickUpdates,
                    )
                }
            }
            if (!showNavHistory) {
                item {
                    TextPreferenceWidget(
                        title = stringResource(MR.strings.label_recent_manga),
                        icon = Icons.Outlined.History,
                        onPreferenceClick = onClickHistory,
                    )
                }
            }
            // SY <--

            item {
                val downloadQueueState = downloadQueueStateProvider()
                TextPreferenceWidget(
                    title = stringResource(MR.strings.label_download_queue),
                    subtitle = when (downloadQueueState) {
                        DownloadQueueState.Stopped -> null
                        is DownloadQueueState.Paused -> {
                            val pending = downloadQueueState.pending
                            if (pending == 0) {
                                stringResource(MR.strings.paused)
                            } else {
                                "${stringResource(MR.strings.paused)} • ${
                                    pluralStringResource(
                                        MR.plurals.download_queue_summary,
                                        count = pending,
                                        pending,
                                    )
                                }"
                            }
                        }
                        is DownloadQueueState.Downloading -> {
                            val pending = downloadQueueState.pending
                            pluralStringResource(MR.plurals.download_queue_summary, count = pending, pending)
                        }
                    },
                    icon = Icons.Outlined.GetApp,
                    onPreferenceClick = onClickDownloadQueue,
                )
            }
            item {
                TextPreferenceWidget(
                    title = stringResource(MR.strings.categories),
                    icon = Icons.AutoMirrored.Outlined.Label,
                    onPreferenceClick = onClickCategories,
                )
            }
            item {
                TextPreferenceWidget(
                    title = stringResource(MR.strings.label_stats),
                    icon = Icons.Outlined.QueryStats,
                    onPreferenceClick = onClickStats,
                )
            }
            // KMK -->
            item {
                TextPreferenceWidget(
                    title = stringResource(KMR.strings.option_label_library_update_errors),
                    icon = Icons.Outlined.NewReleases,
                    onPreferenceClick = onClickLibraryUpdateErrors,
                )
            }
            // KMK <--
            // SY -->
            if (exhPreferences.isHentaiEnabled().get() || delegateSourcePreferences.delegateSources().get()) {
                item {
                    TextPreferenceWidget(
                        title = stringResource(SYMR.strings.eh_batch_add),
                        icon = Icons.AutoMirrored.Outlined.PlaylistAdd,
                        onPreferenceClick = onClickBatchAdd,
                    )
                }
            }
            // SY <--

            item { Spacer(modifier = Modifier.height(10.dp)) }

            item {
                TextPreferenceWidget(
                    title = stringResource(MR.strings.pref_category_appearance),
                    subtitle = stringResource(MR.strings.pref_appearance_summary),
                    icon = Icons.Outlined.Palette,
                    onPreferenceClick = onClickAppearanceSettings,
                )
            }
            item {
                TextPreferenceWidget(
                    title = stringResource(MR.strings.pref_category_library),
                    subtitle = stringResource(MR.strings.pref_library_summary),
                    icon = Icons.Outlined.CollectionsBookmark,
                    onPreferenceClick = onClickLibrarySettings,
                )
            }
            item {
                TextPreferenceWidget(
                    title = stringResource(MR.strings.pref_category_reader),
                    subtitle = stringResource(MR.strings.pref_reader_summary),
                    icon = Icons.AutoMirrored.Outlined.ChromeReaderMode,
                    onPreferenceClick = onClickReaderSettings,
                )
            }
            item {
                TextPreferenceWidget(
                    title = stringResource(MR.strings.pref_category_downloads),
                    subtitle = stringResource(MR.strings.pref_downloads_summary),
                    icon = Icons.Outlined.GetApp,
                    onPreferenceClick = onClickDownloadSettings,
                )
            }
            item {
                TextPreferenceWidget(
                    title = stringResource(MR.strings.pref_category_tracking),
                    subtitle = stringResource(MR.strings.pref_tracking_summary),
                    icon = Icons.Outlined.Sync,
                    onPreferenceClick = onClickTrackingSettings,
                )
            }
            item {
                TextPreferenceWidget(
                    title = stringResource(KMR.strings.pref_category_connections),
                    subtitle = stringResource(KMR.strings.pref_connections_summary),
                    icon = Icons.Outlined.Link,
                    onPreferenceClick = onClickConnectionSettings,
                )
            }
            item {
                TextPreferenceWidget(
                    title = stringResource(MR.strings.browse),
                    subtitle = stringResource(MR.strings.pref_browse_summary),
                    icon = Icons.Outlined.Explore,
                    onPreferenceClick = onClickBrowseSettings,
                )
            }
            item {
                TextPreferenceWidget(
                    title = stringResource(MR.strings.label_data_storage),
                    subtitle = stringResource(MR.strings.pref_backup_summary),
                    icon = Icons.Outlined.Storage,
                    onPreferenceClick = onClickDataSettings,
                )
            }
            item {
                TextPreferenceWidget(
                    title = stringResource(MR.strings.pref_category_security),
                    subtitle = stringResource(MR.strings.pref_security_summary),
                    icon = Icons.Outlined.Security,
                    onPreferenceClick = onClickSecuritySettings,
                )
            }
            // SY -->
            if (exhPreferences.isHentaiEnabled().get()) {
                item {
                    TextPreferenceWidget(
                        title = stringResource(SYMR.strings.pref_category_eh),
                        subtitle = stringResource(SYMR.strings.pref_ehentai_summary),
                        icon = EhAssets.EhLogo,
                        onPreferenceClick = onClickEhSettings,
                    )
                }
            }
            if (showMangadexSettings) {
                item {
                    TextPreferenceWidget(
                        title = stringResource(SYMR.strings.pref_category_mangadex),
                        subtitle = stringResource(SYMR.strings.pref_mangadex_summary),
                        icon = EhAssets.MangadexLogo,
                        onPreferenceClick = onClickMangadexSettings,
                    )
                }
            }
            // SY <--
            item {
                TextPreferenceWidget(
                    title = stringResource(MR.strings.pref_category_advanced),
                    subtitle = stringResource(MR.strings.pref_advanced_summary),
                    icon = Icons.Outlined.Code,
                    onPreferenceClick = onClickAdvancedSettings,
                )
            }
            item {
                TextPreferenceWidget(
                    title = stringResource(MR.strings.pref_category_about),
                    subtitle = "${stringResource(MR.strings.app_name)} ${AboutScreen.getVersionName(withBuildDate = false)}",
                    icon = Icons.Outlined.Info,
                    onPreferenceClick = onClickAbout,
                )
            }
            item {
                TextPreferenceWidget(
                    title = stringResource(MR.strings.label_help),
                    icon = Icons.AutoMirrored.Outlined.HelpOutline,
                    onPreferenceClick = { uriHandler.openUri(Constants.URL_HELP) },
                )
            }
        }
    }
}
