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
import kotlinx.android.synthetic.main.include_progress.*
import kotlinx.android.synthetic.main.include_toolbar.toolbar

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_container)
        setSupportActionBar(toolbar)
        observeLoading()
        observeFailure()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun setContentView(layoutResID: Int) {
        layoutInflater.inflate(layoutResID, activityContainer, true)
    }

    open fun baseViewModel(): BaseViewModel? = null

    protected fun observeLoading() {
        baseViewModel()?.loadingLiveData()?.observe(this, Observer<ViewModelResult.Loading> {
            when (it.show) {
                true -> {
                    progress.visible()
                    activityContainer.invisible()
                }
                false -> {
                    progress.gone()
                    activityContainer.visible()
                }
            }
        })
    }

    protected fun observeFailure() {
        baseViewModel()?.failureLiveData()?.observe(this, Observer<ViewModelResult.Failure> {



        })
    }

}