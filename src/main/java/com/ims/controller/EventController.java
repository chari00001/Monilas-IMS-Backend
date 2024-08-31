package com.ims.controller;

import com.ims.model.Event;
import com.ims.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

  @Autowired
  private EventService eventService;

  // Get all events
  @GetMapping
  public List<Event> getAllEvents() {
    return eventService.getAllEvents();
  }

  // Get an event by ID
  @GetMapping("/{id}")
  public ResponseEntity<Event> getEventById(@PathVariable Integer id) {
    Optional<Event> event = eventService.getEventById(id);
    return event.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Get events by title
  @GetMapping("/title/{title}")
  public List<Event> getEventsByTitle(@PathVariable String title) {
    return eventService.getEventsByTitle(title);
  }

  // Get events by event date
  @GetMapping("/date/{eventDate}")
  public List<Event> getEventsByEventDate(@PathVariable Date eventDate) {
    return eventService.getEventsByEventDate(eventDate);
  }

  // Get events by location
  @GetMapping("/location/{location}")
  public List<Event> getEventsByLocation(@PathVariable String location) {
    return eventService.getEventsByLocation(location);
  }

  // Get events within a specific date range
  @GetMapping("/date-range")
  public List<Event> getEventsByDateRange(@RequestParam Date startDate, @RequestParam Date endDate) {
    return eventService.getEventsByDateRange(startDate, endDate);
  }

  // Get events containing a keyword in the description
  @GetMapping("/description")
  public List<Event> getEventsByDescriptionContaining(@RequestParam String keyword) {
    return eventService.getEventsByDescriptionContaining(keyword);
  }

  // Create or update an event
  @PostMapping
  public Event createOrUpdateEvent(@RequestBody Event event) {
    return eventService.saveEvent(event);
  }

  // Delete an event by ID
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEventById(@PathVariable Integer id) {
    if (eventService.getEventById(id).isPresent()) {
      eventService.deleteEventById(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }

  // Delete an event by entity
  @DeleteMapping
  public ResponseEntity<Void> deleteEvent(@RequestBody Event event) {
    if (eventService.getEventById(event.getId()).isPresent()) {
      eventService.deleteEvent(event);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
