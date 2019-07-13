package khalid.elnagar.alc_challenge

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_my_profile.setOnClickListener { startMyProfile() }
        btn_about_alc.setOnClickListener { startAboutALC() }
    }

    private fun startMyProfile() {
        Intent(this, MyProfileActivity::class.java).also(::startActivity)
    }

    private fun startAboutALC() {
        Intent(this, AboutALCActivity::class.java).also(::startActivity)
    }
}
