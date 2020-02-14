package d.offrede.base.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import d.offrede.base.viewmodel.VisibilityStatus.*

class BaseLiveData<T : ViewModelResult<Any>> : MutableLiveData<Pair<VisibilityStatus, T>>(){

    fun observe(
        owner: LifecycleOwner,
        onVisible: (T) -> Unit,
        onInvisible: (T) -> Unit,
        onGone: (T) -> Unit
    ) {
        super.observe(owner, Observer<Pair<VisibilityStatus, T>> {
            when(it.first) {
                VISIBLE -> onVisible(it.second)
                INVISIBLE -> onInvisible(it.second)
                GONE -> onGone(it.second)
            }
        })
    }

    fun makeVisible(result: T) {
        this.value = VISIBLE to result

    }

    fun makeInvisible(result: T) {
        this.value = INVISIBLE to result

    }

    fun makeGone(result: T) {
        this.value = GONE to result

    }

}