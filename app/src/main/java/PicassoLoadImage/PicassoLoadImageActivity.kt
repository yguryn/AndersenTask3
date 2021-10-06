package PicassoLoadImage

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.andersentask3.R
import com.squareup.picasso.Picasso

class PicassoLoadImageActivity : AppCompatActivity() {
    private lateinit var linkET: EditText
    private lateinit var loadIV: ImageView
    private lateinit var loadButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.image_load_picasso_activity)
        linkET = findViewById(R.id.PicassoEditText)
        loadIV = findViewById(R.id.PicassoImageView)
        loadButton = findViewById(R.id.PicassoButton)
    }

    fun setImage(view: View) {
        Picasso.with(this)
            .load(linkET.text.toString())
            .into(loadIV);
    }
}