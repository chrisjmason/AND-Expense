package digital.and.andexpenses.helpers

import digital.and.andexpenses.utils.SchedulerProviderContract
import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

/**
 * Created by cmason on 28/02/2018.
 */
class TestSchedulerProvider: SchedulerProviderContract {
    override fun getBackgroundScheduler(): Scheduler = TestScheduler()
    override fun getMainScheduler(): Scheduler = TestScheduler()
}