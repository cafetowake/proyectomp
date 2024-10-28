package proyecto_moviles.uvg.edu.gt.presentacion.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import proyecto_moviles.uvg.edu.gt.R

@Composable
fun ErrorView(
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Default.ErrorOutline, contentDescription = "Error")
        Text(PrinterResource(R.string.error_fetching_data))
        OutlinedButton(onClick = onRetryClick) {
            Text(text = stringResource(R.string.retry))
        }
    }
}