package com.example.tablayout_compose
/*
* composable screen with table layout two ways two scroll
* 1- scroll by click on tabs to navigate between tabs
* 2- scrollable with screens by OnSwipe <- ->
*
*
* by clicked =  fun updateTabIndex(i: Int) {
        _tabIndex.value = i
    }
    * do on tablealAYOUT SCREEN
    *
    *
    *
    *
* by OnSwipe =   fun updateTabIndexBasedOnSwipe(isSwipeToTheLeft: Boolean) {
        _tabIndex.value = when (isSwipeToTheLeft) {
            true -> Math.floorMod(_tabIndex.value!!.plus(1), tabs.size)
            false -> Math.floorMod(_tabIndex.value!!.minus(1), tabs.size)
        }
    }
* do on screen itself
*
*
* */