package khalid.elnagar.alc_challenge

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MyProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_profile)
        title = getString(R.string.my_profile)
    }
}
