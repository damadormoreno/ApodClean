package andro.apps.deneb.listapodsclean.common

import andro.apps.deneb.domain.common.Transformer
import com.yossisegev.domain.common.Transformer
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers



class ASyncTransformer<T> : Transformer<T>() {
    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}