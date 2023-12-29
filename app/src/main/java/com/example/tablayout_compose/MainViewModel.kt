package com.example.tablayout_compose

import androidx.compose.foundation.gestures.DraggableState
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.example.tablayout_compose.utils.ScrollTabs
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel :ViewModel(){


    //tabIndex is in charge of holding the currently selected index.
    var tabIndex: MutableStateFlow<Int> = MutableStateFlow(0)
        private set

    var isSwipeToTheLeft: Boolean = false

    private val draggableState = DraggableState { delta ->
        isSwipeToTheLeft = delta > 0
    }

     var dragState = MutableStateFlow<DraggableState>(draggableState)
         private set



    // ScrollTabs is the list of tab names.
    /** The method updateTabIndexBasedOnSwipe is triggered when a swipe happens
     * and performs the calculation of where to move the tabIndex to.
     */
    fun updateTabIndexBasedOnSwipe() {
        tabIndex.value = when (isSwipeToTheLeft) {
            true -> Math.floorMod(tabIndex.value.plus(1), ScrollTabs.values().size)
            false -> Math.floorMod(tabIndex.value.minus(1), ScrollTabs.values().size)
        }
    }

    fun updateTabIndex(index: Int) {
        tabIndex.value = index
    }
}