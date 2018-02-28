package digital.and.andexpenses.utils

import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

/**
 * Created by cmason on 28/02/2018.
 */
interface SchedulerProviderContract {
    fun getBackgroundScheduler(): Scheduler
    fun getMainScheduler(): Scheduler
}