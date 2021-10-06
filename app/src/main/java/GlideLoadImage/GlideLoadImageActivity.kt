package GlideLoadImage

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.andersentask3.R


class GlideLoadImageActivity : AppCompatActivity() {

    private lateinit var linkET: EditText
    private lateinit var loadIV: ImageView
    private lateinit var loadButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.image_load_glide_activity)
        linkET = findViewById(R.id.GlideEditText)
        loadIV = findViewById(R.id.GlideImageView)
        loadButton = findViewById(R.id.GlideButton)
    }

    
    fun setImage(view: View) {
        val options: RequestOptions = RequestOptions()
            .error(R.drawable.something_went_wrong)
            .centerCrop()
        Glide.with(this).load(linkET.text.toString()).apply(options).into(loadIV)
    }
}