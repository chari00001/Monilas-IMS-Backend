package com.ims.service;

import com.ims.model.Event;
import com.ims.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

  @Autowired
  private EventRepository eventRepository;

  // Get all events
  public List<Event> getAllEvents() {
    return eventRepository.findAll();
  }

  // Get an event by its ID
  public Optional<Event> getEventById(Integer id) {
    return eventRepository.findById(id);
  }

  // Save or update an event
  public Event saveEvent(Event event) {
    return eventRepository.save(event);
  }

  // Delete an event by its ID
  public void deleteEventById(Integer id) {
    eventRepository.deleteById(id);
  }

  // Delete an event by entity
  public void deleteEvent(Event event) {
    eventRepository.delete(event);
  }

  // Custom methods

  // Get events by title
  public List<Event> getEventsByTitle(String title) {
    return eventRepository.findByTitle(title);
  }

  // Get events by event date
  public List<Event> getEventsByEventDate(Date eventDate) {
    return eventRepository.findByEventDate(eventDate);
  }

  // Get events by location
  public List<Event> getEventsByLocation(String location) {
    return eventRepository.findByLocation(location);
  }

  // Get events within a specific date range
  public List<Event> getEventsByDateRange(Date startDate, Date endDate) {
    return eventRepository.findByEventDateBetween(startDate, endDate);
  }

  // Get events containing a keyword in the description
  public List<Event> getEventsByDescriptionContaining(String keyword) {
    return eventRepository.findByDescriptionContaining(keyword);
  }

  // Additional business logic methods can be added here if needed
}
