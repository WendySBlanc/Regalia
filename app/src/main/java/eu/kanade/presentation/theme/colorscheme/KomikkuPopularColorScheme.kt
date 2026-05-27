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
    val neutral: Color,
) {
    val colors: List<Color>
        get() = listOf(primary, secondary, tertiary, neutral)
}

// KMK -->
// 30 Coolors-style popular palettes, grouped into warm, dark, pastel, and cold moods.
// Each palette intentionally uses 4 colors: primary, secondary, tertiary, and neutral/surface.
internal val KomikkuPopularPalettes = listOf(
    palette(KomikkuPaletteMood.DARK, "#B8CBFF", "#7D2E59", "#F0B9D2", "#0C1020"),
    palette(KomikkuPaletteMood.WARM, "#606C38", "#283618", "#DDA15E", "#FEFAE0"),
    palette(KomikkuPaletteMood.WARM, "#780000", "#C1121F", "#669BBC", "#FDF0D5"),
    palette(KomikkuPaletteMood.WARM, "#582F0E", "#7F4F24", "#A68A64", "#B6AD90"),
    palette(KomikkuPaletteMood.WARM, "#6F1D1B", "#BB9457", "#99582A", "#FFE6A7"),
    palette(KomikkuPaletteMood.WARM, "#8E3200", "#A64B2A", "#D7A86E", "#FFEBC1"),
    palette(KomikkuPaletteMood.WARM, "#CB997E", "#DDBEA9", "#6B705C", "#FFE8D6"),
    palette(KomikkuPaletteMood.WARM, "#F94144", "#F3722C", "#F9C74F", "#90BE6D"),
    palette(KomikkuPaletteMood.DARK, "#5BC0BE", "#3A506B", "#6FFFE9", "#0B132B"),
    palette(KomikkuPaletteMood.DARK, "#C9ADA7", "#9A8C98", "#4A4E69", "#22223B"),
    palette(KomikkuPaletteMood.DARK, "#7B2CBF", "#5A189A", "#C77DFF", "#10002B"),
    palette(KomikkuPaletteMood.DARK, "#778DA9", "#415A77", "#E0E1DD", "#0D1B2A"),
    palette(KomikkuPaletteMood.DARK, "#BA181B", "#A4161A", "#E5383B", "#161A1D"),
    palette(KomikkuPaletteMood.DARK, "#DC2F02", "#9D0208", "#FFBA08", "#03071E"),
    palette(KomikkuPaletteMood.DARK, "#FCA311", "#E5E5E5", "#8D99AE", "#14213D"),
    palette(KomikkuPaletteMood.PASTEL, "#CCD5AE", "#E9EDC9", "#D4A373", "#FEFAE0"),
    palette(KomikkuPaletteMood.PASTEL, "#CDB4DB", "#FFAFCC", "#A2D2FF", "#BDE0FE"),
    palette(KomikkuPaletteMood.PASTEL, "#FFC4D6", "#FFA6C1", "#FF87AB", "#FADDE1"),
    palette(KomikkuPaletteMood.PASTEL, "#D8E2DC", "#FFCAD4", "#9D8189", "#FFE5D9"),
    palette(KomikkuPaletteMood.PASTEL, "#B8F2E6", "#AED9E0", "#FFA69E", "#FAF3DD"),
    palette(KomikkuPaletteMood.PASTEL, "#D6CCC2", "#E3D5CA", "#D5BDAF", "#F5EBE0"),
    palette(KomikkuPaletteMood.PASTEL, "#FEC5BB", "#FCD5CE", "#E8E8E4", "#FAE1DD"),
    palette(KomikkuPaletteMood.PASTEL, "#CDB4DB", "#FFC8DD", "#BDE0FE", "#A2D2FF"),
    palette(KomikkuPaletteMood.COLD, "#0077B6", "#00B4D8", "#90E0EF", "#CAF0F8"),
    palette(KomikkuPaletteMood.COLD, "#006D77", "#83C5BE", "#E29578", "#EDF6F9"),
    palette(KomikkuPaletteMood.COLD, "#023E8A", "#0096C7", "#48CAE4", "#ADE8F4"),
    palette(KomikkuPaletteMood.COLD, "#355070", "#6D597A", "#E56B6F", "#EAAC8B"),
    palette(KomikkuPaletteMood.COLD, "#22577A", "#38A3A5", "#57CC99", "#C7F9CC"),
    palette(KomikkuPaletteMood.COLD, "#05668D", "#028090", "#02C39A", "#F0F3BD"),
    palette(KomikkuPaletteMood.COLD, "#2B2D42", "#8D99AE", "#EF233C", "#EDF2F4"),
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
    neutral: String,
) = KomikkuPopularPalette(
    mood = mood,
    primary = color(primary),
    secondary = color(secondary),
    tertiary = color(tertiary),
    neutral = color(neutral),
)

private fun paletteScheme(
    palette: KomikkuPopularPalette,
    isDark: Boolean,
) = if (isDark) {
    val background = palette.neutral.blend(Color.Black, if (palette.mood == KomikkuPaletteMood.DARK) 0.72f else 0.82f)
    val surfaceContainer = palette.neutral.blend(Color.Black, 0.64f)
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
        outlineVariant = palette.neutral.blend(Color.White, 0.18f),
        surfaceContainerLowest = background.blend(Color.Black, 0.18f),
        surfaceContainerLow = background.blend(Color.White, 0.04f),
        surfaceContainer = surfaceContainer,
        surfaceContainerHigh = surfaceContainer.blend(Color.White, 0.07f),
        surfaceContainerHighest = surfaceContainer.blend(Color.White, 0.13f),
    )
} else {
    val background = palette.neutral.blend(Color.White, 0.84f)
    val surfaceContainer = palette.neutral.blend(Color.White, 0.72f)
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
        outlineVariant = palette.neutral.blend(Color.Black, 0.16f),
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
