package com.lucas.coretesting.base

import com.lucas.coretesting.livedata.LiveDataTestObserver
import com.lucas.coretesting.livedata.test
import com.lucas.coreui.base.viewModel.BaseViewModel
import com.lucas.coreui.base.viewModel.ViewModelState
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf


abstract class BaseViewModelTest {

    abstract val viewModel: BaseViewModel

    var stateObserver: LiveDataTestObserver<ViewModelState?>? = null

    /**
     * Create an observer for viewModelState for later verification
     */
    fun observeViewModelState(){
        stateObserver = viewModel.viewModelState.test()
    }

    /**
     * Verify UI state
     *
     * @param firstState: initial state of UI
     * @param lastState: last state of UI after all work's done
     */
    fun verifyViewModelState(firstState: ViewModelState, lastState: ViewModelState){
        stateObserver
            ?.assertHasValue()
            ?.getHistory()
            .also {
                println(it)
                println("lastState: ${it?.last()}")
                it?.first() shouldBe firstState
                it?.last() shouldBe lastState
            }
    }

    /**
     * Verify UI state
     * Takes the first generic param as the initial state
     * the second param as the last state
     */
    inline fun <reified T : Any, reified V : Any> verifyViewModelState() {
        stateObserver
            ?.assertHasValue()
            ?.getHistory()
            .also {
                println(it)
                println("lastState: ${it?.last()}")
                it?.first().shouldBeTypeOf<T>()
                it?.last().shouldBeTypeOf<V>()
            }
    }
}