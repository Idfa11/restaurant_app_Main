package lat.pam.restaurant

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import lat.pam.restaurant.ui.MenuDetailScreen
import lat.pam.restaurant.ui.MenuScreen
import lat.pam.restaurant.ui.OrderDetailScreen
import lat.pam.restaurant.ui.StartOrderScreen
import lat.pam.restaurant.ui.StoreScreen

@Composable
fun Navigation () {

    val orders = remember {
        mutableListOf<String>()
    }

    val menu = remember {
        mutableListOf<String>()
    }

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.StartOrder.route ){
        composable(route = Screen.StartOrder.route){
            StartOrderScreen(navController = navController, data = orders)
        }
        composable(route = Screen.StoreScreen.route){
            StoreScreen(navController = navController, data = orders)
        }
        composable(route = Screen.MenuScreen.route){
            MenuScreen(navController = navController, data = orders, menu = menu)
        }
        composable(route = Screen.MenuDetail.route){
            MenuDetailScreen(navController = navController, menu = menu)
        }
        composable(route = Screen.OrderDetail.route){
            OrderDetailScreen(data = orders, menu = menu)
        }
    }

}