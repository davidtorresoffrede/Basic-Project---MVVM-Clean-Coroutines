package d.offrede.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import d.offrede.base.R
import d.offrede.base.extension.gone
import d.offrede.base.extension.invisible
import d.offrede.base.extension.visible
import d.offrede.base.viewmodel.BaseViewModel
import kotlinx.android.synthetic.main.fragment_container.*
import kotlinx.android.synthetic.main.include_empty.*
import kotlinx.android.synthetic.main.include_failure.*
import kotlinx.android.synthetic.main.include_progress.*

abstract class BaseFragment : Fragment() {

    @LayoutRes
    abstract fun layoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startObserves()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_container, container, false)
        inflater.inflate(layoutId(), view.findViewById(R.id.fragmentContainer), false)
        configureLayouts()
        return view
    }

    open fun baseViewModel(): BaseViewModel? = null

    open fun loadingLayout(): Int = R.layout.include_progress

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

    private fun configureFailureLayout() {
        layoutInflater.inflate(failureLayout(), failureContainer, true)
    }

    private fun configureEmptyLayout() {
        layoutInflater.inflate(emptyLayout(), emptyContainer, true)
    }
}