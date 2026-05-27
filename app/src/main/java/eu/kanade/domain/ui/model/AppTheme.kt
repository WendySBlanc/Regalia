package eu.kanade.domain.ui.model

import dev.icerock.moko.resources.StringResource
import tachiyomi.i18n.kmk.KMR

enum class AppTheme(val titleRes: StringResource?) {
    KOMIKKU(KMR.strings.theme_komikku_2026),

    // Legacy themes kept for preference compatibility. They now resolve to the Komikku theme.
    DEFAULT(null),
    MONET(null),

    // Kuukiyomi themes
    CUSTOM(null),

    // Aniyomi themes
    COTTONCANDY(null),
    MOCHA(null),

    CATPPUCCIN(null),
    GREEN_APPLE(null),
    LAVENDER(null),
    MIDNIGHT_DUSK(null),
    NORD(null),
    STRAWBERRY_DAIQUIRI(null),
    TAKO(null),
    TEALTURQUOISE(null),
    TIDAL_WAVE(null),
    YINYANG(null),
    YOTSUBA(null),
    MONOCHROME(null),

    // Aniyomi themes
    CLOUDFLARE(null),
    DOOM(null),
    MATRIX(null),
    SAPPHIRE(null),

    // Deprecated
    DARK_BLUE(null),
    HOT_PINK(null),
    BLUE(null),

    // SY -->
    PURE_RED(null),
    // SY <--
}
