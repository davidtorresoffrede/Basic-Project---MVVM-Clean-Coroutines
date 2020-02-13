package d.offrede.base.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import d.offrede.base.R
import kotlinx.android.synthetic.main.activity_container.*
import kotlinx.android.synthetic.main.include_toolbar.toolbar

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_container)
        setSupportActionBar(toolbar)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun setContentView(layoutResID: Int) {
        layoutInflater.inflate(layoutResID, activityContainer, true)
    }
}