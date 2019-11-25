package com.ctiliescu.toeventsourcinglab.user.model;

import java.util.Objects;

public class UserEvent {

	String id;

	String eventType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public UserEvent(String id, String eventType) {
		this.id = id;
		this.eventType = eventType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof UserEvent))
			return false;
		UserEvent userEvent = (UserEvent) o;
		return Objects.equals(id, userEvent.id)
				&& Objects.equals(eventType, userEvent.eventType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, eventType);
	}

}
