package com.file.saurabh.byline.Utils


import android.content.Context
import android.widget.ImageView
import com.file.saurabh.byline.R
import com.pixplicity.sharp.Sharp
import okhttp3.*
import java.io.IOException
import java.io.InputStream

object SVGUtils {
    private var httpClient: OkHttpClient? = null

    // this method is used to fetch svg and load it into target imageview.
    fun fetchSvg(context: Context, url: String?, target: ImageView) {
        if (httpClient == null) {
            httpClient = OkHttpClient.Builder()
                    .cache(Cache(context.getCacheDir(), 5 * 1024 * 1014))
                    .build()
        }

        // here we are making HTTP call to fetch data from URL.
        val request: Request = Request.Builder().url(url).build()
        httpClient!!.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                // we are adding a default image if we gets any error.
                target.setImageResource(R.drawable.ic_baseline_image_not_supported_24)
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call?, response: Response) {
                // sharp is a library which will load stream which we generated
                // from url in our target imageview.
                val stream: InputStream? = response.body()?.byteStream()
                Sharp.loadInputStream(stream).into(target)
                stream?.close()
            }
        })
    }
}