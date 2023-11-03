package lat.pam.restaurant.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import lat.pam.restaurant.R
import lat.pam.restaurant.Screen

@Composable
fun MenuDetailScreen (navController: NavController, menu: MutableList<String>) {
    var imageMenuDetail: Painter = painterResource(id = R.drawable.store)
    if (menu[0] == "Pepperoni Pizza"){
         imageMenuDetail = painterResource(id = R.drawable.pepperoni_pizza_2)
    } else if (menu[0] == "Spaghetti") {
        imageMenuDetail = painterResource(id = R.drawable.sphagetti_2)
    }else if (menu[0] == "Burger") {
        imageMenuDetail = painterResource(id = R.drawable.burger_2)
    }else if (menu[0] == "Steak") {
        imageMenuDetail = painterResource(id = R.drawable.steak_2)
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box (
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomStart
        ) {
            Image(
                painter = imageMenuDetail,
                contentDescription ="image_menu_detail",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = menu[0],
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(horizontal = 30.dp, vertical = 10.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .align(Alignment.End)
        ) {
            Text(
                text = "Price: Rp ${menu[1]}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.brown)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = menu[2],
            modifier = Modifier
                .padding(horizontal = 20.dp),
            textAlign = TextAlign.Justify,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.brown)
        )

        Spacer(modifier = Modifier.height(60.dp))
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = {
                          navController.navigate(Screen.OrderDetail.route)
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.red)),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.CenterHorizontally)
                    .shadow(10.dp)
                    .border(2.dp, color = colorResource(R.color.yellow))
                    .background(colorResource(id = R.color.red))
            ) {
                Text(
                    "Order Now",
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    navController.navigate(Screen.MenuScreen.route)
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.red)),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.CenterHorizontally)
                    .border(2.dp, color = colorResource(R.color.yellow))
                    .background(colorResource(id = R.color.red))
            ) {
                Text(
                    "Back",
                    fontSize = 20.sp
                )
            }
        }

    }
}