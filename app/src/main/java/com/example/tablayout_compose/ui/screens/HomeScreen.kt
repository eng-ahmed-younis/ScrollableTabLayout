package com.example.tablayout_compose.ui.screens

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.tablayout_compose.MainViewModel
import org.koin.androidx.compose.inject
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen() {
    val viewModel: MainViewModel = koinViewModel<MainViewModel>()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .draggable(
                state = viewModel.dragState.collectAsState().value,
                orientation = Orientation.Horizontal,
                onDragStarted = { },
                onDragStopped = {
                    viewModel.updateTabIndexBasedOnSwipe()
                }),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "Home",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
@Preview(showSystemUi = true)
fun HomeScreenPreview() {
    HomeScreen()
}
