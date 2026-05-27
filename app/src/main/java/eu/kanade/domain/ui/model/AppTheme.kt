package eu.kanade.domain.ui.model

import dev.icerock.moko.resources.StringResource

enum class AppTheme(
    val titleRes: StringResource? = null,
    val title: String? = null,
    val coolorsPaletteIndex: Int = 0,
) {
    KOMIKKU(title = "Neon Sunshine Bliss", coolorsPaletteIndex = 0),
    FIERY_ARCTIC_MIDNIGHT(title = "Fiery Arctic Midnight", coolorsPaletteIndex = 1),
    ETHEREAL_IVORY_DREAMS(title = "Ethereal Ivory Dreams", coolorsPaletteIndex = 2),
    OCEAN_BREEZE(title = "Ocean Breeze", coolorsPaletteIndex = 3),
    SUNNY_PEACHY_VIBES(title = "Sunny Peachy Vibes", coolorsPaletteIndex = 4),
    MOONLIT_OCEAN(title = "Moonlit Ocean", coolorsPaletteIndex = 5),
    STARRY_NIGHT_SERENADE(title = "Starry Night Serenade", coolorsPaletteIndex = 6),
    MYSTICAL_FAIRY_TALE(title = "Mystical Fairy Tale", coolorsPaletteIndex = 7),
    LEMON_ZEST_DELIGHT(title = "Lemon Zest Delight", coolorsPaletteIndex = 8),
    OCEAN_BLUE_SERENITY(title = "Ocean Blue Serenity", coolorsPaletteIndex = 9),
    SUNSET_FLAMENCO_DANCE(title = "Sunset Flamenco Dance", coolorsPaletteIndex = 10),
    SUMMER_SORBET_SPLASH(title = "Summer Sorbet Splash", coolorsPaletteIndex = 11),
    DARK_FOREST_GLOW(title = "Dark Forest Glow", coolorsPaletteIndex = 12),
    MERMAID_BUBBLEGUM_FANTASY(title = "Mermaid Bubblegum Fantasy", coolorsPaletteIndex = 13),
    WHIMSICAL_LAVENDER_DREAMS(title = "Whimsical Lavender Dreams", coolorsPaletteIndex = 14),
    MIDNIGHT_BLUE_SERENADE(title = "Midnight Blue Serenade", coolorsPaletteIndex = 15),
    DEEP_SEA_CITRUS(title = "Deep Sea Citrus", coolorsPaletteIndex = 16),
    CHERRY_OCEAN_SUNSET(title = "Cherry Ocean Sunset", coolorsPaletteIndex = 17),
    COZY_EARTH_TONES(title = "Cozy Earth Tones", coolorsPaletteIndex = 18),
    GREEN_ENCHANTED_FOREST(title = "Green Enchanted Forest", coolorsPaletteIndex = 19),
    PASTEL_DREAMY_TRIO(title = "Pastel Dreamy Trio", coolorsPaletteIndex = 20),
    AUTUMN_NIGHT_SKY(title = "Autumn Night Sky", coolorsPaletteIndex = 21),
    PURPLE_SUNSET_GLOW(title = "Purple Sunset Glow", coolorsPaletteIndex = 22),
    BOLD_FIRE_GLOW(title = "Bold Fire Glow", coolorsPaletteIndex = 23),
    VIBRANT_SUMMER_SKY(title = "Vibrant Summer Sky", coolorsPaletteIndex = 24),
    SANDY_BEACH_RETREAT(title = "Sandy Beach Retreat", coolorsPaletteIndex = 25),
    OCEAN_SUNSET_BLISS(title = "Ocean Sunset Bliss", coolorsPaletteIndex = 26),
    FIERY_NIGHT_SKY(title = "Fiery Night Sky", coolorsPaletteIndex = 27),
    FIESTA_FEVER_FUN(title = "Fiesta Fever Fun", coolorsPaletteIndex = 28),
    SUNSET_BEACH_PARTY(title = "Sunset Beach Party", coolorsPaletteIndex = 29),
    OCEANIC_MINTY_SPLASH(title = "Oceanic Minty Splash", coolorsPaletteIndex = 30),
    DISCO_STARLIGHT_PARTY(title = "Disco Starlight Party", coolorsPaletteIndex = 31),
    PASTEL_DREAMLAND_ADVENTURE(title = "Pastel Dreamland Adventure", coolorsPaletteIndex = 32),
    TROPICAL_SUNSET_SERENADE(title = "Tropical Sunset Serenade", coolorsPaletteIndex = 33),
    SUNRISE_GLOW(title = "Sunrise Glow", coolorsPaletteIndex = 34),
    SANDY_FOREST_MORNING(title = "Sandy Forest Morning", coolorsPaletteIndex = 35),
    CHERRY_LEMON_SKY(title = "Cherry Lemon Sky", coolorsPaletteIndex = 36),
    SERENE_BLUE_SKY(title = "Serene Blue Sky", coolorsPaletteIndex = 37),
    MYSTIC_GOLDEN_GLOW(title = "Mystic Golden Glow", coolorsPaletteIndex = 38),
    SUNSET_BLAZE_FUSION(title = "Sunset Blaze Fusion", coolorsPaletteIndex = 39),

    // Legacy themes kept for preference compatibility. They now resolve to the Komikku theme.
    DEFAULT,
    MONET,

    // Kuukiyomi themes
    CUSTOM,

    // Aniyomi themes
    COTTONCANDY,
    MOCHA,

    CATPPUCCIN,
    GREEN_APPLE,
    LAVENDER,
    MIDNIGHT_DUSK,
    NORD,
    STRAWBERRY_DAIQUIRI,
    TAKO,
    TEALTURQUOISE,
    TIDAL_WAVE,
    YINYANG,
    YOTSUBA,
    MONOCHROME,

    // Aniyomi themes
    CLOUDFLARE,
    DOOM,
    MATRIX,
    SAPPHIRE,

    // Deprecated
    DARK_BLUE,
    HOT_PINK,
    BLUE,

    // SY -->
    PURE_RED,
    // SY <--

    ;

    val isSelectable: Boolean
        get() = titleRes != null || title != null
}
