package eu.kanade.presentation.category.components

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallExtendedFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tachiyomi.i18n.MR
import tachiyomi.presentation.core.i18n.stringResource
import tachiyomi.presentation.core.util.shouldExpandFAB

@Composable
fun CategoryFloatingActionButton(
    lazyListState: LazyListState,
    onCreate: () -> Unit,
    modifier: Modifier = Modifier,
) {
    SmallExtendedFloatingActionButton(
        text = { Text(text = stringResource(MR.strings.action_add)) },
        icon = { Icon(imageVector = Icons.Outlined.Add, contentDescription = null) },
        onClick = onCreate,
        expanded = lazyListState.shouldExpandFAB(),
        shape = RoundedCornerShape(28.dp),
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        modifier = modifier,
    )
}
