package eu.kanade.presentation.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

// KMK -->
internal val KomikkuFigmaShapes = Shapes(
    extraSmall = RoundedCornerShape(10.dp),
    small = RoundedCornerShape(16.dp),
    medium = RoundedCornerShape(22.dp),
    large = RoundedCornerShape(28.dp),
    extraLarge = RoundedCornerShape(36.dp),
)

@Composable
internal fun rememberKomikkuFigmaTypography(): Typography {
    val base = MaterialTheme.typography
    return remember(base) {
        base.copy(
            displayLarge = base.displayLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 56.sp,
                lineHeight = 0.95.em,
                letterSpacing = 0.sp,
            ),
            displayMedium = base.displayMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 44.sp,
                lineHeight = 0.98.em,
                letterSpacing = 0.sp,
            ),
            headlineLarge = base.headlineLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                lineHeight = 1.02.em,
                letterSpacing = 0.sp,
            ),
            headlineMedium = base.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                lineHeight = 1.05.em,
                letterSpacing = 0.sp,
            ),
            headlineSmall = base.headlineSmall.copy(
                fontWeight = FontWeight.SemiBold,
                fontSize = 26.sp,
                lineHeight = 1.08.em,
                letterSpacing = 0.sp,
            ),
            titleLarge = base.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                lineHeight = 1.1.em,
                letterSpacing = 0.sp,
            ),
            titleMedium = base.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                lineHeight = 1.12.em,
                letterSpacing = 0.sp,
            ),
            titleSmall = base.titleSmall.copy(
                fontWeight = FontWeight.SemiBold,
                lineHeight = 1.12.em,
                letterSpacing = 0.sp,
            ),
            labelLarge = base.labelLarge.copy(fontWeight = FontWeight.Bold, letterSpacing = 0.sp),
            labelMedium = base.labelMedium.copy(fontWeight = FontWeight.Bold, letterSpacing = 0.sp),
            bodyLarge = base.bodyLarge.copy(letterSpacing = 0.sp),
            bodyMedium = base.bodyMedium.copy(letterSpacing = 0.sp),
            bodySmall = base.bodySmall.copy(letterSpacing = 0.sp),
        )
    }
}
// KMK <--
