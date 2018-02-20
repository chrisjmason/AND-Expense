package digital.and.andexpenses.base;

/**
 * Created by matashfaraz on 19/02/2018.
 */

public interface MvpContract {

    interface View{

    }

    interface Presenter<T extends View>{
        void onBind(T view);
        void onDestroy();
        T getView();
    }
}
