package digital.and.andexpenses.base;

/**
 * Created by matashfaraz on 19/02/2018.
 */

public class BasePresenter<T extends MvpContract.View> implements MvpContract.Presenter<T> {
    private T view;

    @Override
    public void onBind(T view) {
        this.view = view;
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public T getView() {
        return view;
    }

}
