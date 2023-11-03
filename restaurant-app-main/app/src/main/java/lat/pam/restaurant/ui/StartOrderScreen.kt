package lat.pam.restaurant.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import lat.pam.restaurant.R
import lat.pam.restaurant.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartOrderScreen(navController: NavController, data: MutableList<String>) {

    var nameTextFilled by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var store by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(75.dp))
        Image(
            painter = painterResource(R.drawable.icon_pizza_store),
            contentDescription = "pizza_store_icon",
            modifier = Modifier
                .size(250.dp)
        )

        Spacer(modifier = Modifier.height(60.dp))
        Column {
            Text(
                text = "Store",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.brown)
            )
            Spacer(modifier = Modifier.height(5.dp))
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = it }
            ) {
                TextField(
                    value = store,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.polygon_1),
                            contentDescription = null,
                            modifier = Modifier
                                .size(25.dp)
                        )
                    },
                    placeholder = { Text(text = "Select store") },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(
                        containerColor = Color.White,
                        placeholderColor = colorResource(R.color.grey_400),
                        focusedTrailingIconColor = colorResource(R.color.red),
                        unfocusedTrailingIconColor = colorResource(R.color.red)
                    ),
                    modifier = Modifier
                        .menuAnchor()
                        .width(300.dp)
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .background(Color.White)

                ) {
                    DropdownMenuItem(
                        text = { Text(text = "Cihampelas") },
                        onClick = {
                            store = "Cihampelas"
                            expanded = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Cibiru") },
                        onClick = {
                            store = "Cibiru"
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        Column {
            Text(
                text = "Your Name",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.brown)
            )
            Spacer(modifier = Modifier.height(5.dp))
            TextField(
                value = nameTextFilled,
                onValueChange = { nameTextFilled = it },
                placeholder = { Text("Please fill your name") },
                modifier = Modifier
                    .width(300.dp)
                    .height(50.dp)
                    .shadow(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    placeholderColor = colorResource(R.color.grey_400)
                )
            )
        }

        Spacer(modifier = Modifier.height(40.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = {
                    data.add(0, nameTextFilled)
                    data.add(1, store)
                    navController.navigate(Screen.StoreScreen.route)
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.red)),
                shape = RectangleShape,
                modifier = Modifier
                    .width(300.dp)
                    .align(CenterHorizontally)
                    .border(2.dp, color = colorResource(R.color.yellow))
                    .background(colorResource(id = R.color.red))
            ) {
                Text(
                    "Submit",
                    fontSize = 20.sp
                )
            }
        }
    }
}