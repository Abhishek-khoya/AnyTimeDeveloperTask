package com.anytimedeveloper.akprojects.studentStack.repositories;

import com.anytimedeveloper.akprojects.studentStack.pojos.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
