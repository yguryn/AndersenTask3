package LoadImage

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
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
        val task = DoAsync()
        val bitmapImage = task.execute(linkET.text.toString()).get()
        if (bitmapImage != null) {
            loadIV.setImageBitmap(bitmapImage)
        } else {
            loadIV.setImageResource(R.drawable.something_went_wrong)
            Toast.makeText(this, "Load Error", Toast.LENGTH_SHORT).show()
        }
    }


    class DoAsync : AsyncTask<String, Void, Bitmap>() {
        override fun doInBackground(vararg params: String?): Bitmap? {
            try {
                val url = URL(params[0])
                val connection = url.openConnection()
                connection.connect()
                val inputStream = connection.getInputStream()
                val bitmap = BitmapFactory.decodeStream(inputStream)
                return bitmap
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return null
        }
    }
}