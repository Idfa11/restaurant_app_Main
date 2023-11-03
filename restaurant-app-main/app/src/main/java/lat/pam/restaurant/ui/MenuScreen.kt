package lat.pam.restaurant.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import lat.pam.restaurant.R
import lat.pam.restaurant.Screen
import lat.pam.restaurant.datasource.dataMenus


@Composable
fun MenuScreen(navController: NavController, data: MutableList<String>, menu: MutableList<String>) {
    val listfOfMenu = listOf(
        dataMenus(
            "Pepperoni Pizza",
            "66.000,00",
            painterResource(id = R.drawable.pepperoni_pizza),
            painterResource(id = R.drawable.pepperoni_pizza_2),
            "Cocok bagi anda yang ingin merasakan pizza original dengan taburan keju dan daging asap yang lezat",
            "Pepperoni pizza adalah pizza yang memiliki  topping daging pepperoni sapi asli. Di Italia, pepperoni disebut salame piccante (salami panas). Biasa menjadi bahan baku pizza di Amerika Serikat, yang sering mewakili 30% pelengkap. Pizza ini cocok untuk santap siang ataupun malam anda"
        ),
        dataMenus(
            "Spaghetti",
            "50.000,00",
            painterResource(id = R.drawable.spaghetti),
            painterResource(id = R.drawable.sphagetti_2),
            "Cocok bagi anda yang ingin merasakan spaghetti original dengan bumbu yang oriental",
            "Spaghetti adalah sejenis pasta yang terbuat dari tepung terigu, air, dan telur. Pasta ini berasal dari Italia dan menjadi salah satu makanan yang populer di seluruh dunia. Spaghetti biasanya disajikan dengan berbagai macam saus, seperti saus tomat, saus bolognese, atau saus carbonara."
        ),
        dataMenus(
            "Burger",
            "20.000,00",
            painterResource(id = R.drawable.burger),
            painterResource(id = R.drawable.burger_2),
            "Cocok bagi anda yang ingin merasakan kelembutan burger berlapiskan keju, sayuran dan daging yang tebal",
            "Burger atau hamburger adalah sejenis sandwich yang terdiri dari patty yang terbuat dari daging cincang, biasanya sapi, yang diletakkan di dalam roti atau roti gulung yang dipotong. Patty biasanya dibumbui dengan garam dan merica dan dapat dimasak dengan berbagai cara, seperti dipanggang, digoreng, atau dibakar. Keju, selada, tomat, bawang bombai, acar, dan saus seperti ketchup dan mustard adalah topping umum untuk burger"
        ),
        dataMenus(
            "Steak",
            "200.000,00",
            painterResource(id = R.drawable.steak),
            painterResource(id = R.drawable.steak_2),
            "Cocok bagi anda yang ingin merasakan lezatnya daging steak dipadukan dengan kentang yang lezat",
            "Steak adalah sepotong daging yang tebal yang biasanya dipotong melintang serat otot, kadang-kadang termasuk tulang. Steak biasanya dipanggang atau digoreng dan dapat dihidangkan dengan berbagai macam saus, seperti saus bawang putih, saus bernaise, atau saus lada hitam. Keju, jamur, dan bawang bombai juga sering digunakan sebagai topping untuk steak "
        )
    )

    var selectedMenu by remember {
        mutableStateOf(-1)
    }

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),

        ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.outline_person_24),
                contentDescription = "",
                modifier = Modifier
                    .size(30.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Hello, ${data[0]}",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }

        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 10.dp)
        ) {
            items(listfOfMenu.size) { index ->
                Spacer(modifier = Modifier.height(30.dp))
                Row (
                    modifier = Modifier
                        .clickable { selectedMenu = index }
                        .background(
                            if (selectedMenu == index) colorResource(id = R.color.grey_400)
                            else Color.Transparent
                        )

                ) {
                    Image(
                        painter = listfOfMenu[index].image1,
                        contentDescription = "steak",
                        modifier = Modifier
                            .size(120.dp)
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .height(120.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = listfOfMenu[index].name,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.brown)
                        )
                        Text(
                            text = listfOfMenu[index].desc1,
                            fontSize = 16.sp,
                            color = colorResource(R.color.brown)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(50.dp))
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxWidth()
        ) {
            IconButton(
                onClick = {
                    menu.add(0, listfOfMenu[selectedMenu].name)
                    menu.add(1, listfOfMenu[selectedMenu].price)
//                    menu.add(2, listfOfMenu[selectedMenu].image2)
                    menu.add(2, listfOfMenu[selectedMenu].desc2)
                    navController.navigate(Screen.MenuDetail.route)
                },
                modifier = Modifier
                    .clip(CircleShape)
                    .background(colorResource(R.color.red))
                    .size(70.dp),
            ) {
                Icon(
                    painter = painterResource(R.drawable.outline_add_24),
                    contentDescription = "ic",
                    tint = Color.White,
                    modifier = Modifier
                        .size(60.dp)
                )
            }

        }
    }
}
