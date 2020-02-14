package d.offrede.base.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import d.offrede.base.R
import d.offrede.base.extension.gone
import d.offrede.base.extension.invisible
import d.offrede.base.extension.visible
import d.offrede.base.viewmodel.BaseViewModel
import d.offrede.base.viewmodel.ViewModelResult
import kotlinx.android.synthetic.main.activity_container.*
import kotlinx.android.synthetic.main.include_toolbar.toolbar

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_container)
        setSupportActionBar(toolbar)
        observeLoading()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun setContentView(layoutResID: Int) {
        layoutInflater.inflate(layoutResID, activityContainer, true)
        layoutInflater.inflate(layoutLoading(), progressContainer, true)
    }

    open fun baseViewModel(): BaseViewModel? = null

    open fun layoutLoading(): Int = R.layout.include_progress

    protected fun observeLoading() {
        baseViewModel()?.loadingLiveData()?.observe(this, Observer<ViewModelResult.Loading> {
            when (it.show) {
                true -> {
                    progressContainer.visible()
                    activityContainer.invisible()
                }
                false -> {
                    progressContainer.gone()
                    activityContainer.visible()
                }
            }
        })
    }

}