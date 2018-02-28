package digital.and.andexpenses.utils

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by cmason on 28/02/2018.
 */
open class SchedulerProvider: SchedulerProviderContract{
    override fun getBackgroundScheduler():Scheduler = Schedulers.io()
    override fun getMainScheduler():Scheduler = AndroidSchedulers.mainThread()
}