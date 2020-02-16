package d.offrede.base.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import d.offrede.base.R
import d.offrede.base.extension.gone
import d.offrede.base.extension.invisible
import d.offrede.base.extension.visible
import d.offrede.base.viewmodel.BaseViewModel
import kotlinx.android.synthetic.main.activity_container.*
import kotlinx.android.synthetic.main.include_empty.*
import kotlinx.android.synthetic.main.include_failure.*
import kotlinx.android.synthetic.main.include_progress.*
import kotlinx.android.synthetic.main.include_toolbar.*

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_container)
        configureLayouts()
        setSupportActionBar(toolbar)
        startObserves()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun setContentView(layoutResID: Int) {
        layoutInflater.inflate(layoutResID, activityContainer, true)
    }

    open fun baseViewModel(): BaseViewModel? = null

    open fun loadingLayout(): Int = R.layout.include_progress

    open fun toolbarLayout(): Int = R.layout.include_toolbar

    open fun failureLayout(): Int = R.layout.include_failure

    open fun emptyLayout(): Int = R.layout.include_empty

    protected fun observeFailure() {
        baseViewModel()?.failureLiveData()?.observe(this, {
            includeFailureText.text = it.message
            failureContainer.visible()
        }, {
            failureContainer.invisible()
        }, {
            failureContainer.gone()
        })
    }

    protected fun observeEmpty() {
        baseViewModel()?.emptyLiveData()?.observe(this, {
            includeEmptyText.text = it.message
            emptyContainer.visible()
        }, {
            emptyContainer.invisible()
        }, {
            emptyContainer.gone()
        })
    }

    protected fun observeLoading() {
        baseViewModel()?.loadingLiveData()?.observe(this, {
            includeProgressText.text = it.message
            progressContainer.visible()
        }, {
            progressContainer.invisible()
        }, {
            progressContainer.gone()
        })
    }

    private fun configureLayouts() {
        configureToolbarLayout()
        configureFailureLayout()
        configureEmptyLayout()
        configureLoadingLayout()
    }

    private fun startObserves() {
        observeLoading()
        observeFailure()
        observeEmpty()
    }

    private fun configureLoadingLayout() {
        layoutInflater.inflate(loadingLayout(), progressContainer, true)
    }

    private fun configureToolbarLayout() {
        layoutInflater.inflate(toolbarLayout(), toolbarContainer, true)
    }

    private fun configureFailureLayout() {
        layoutInflater.inflate(failureLayout(), failureContainer, true)
    }

    private fun configureEmptyLayout() {
        layoutInflater.inflate(emptyLayout(), emptyContainer, true)
    }

}