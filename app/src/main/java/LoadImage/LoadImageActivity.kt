package LoadImage

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.andersentask3.R
import java.io.IOException
import java.net.URL


class LoadImageActivity : AppCompatActivity() {

    private lateinit var linkET: EditText
    private lateinit var loadIV: ImageView
    private lateinit var loadButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.image_load_activity)
        linkET = findViewById(R.id.LinkEditText)
        loadIV = findViewById(R.id.LoadImageView)
        loadButton = findViewById(R.id.LoadButton)
    }

    fun setImage(view: View) {
        try {
            val url = URL("https://i.picsum.photos/id/237/200/300.jpg?hmac=TmmQSbShHz9CdQm0NkEjx1Dyh_Y984R9LpNrpvH2D_U")
            var mIcon_val = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            loadIV.setImageBitmap(mIcon_val)
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show()
        }
    }
}