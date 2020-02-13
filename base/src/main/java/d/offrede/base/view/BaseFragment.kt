package d.offrede.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import d.offrede.base.extension.invisible
import d.offrede.base.extension.visible
import kotlinx.android.synthetic.main.include_progress.*

abstract class BaseFragment : Fragment() {

    abstract fun layoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(layoutId(), container, false)

    protected fun showProgress() = with(activity) { if (this is BaseActivity) progress.visible() }

    protected fun hideProgress() = with(activity) { if (this is BaseActivity) progress.invisible() }

}