package eu.kanade.presentation.theme.colorscheme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

internal enum class KomikkuPaletteMood {
    WARM,
    DARK,
    PASTEL,
    COLD,
}

internal data class KomikkuPopularPalette(
    val mood: KomikkuPaletteMood,
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
) {
    val colors: List<Color>
        get() = listOf(primary, secondary, tertiary)
}

// KMK -->
// Popular 3-color palettes from Coolors, promoted to full app themes.
internal val KomikkuPopularPalettes = listOf(
    palette(KomikkuPaletteMood.COLD, "#0D3B66", "#FAF0CA", "#F4D35E"),
    palette(KomikkuPaletteMood.DARK, "#F6F7EB", "#E94F37", "#393E41"),
    palette(KomikkuPaletteMood.PASTEL, "#DCE0D9", "#FBF6EF", "#EAD7C3"),
    palette(KomikkuPaletteMood.COLD, "#006D77", "#83C5BE", "#EDF6F9"),
    palette(KomikkuPaletteMood.WARM, "#ED6A5A", "#F4F1BB", "#9BC1BC"),
    palette(KomikkuPaletteMood.DARK, "#2B2D42", "#8D99AE", "#EDF2F4"),
    palette(KomikkuPaletteMood.WARM, "#FE218B", "#FED700", "#21B0FE"),
    palette(KomikkuPaletteMood.DARK, "#1E1E24", "#92140C", "#FFF8F0"),
    palette(KomikkuPaletteMood.WARM, "#606C38", "#283618", "#FEFAE0"),
    palette(KomikkuPaletteMood.COLD, "#064789", "#427AA1", "#EBF2FA"),
    palette(KomikkuPaletteMood.WARM, "#F4F1DE", "#E07A5F", "#3D405B"),
    palette(KomikkuPaletteMood.WARM, "#26547C", "#EF476F", "#FFD166"),
    palette(KomikkuPaletteMood.DARK, "#0C1618", "#004643", "#FAF4D3"),
    palette(KomikkuPaletteMood.PASTEL, "#DDFFF7", "#93E1D8", "#FFA69E"),
    palette(KomikkuPaletteMood.PASTEL, "#9381FF", "#B8B8FF", "#F8F7FF"),
    palette(KomikkuPaletteMood.DARK, "#0B132B", "#1C2541", "#3A506B"),
    palette(KomikkuPaletteMood.COLD, "#233D4D", "#FE7F2D", "#FCCA46"),
    palette(KomikkuPaletteMood.WARM, "#EDAE49", "#D1495B", "#00798C"),
    palette(KomikkuPaletteMood.WARM, "#CB997E", "#DDBEA9", "#FFE8D6"),
    palette(KomikkuPaletteMood.COLD, "#F1F7ED", "#243E36", "#7CA982"),
    palette(KomikkuPaletteMood.PASTEL, "#84FFC9", "#AAB2FF", "#ECA0FF"),
    palette(KomikkuPaletteMood.DARK, "#FBF5F3", "#E28413", "#000022"),
    palette(KomikkuPaletteMood.WARM, "#540D6E", "#EE4266", "#FFD23F"),
    palette(KomikkuPaletteMood.DARK, "#000000", "#FF0000", "#FFE100"),
    palette(KomikkuPaletteMood.WARM, "#F6511D", "#FFB400", "#00A6ED"),
    palette(KomikkuPaletteMood.PASTEL, "#FAF3DD", "#C8D5B9", "#8FC0A9"),
    palette(KomikkuPaletteMood.COLD, "#264653", "#2A9D8F", "#E9C46A"),
    palette(KomikkuPaletteMood.DARK, "#003049", "#D62828", "#F77F00"),
    palette(KomikkuPaletteMood.WARM, "#FB8B24", "#D90368", "#820263"),
    palette(KomikkuPaletteMood.WARM, "#DD6E42", "#E8DAB2", "#4F6D7A"),
    palette(KomikkuPaletteMood.COLD, "#092327", "#0B5351", "#00A9A5"),
    palette(KomikkuPaletteMood.DARK, "#F72585", "#7209B7", "#3A0CA3"),
    palette(KomikkuPaletteMood.PASTEL, "#F3B391", "#F6D4BA", "#FEFADC"),
    palette(KomikkuPaletteMood.WARM, "#FFBA49", "#20A39E", "#EF5B5B"),
    palette(KomikkuPaletteMood.PASTEL, "#C9CBA3", "#FFE1A8", "#E26D5C"),
    palette(KomikkuPaletteMood.PASTEL, "#F1E0C5", "#C9B79C", "#71816D"),
    palette(KomikkuPaletteMood.WARM, "#FE4A49", "#FED766", "#009FB7"),
    palette(KomikkuPaletteMood.PASTEL, "#D9F0FF", "#A3D5FF", "#83C9F4"),
    palette(KomikkuPaletteMood.DARK, "#191716", "#E6AF2E", "#E0E2DB"),
    palette(KomikkuPaletteMood.WARM, "#FFBE0B", "#FB5607", "#FF006E"),
)

internal object KomikkuPopularColorScheme : BaseColorScheme() {

    override val darkScheme = darkColorScheme(
        primary = Color(0xFFB8CBFF),
        onPrimary = Color(0xFF08264F),
        primaryContainer = Color(0xFF314B83),
        onPrimaryContainer = Color(0xFFEAF0FF),
        inversePrimary = Color(0xFF49659C),
        secondary = Color(0xFFEAB0CA),
        onSecondary = Color(0xFF492338),
        secondaryContainer = Color(0xFF7D2E59),
        onSecondaryContainer = Color(0xFFFFD8EA),
        tertiary = Color(0xFFD5E9C9),
        onTertiary = Color(0xFF22351E),
        tertiaryContainer = Color(0xFF5C744E),
        onTertiaryContainer = Color(0xFFF0FFE8),
        background = Color(0xFF0C1020),
        onBackground = Color(0xFFE9EDFA),
        surface = Color(0xFF0C1020),
        onSurface = Color(0xFFE9EDFA),
        surfaceVariant = Color(0xFF1B1E2B),
        onSurfaceVariant = Color(0xFFC3C7D6),
        surfaceTint = Color(0xFFB8CBFF),
        inverseSurface = Color(0xFFE9EDFA),
        inverseOnSurface = Color(0xFF151824),
        error = Color(0xFFFFB4AB),
        onError = Color(0xFF690005),
        errorContainer = Color(0xFF93000A),
        onErrorContainer = Color(0xFFFFDAD6),
        outline = Color(0xFF6F7485),
        outlineVariant = Color(0xFF272B3B),
        surfaceContainerLowest = Color(0xFF080B15),
        surfaceContainerLow = Color(0xFF101422),
        surfaceContainer = Color(0xFF141826),
        surfaceContainerHigh = Color(0xFF1A1E2D),
        surfaceContainerHighest = Color(0xFF222639),
    )

    override val lightScheme = lightColorScheme(
        primary = Color(0xFF516DA6),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFFDCE6FF),
        onPrimaryContainer = Color(0xFF102F61),
        inversePrimary = Color(0xFFB8CBFF),
        secondary = Color(0xFF8A4166),
        onSecondary = Color(0xFFFFFFFF),
        secondaryContainer = Color(0xFFFFD8EA),
        onSecondaryContainer = Color(0xFF52263E),
        tertiary = Color(0xFF637A54),
        onTertiary = Color(0xFFFFFFFF),
        tertiaryContainer = Color(0xFFE6F6DA),
        onTertiaryContainer = Color(0xFF263A22),
        background = Color(0xFFF7F8FF),
        onBackground = Color(0xFF171A25),
        surface = Color(0xFFF7F8FF),
        onSurface = Color(0xFF171A25),
        surfaceVariant = Color(0xFFE4E7F2),
        onSurfaceVariant = Color(0xFF515666),
        surfaceTint = Color(0xFF516DA6),
        inverseSurface = Color(0xFF1B1E2B),
        inverseOnSurface = Color(0xFFF3F5FF),
        error = Color(0xFFBA1A1A),
        onError = Color(0xFFFFFFFF),
        errorContainer = Color(0xFFFFDAD6),
        onErrorContainer = Color(0xFF410002),
        outline = Color(0xFF8B90A0),
        outlineVariant = Color(0xFFD7DAE7),
        surfaceContainerLowest = Color(0xFFFFFFFF),
        surfaceContainerLow = Color(0xFFF1F3FC),
        surfaceContainer = Color(0xFFEAEDF8),
        surfaceContainerHigh = Color(0xFFE2E6F2),
        surfaceContainerHighest = Color(0xFFD9DEED),
    )

    fun getColorSchemeForPalette(
        paletteIndex: Int,
        isDark: Boolean,
        isAmoled: Boolean,
        overrideDarkSurfaceContainers: Boolean,
    ) = paletteScheme(
        palette = KomikkuPopularPalettes.getOrElse(paletteIndex) { KomikkuPopularPalettes.first() },
        isDark = isDark,
    ).let { colorScheme ->
        if (!isDark || !isAmoled) return@let colorScheme

        val amoledScheme = colorScheme.copy(
            background = Color.Black,
            onBackground = Color.White,
            surface = Color.Black,
            onSurface = Color.White,
        )

        if (!overrideDarkSurfaceContainers) return@let amoledScheme

        amoledScheme.copy(
            surfaceVariant = Color(0xFF0C0C0C),
            surfaceContainerLowest = Color(0xFF0C0C0C),
            surfaceContainerLow = Color(0xFF0C0C0C),
            surfaceContainer = Color(0xFF0C0C0C),
            surfaceContainerHigh = Color(0xFF131313),
            surfaceContainerHighest = Color(0xFF1B1B1B),
        )
    }
}
// KMK <--

private fun palette(
    mood: KomikkuPaletteMood,
    primary: String,
    secondary: String,
    tertiary: String,
) = KomikkuPopularPalette(
    mood = mood,
    primary = color(primary),
    secondary = color(secondary),
    tertiary = color(tertiary),
)

private fun paletteScheme(
    palette: KomikkuPopularPalette,
    isDark: Boolean,
) = if (isDark) {
    val neutral = palette.colors.minBy { it.luminance() }
    val background = neutral.blend(Color.Black, if (palette.mood == KomikkuPaletteMood.DARK) 0.62f else 0.76f)
    val surfaceContainer = background.blend(palette.secondary, 0.12f)
    darkColorScheme(
        primary = palette.primary.forDarkAccent(),
        onPrimary = palette.primary.forDarkAccent().contentColor(),
        primaryContainer = palette.primary.blend(Color.Black, 0.42f),
        onPrimaryContainer = palette.primary.blend(Color.White, 0.82f).contentColor(),
        inversePrimary = palette.primary.forLightAccent(),
        secondary = palette.secondary.forDarkAccent(),
        onSecondary = palette.secondary.forDarkAccent().contentColor(),
        secondaryContainer = palette.secondary.blend(Color.Black, 0.45f),
        onSecondaryContainer = palette.secondary.blend(Color.White, 0.82f).contentColor(),
        tertiary = palette.tertiary.forDarkAccent(),
        onTertiary = palette.tertiary.forDarkAccent().contentColor(),
        tertiaryContainer = palette.tertiary.blend(Color.Black, 0.45f),
        onTertiaryContainer = palette.tertiary.blend(Color.White, 0.82f).contentColor(),
        background = background,
        onBackground = background.contentColor(),
        surface = background,
        onSurface = background.contentColor(),
        surfaceVariant = surfaceContainer,
        onSurfaceVariant = surfaceContainer.contentColor().copy(alpha = 0.82f),
        surfaceTint = palette.primary.forDarkAccent(),
        inverseSurface = Color(0xFFEDECF2),
        inverseOnSurface = Color(0xFF1D1D24),
        error = Color(0xFFFFB4AB),
        onError = Color(0xFF690005),
        errorContainer = Color(0xFF93000A),
        onErrorContainer = Color(0xFFFFDAD6),
        outline = palette.secondary.blend(Color.White, 0.35f),
        outlineVariant = surfaceContainer.blend(Color.White, 0.18f),
        surfaceContainerLowest = background.blend(Color.Black, 0.18f),
        surfaceContainerLow = background.blend(Color.White, 0.04f),
        surfaceContainer = surfaceContainer,
        surfaceContainerHigh = surfaceContainer.blend(Color.White, 0.07f),
        surfaceContainerHighest = surfaceContainer.blend(Color.White, 0.13f),
    )
} else {
    val neutral = palette.colors.maxBy { it.luminance() }
    val background = neutral.blend(Color.White, 0.86f)
    val surfaceContainer = neutral.blend(Color.White, 0.72f)
    lightColorScheme(
        primary = palette.primary.forLightAccent(),
        onPrimary = palette.primary.forLightAccent().contentColor(),
        primaryContainer = palette.primary.blend(Color.White, 0.78f),
        onPrimaryContainer = palette.primary.blend(Color.White, 0.78f).contentColor(),
        inversePrimary = palette.primary.forDarkAccent(),
        secondary = palette.secondary.forLightAccent(),
        onSecondary = palette.secondary.forLightAccent().contentColor(),
        secondaryContainer = palette.secondary.blend(Color.White, 0.78f),
        onSecondaryContainer = palette.secondary.blend(Color.White, 0.78f).contentColor(),
        tertiary = palette.tertiary.forLightAccent(),
        onTertiary = palette.tertiary.forLightAccent().contentColor(),
        tertiaryContainer = palette.tertiary.blend(Color.White, 0.78f),
        onTertiaryContainer = palette.tertiary.blend(Color.White, 0.78f).contentColor(),
        background = background,
        onBackground = background.contentColor(),
        surface = background,
        onSurface = background.contentColor(),
        surfaceVariant = surfaceContainer,
        onSurfaceVariant = surfaceContainer.contentColor().copy(alpha = 0.74f),
        surfaceTint = palette.primary.forLightAccent(),
        inverseSurface = Color(0xFF352F2C),
        inverseOnSurface = Color(0xFFFFEDE5),
        error = Color(0xFFBA1A1A),
        onError = Color.White,
        errorContainer = Color(0xFFFFDAD6),
        onErrorContainer = Color(0xFF410002),
        outline = palette.secondary.blend(Color.Black, 0.18f),
        outlineVariant = neutral.blend(Color.Black, 0.16f),
        surfaceContainerLowest = Color.White,
        surfaceContainerLow = surfaceContainer.blend(Color.White, 0.26f),
        surfaceContainer = surfaceContainer,
        surfaceContainerHigh = surfaceContainer.blend(Color.Black, 0.04f),
        surfaceContainerHighest = surfaceContainer.blend(Color.Black, 0.08f),
    )
}

private fun Color.forLightAccent(): Color {
    return when {
        luminance() > 0.72f -> blend(Color.Black, 0.38f)
        luminance() > 0.55f -> blend(Color.Black, 0.22f)
        else -> this
    }
}

private fun Color.forDarkAccent(): Color {
    return when {
        luminance() < 0.28f -> blend(Color.White, 0.46f)
        luminance() < 0.5f -> blend(Color.White, 0.22f)
        else -> this
    }
}

private fun Color.contentColor(): Color {
    return if (luminance() > 0.48f) Color(0xFF171216) else Color.White
}

private fun Color.blend(target: Color, amount: Float): Color {
    val inverse = 1f - amount
    return Color(
        red = red * inverse + target.red * amount,
        green = green * inverse + target.green * amount,
        blue = blue * inverse + target.blue * amount,
        alpha = alpha * inverse + target.alpha * amount,
    )
}

private fun color(value: String): Color {
    return Color(android.graphics.Color.parseColor(value))
}
