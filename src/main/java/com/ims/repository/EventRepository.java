package com.ims.repository;

import com.ims.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.sql.Date;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

  // Custom query method to find events by title
  List<Event> findByTitle(String title);

  // Custom query method to find events by event date
  List<Event> findByEventDate(Date eventDate);

  // Custom query method to find events by location
  List<Event> findByLocation(String location);

  // Custom query method to find events by date range
  List<Event> findByEventDateBetween(Date startDate, Date endDate);

  // Custom query method to find events containing a keyword in the description
  List<Event> findByDescriptionContaining(String keyword);
}
