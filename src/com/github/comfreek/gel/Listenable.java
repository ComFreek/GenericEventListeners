package com.github.comfreek.gel;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * The base class for all objects sending events.
 */
public class Listenable {

	/**
	 * Saves all registered listeners in an ArrayList for each different event
	 * identifier.
	 */
	protected HashMap<String, CopyOnWriteArrayList<Listener<?>>> listeners;

	/**
	 * Initializes the object.
	 */
	public Listenable() {
		listeners = new HashMap<String, CopyOnWriteArrayList<Listener<?>>>();
	}

	/**
	 * Adds an event listener _without_ checking whether it has already been
	 * registered.
	 * Be sure to only add listeners with the same data type for one identifier.
	 * 
	 * @param eventType
	 *            The event's identifier.
	 * @param listener
	 *            The listener.
	 */
	public void addEventListener(String eventType, Listener<?> listener) {
		if (listeners.get(eventType) == null) {
			listeners.put(eventType, new CopyOnWriteArrayList<Listener<?>>());
		}

		listeners.get(eventType).add(listener);
	}

	/**
	 * Fires up an event.
	 * TODO Check if the event's type and listener's type match.
	 * 
	 * @param evt
	 *            The event
	 * @return Returns FALSE if at least one listener returned false, otherwise
	 *         TRUE.
	 */
	public <T> boolean dispatchEvent(Event<T> evt) {
		CopyOnWriteArrayList<Listener<?>> evtListeners = listeners.get(evt
				.getType());
		if (evtListeners == null) {
			return true;
		}

		for (int i = 0; i < evtListeners.size(); i++) {
			@SuppressWarnings("unchecked")
			Listener<T> lst = (Listener<T>) evtListeners.get(i);

			if (!lst.run(evt) || evt.shouldStopPropagation()) {
				return false;
			}
		}

		return true;
	}
}
