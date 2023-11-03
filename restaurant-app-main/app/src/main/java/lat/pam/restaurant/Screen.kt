package lat.pam.restaurant

sealed class Screen (val route: String) {
    object StartOrder: Screen ("start_order")
    object StoreScreen: Screen ("store_screen")
    object MenuScreen : Screen ("menu_screen")
    object MenuDetail : Screen ("menu_detail")
    object OrderDetail : Screen ("order_detail")
}
