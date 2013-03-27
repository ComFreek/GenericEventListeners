package com.github.comfreek.gel;

/**
 * Represents an Event fired by a class implementing Listenable.
 * 
 * @param <T>
 *            The event's data class.
 */
public class Event<T> {
	
	/**
	 * Data
	 */
	public T data;

	/**
	 * The event's type or identifier, e.g. "beforeStart" or "beforeEnd"
	 */
	private String type;

	/**
	 * Indicates whether the Listenable should invoke other event listeners or
	 * not.
	 * 
	 * @see Event.shouldStopPropagation()
	 * @see Event.stopImmediatePropagation()
	 */
	private boolean shouldStopPropagation = false;

	/**
	 * Creates a new event object.
	 * 
	 * @param type
	 *            The event's identifier.
	 * @param data
	 *            The data which should be transported to the Event Listener.
	 */
	public Event(String type, T data) {
		this.type = type;
		this.data = data;
	}

	/**
	 * Creates a new event object with its data set to null.
	 * 
	 * @param type
	 *            The event's identifier.
	 */
	public Event(String type) {
		this(type, null);
	}

	/**
	 * Returns the event's identifier.
	 * 
	 * @return The event's Id.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Indicates the parent Listenable class not to invoke other Event
	 * Listeners.
	 * 
	 * @see Event.shouldStopPropagation
	 */
	public void stopImmediatePropagation() {
		shouldStopPropagation = true;
	}

	/**
	 * Returns TRUE if stopImmediatePropagation() was called, FALSE otherwise.
	 */
	public boolean shouldStopPropagation() {
		return shouldStopPropagation;
	}
}
