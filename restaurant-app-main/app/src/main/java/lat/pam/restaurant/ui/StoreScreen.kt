package lat.pam.restaurant.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import lat.pam.restaurant.R
import lat.pam.restaurant.Screen

@Composable
fun StoreScreen(navController: NavController, data : MutableList<String>) {

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
        Image(
            painter = painterResource(R.drawable.store),
            contentDescription = "store",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))

        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "Store",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.brown)
            )
            Text(
                text = data[1],
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.brown)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)

        ) {
            Text(
                text = "Location",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.brown)
            )
            Row (
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Find on Maps",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.brown)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Icon(
                    painter = painterResource(R.drawable.pin_maps) ,
                    contentDescription = "",
                    modifier = Modifier
                        .size(26.dp),
                    colorResource(R.color.brown)

                )
            }

        }

        Spacer(modifier = Modifier.height(40.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
//                .padding(horizontal = 20.dp)
        ) {
            Button(
                onClick = {
                          navController.navigate(Screen.MenuScreen.route)
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.red)),
                shape = RectangleShape,
                modifier = Modifier
                    .width(350.dp)
                    .align(Alignment.CenterHorizontally)
                    .border(2.dp, color = colorResource(R.color.yellow))
                    .background(colorResource(id = R.color.red))
            ) {
                Text(
                    "See Menus",
                    fontSize = 20.sp
                )
            }
        }
    }


}
