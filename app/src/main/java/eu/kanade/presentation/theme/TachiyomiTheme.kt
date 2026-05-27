package eu.kanade.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.materialkolor.DynamicMaterialExpressiveTheme
import eu.kanade.domain.ui.UiPreferences
import eu.kanade.domain.ui.model.AppTheme
import eu.kanade.presentation.theme.colorscheme.KomikkuPopularColorScheme
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get

@Composable
fun TachiyomiTheme(
    appTheme: AppTheme? = null,
    amoled: Boolean? = null,
    content: @Composable () -> Unit,
) {
    val uiPreferences = Injekt.get<UiPreferences>()
    BaseTachiyomiTheme(
        appTheme = appTheme ?: uiPreferences.appTheme().get(),
        isAmoled = amoled ?: uiPreferences.themeDarkAmoled().get(),
        content = content,
    )
}

// KMK -->
/** Theme based on Cover */
@Composable
fun TachiyomiTheme(
    seedColor: Color?,
    appTheme: AppTheme? = null,
    amoled: Boolean? = null,
    typography: Typography = MaterialTheme.typography,
    content: @Composable () -> Unit,
) {
    if (seedColor == null) {
        TachiyomiTheme(appTheme, amoled, content)
    } else {
        val uiPreferences = Injekt.get<UiPreferences>()
        val isAmoled = amoled ?: uiPreferences.themeDarkAmoled().get()
        DynamicMaterialExpressiveTheme(
            seedColor = seedColor,
            isAmoled = isAmoled,
            style = uiPreferences.themeCoverBasedStyle().get(),
            typography = typography,
            animate = true,
            content = content,
        )
    }
}
// KMK <--

@Composable
fun TachiyomiPreviewTheme(
    appTheme: AppTheme = AppTheme.KOMIKKU,
    isAmoled: Boolean = false,
    content: @Composable () -> Unit,
) = BaseTachiyomiTheme(appTheme, isAmoled, content)

@Composable
private fun BaseTachiyomiTheme(
    appTheme: AppTheme,
    isAmoled: Boolean,
    content: @Composable () -> Unit,
) {
    val isDark = isSystemInDarkTheme()
    MaterialExpressiveTheme(
        colorScheme = remember(appTheme, isDark, isAmoled) {
            getThemeColorScheme(
                appTheme = appTheme,
                isDark = isDark,
                isAmoled = isAmoled,
            )
        },
        // KMK -->
        shapes = KomikkuFigmaShapes,
        typography = rememberKomikkuFigmaTypography(),
        // KMK <--
        content = content,
    )
}

private fun getThemeColorScheme(
    appTheme: AppTheme,
    isDark: Boolean,
    isAmoled: Boolean,
): ColorScheme {
    return KomikkuPopularColorScheme.getColorSchemeForPalette(
        paletteIndex = appTheme.coolorsPaletteIndex,
        isDark = isDark,
        isAmoled = isAmoled,
        overrideDarkSurfaceContainers = true,
    )
}
