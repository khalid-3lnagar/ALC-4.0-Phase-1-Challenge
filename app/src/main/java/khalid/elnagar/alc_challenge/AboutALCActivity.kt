package khalid.elnagar.alc_challenge

import android.net.http.SslError
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.webkit.SslErrorHandler
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_about_alc.*


const val ABOUT_ALC_URL = "https://andela.com/alc/"

class AboutALCActivity : AppCompatActivity() {

    private val client by lazy {
        object : WebViewClient() {
            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                showAlertDialog(handler)
            }

        }
    }

    private fun showAlertDialog(handler: SslErrorHandler?) {
        AlertDialog.Builder(this@AboutALCActivity)
            .apply {
                setMessage(R.string.notification_error_ssl_cert_invalid)
                setPositiveButton("continue") { _, _ -> handler?.proceed() }
                setNegativeButton("cancel") { _, _ -> handler?.cancel() }
            }
            .let { it.create() }
            .show()
    }

    private val chromeClient by lazy {
        object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                pb_loading.visibility = when (newProgress) {
                    in 0..99 -> {
                        pb_loading.progress = newProgress
                        View.VISIBLE
                    }
                    else -> View.GONE

                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_alc)
        title = getString(R.string.about_alc)
        pb_loading.max = 100
        with(web_about_alc) {
            settings.javaScriptEnabled = true
            webViewClient = client
            webChromeClient = chromeClient
            web_about_alc.loadUrl(ABOUT_ALC_URL)

        }


    }

}


