package lat.pam.restaurant.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import lat.pam.restaurant.R

@Composable
fun OrderDetailScreen (data : MutableList<String> , menu: MutableList<String>){

    val checked = remember { mutableStateOf(0) }


    Column (
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Column (
            modifier = Modifier
                .padding(horizontal = 50.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Order Detail",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.brown)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Column (
                modifier = Modifier
            ) {
                Text(
                    text = data[0],
                    fontSize = 16.sp
                )
                Text(
                    text = "Store: ${data[1]}",
                    fontSize = 16.sp
                )
                Text(
                    text = "${menu[0]} Dipesan",
                    fontSize = 16.sp,
                )
            }

        }

        Spacer(modifier = Modifier.height(30.dp))
        Column (
            modifier =  Modifier
                .padding(horizontal = 50.dp)
        ) {
            Text(
                text = "Pengiriman",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.brown)
            )

            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = checked.value == 1,
                    onClick = {checked.value = 1},
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Blue,
                    ),

                    )
                Text(text = "Ambil Sendiri")

            }

            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = checked.value == 0,
                    onClick = {checked.value = 0},
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Blue
                    )

                    )
                Text(text = "Fast Delivery (minimal 30 menit sampai)")

            }

        }

        Spacer(modifier = Modifier.height(60.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.red)),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
                .align(Alignment.CenterHorizontally)
                .border(2.dp, color = colorResource(R.color.yellow))
                .background(colorResource(id = R.color.red))
        ) {
            Text(
                "Done",
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(100.dp))

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .background(colorResource(id = R.color.grey_200))
        ) {
            Text(
                text = "Terima kasih ${data[0]}, sudah memesan ditoko kami, pesanan ${menu[0]} anda dikirim menggunakan ${if (checked.value == 0) "Fast Delivery" else if (checked.value == 1) "Ambil Sendiri" else "{Silahkan Pilih}"} ",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 5.dp)

            )
        }
    }
}