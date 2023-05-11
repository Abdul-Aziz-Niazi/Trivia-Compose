package com.abdulaziz.trivia.navigation
sealed class NavigationScreens(val route:String) {
    object Splash: NavigationScreens(route = "screen_splash")
    object Quiz: NavigationScreens(route = "screen_quiz/{index}/{category}"){
        fun withIndex(index:Int, category:Int):String{
            return route.replace("{index}",index.toString()).replace("{category}",category.toString())
        }
    }
    object Result: NavigationScreens(route = "screen_result/{correct}"){
        fun withResult(correct:Int):String{
            return route.replace("{correct}",correct.toString())
        }
    }
}