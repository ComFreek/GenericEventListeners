package com.github.comfreek.gel;


/**
 * The interface for a listener which can be called from a Listenable if an
 * event occurs.
 * 
 * @param <T> The event's data type.
 */
public interface Listener<T> {
	public boolean run(Event<T> e);
}