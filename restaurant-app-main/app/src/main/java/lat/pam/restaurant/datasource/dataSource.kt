package lat.pam.restaurant.datasource

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import lat.pam.restaurant.R

data class dataMenus (
    val name: String,
    val price: String,
    val image1: Painter,
    val image2: Painter,
    val desc1: String,
    val desc2: String

)



