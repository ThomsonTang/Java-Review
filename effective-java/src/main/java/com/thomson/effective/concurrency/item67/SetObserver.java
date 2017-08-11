package com.thomson.effective.concurrency.item67;

/**
 * This is an callback interface which passed to {@linkplain ObservableSet#addObserver(SetObserver)} or {@link
 * ObservableSet#removeObserver(SetObserver)}.
 *
 * @author Thomson Tang
 * @version Created: 20/07/2017.
 */
public interface SetObserver<E> {
    //Invoked when an element is added to the observable set
    default void added(ObservableSet<E> set, E element) {
    }

    default void added(BetterObservableSet<E> set, E element) {
        System.out.println("this is a default method.");
    }
}
