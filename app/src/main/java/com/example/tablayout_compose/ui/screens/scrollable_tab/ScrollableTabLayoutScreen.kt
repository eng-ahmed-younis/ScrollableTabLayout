package com.example.tablayout_compose.ui.screens.scrollable_tab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tablayout_compose.MainViewModel
import com.example.tablayout_compose.ui.screens.AboutScreen
import com.example.tablayout_compose.ui.screens.HomeScreen
import com.example.tablayout_compose.ui.screens.SettingScreen
import com.example.tablayout_compose.utils.ScrollTabs
import com.example.tablayout_compose.utils.Tabs
import org.koin.androidx.compose.inject
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScrollableTabLayoutScreen(
viewModel: MainViewModel
) {

    val tabIndex  by viewModel.tabIndex.collectAsState()

    Column (
        modifier = Modifier.fillMaxSize()
    ){
        ScrollableTabRow(selectedTabIndex = tabIndex) {
           ScrollTabs.values().forEachIndexed { index, title ->
           // tabs.forEachIndexed { index, title ->
                Tab(
                   text = {
                       Text(text = title.name)
                   } ,
                    selected = tabIndex == index,
                    onClick = {
                           viewModel.updateTabIndex(index)
                    },
                    icon = {
                        when(index){
                            0-> {
                                Icon(
                                    imageVector = Icons.Outlined.Home,
                                    contentDescription = "home"
                                )
                            }
                            1-> {
                                Icon(
                                    imageVector = Icons.Outlined.Settings,
                                    contentDescription = "Settings"
                                )
                            }
                            2-> {
                                Icon(
                                    imageVector = Icons.Outlined.Info,
                                    contentDescription = "Info"
                                )
                            }
                            3->{
                                Icon(
                                    imageVector = Icons.Outlined.Lock,
                                    contentDescription = "more"
                                )
                            }
                            4->{
                                Icon(
                                    imageVector = Icons.Outlined.Star,
                                    contentDescription = "SOMETHING"
                                )
                            }
                            5->{
                                Icon(
                                    imageVector = Icons.Outlined.Email,
                                    contentDescription = "everything"
                                )
                            }
                        }
                    }
                )
            }


        }

        when(tabIndex){
            0->{
                HomeScreen()
               }
            1->{
            AboutScreen()
            }
            2->{
                SettingScreen()
            }
            3->{
                SettingScreen()
            }
            4->{
                SettingScreen()
            }
            5->{
                SettingScreen()
            }
        }
    }


}



@Composable
@Preview(showBackground = true , showSystemUi = true)
fun TabLayoutScreenPreview() {
    ScrollableTabLayoutScreen(
        viewModel = koinViewModel<MainViewModel>()
    )
}