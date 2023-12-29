package com.example.tablayout_compose.ui.screens.tab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tablayout_compose.ui.screens.AboutScreen
import com.example.tablayout_compose.ui.screens.HomeScreen
import com.example.tablayout_compose.ui.screens.SettingScreen
import com.example.tablayout_compose.utils.Tabs
import org.w3c.dom.Text

@Composable
fun TabLayoutScreen() {
    var tabIndex by remember {
        mutableStateOf(0)
    }

    val tabs = listOf(
        "Home","Setting","About"
    )


    Column (
        modifier = Modifier.fillMaxSize()
    ){
        TabRow(selectedTabIndex = tabIndex) {
           Tabs.values().forEachIndexed { index, title ->
           // tabs.forEachIndexed { index, title ->
                Tab(
                   text = {
                       Text(text = title.name)
                   } ,
                    selected = tabIndex == index,
                    onClick = {
                        tabIndex ==  index
                    },
                    icon = {
                        when(tabIndex){
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
                            0-> {
                                Icon(
                                    imageVector = Icons.Outlined.Info,
                                    contentDescription = "Info"
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
        }
    }


}



@Composable
@Preview(showBackground = true , showSystemUi = true)
fun TabLayoutScreenPreview() {
    TabLayoutScreen()
}