package com.ims.repository;

import com.ims.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@SuppressWarnings("null")
public interface ExamRepository extends JpaRepository<Exam, Integer> {

    // Custom query method to find exams by class ID
    List<Exam> findByClassId(int classId);

    // Custom query method to find exams by exam date
    List<Exam> findByExamDate(Date examDate);

    // Custom query method to find exams by type
    List<Exam> findByType(String type);

    // Custom query method to find exams with a duration greater than or equal to a
    // certain value
    List<Exam> findByDurationGreaterThanEqual(Time duration);

    // Custom query method to find exams by exam date and class ID
    List<Exam> findByExamDateAndClassId(Date examDate, int classId);

    // Custom query method to find exams by type and class ID
    List<Exam> findByTypeAndClassId(String type, int classId);

    // Custom query method to find exams by type and duration less than a certain
    // value
    List<Exam> findByTypeAndDurationLessThan(String type, Time duration);

    // Custom save method
    <E extends Exam> E save(E entity);
}
