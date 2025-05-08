package com.giaule.rungroop.repositories;

import com.giaule.rungroop.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
