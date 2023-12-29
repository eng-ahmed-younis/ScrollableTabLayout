package com.example.tablayout_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tablayout_compose.ui.screens.scrollable_tab.ScrollableTabLayoutScreen
import com.example.tablayout_compose.ui.theme.TabLayout_ComposeTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TabLayout_ComposeTheme {
                TabLayoutApplication()
            }
        }
    }
}

@Composable
fun TabLayoutApplication(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val viewModel : MainViewModel =  koinViewModel<MainViewModel>()
        ScrollableTabLayoutScreen(viewModel = viewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun TabLayoutApplicationPreview() {
    TabLayout_ComposeTheme {
        TabLayoutApplication()
    }
}