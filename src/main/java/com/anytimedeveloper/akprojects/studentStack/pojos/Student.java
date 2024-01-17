package com.anytimedeveloper.akprojects.studentStack.pojos;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Entity(name = "student")
public class Student {
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long studentId;
    @Column(name="student_name")
    private String studentName;
    @Column(name="branch")
    private long branch;
    @Column(name="country")
    private long country;
    @Column(name="state")
    private long state;
    @Column(name="city")
    private long city;
    @Column(name="college")
    private long college;
    @Column(name="email_id")
    private String emailId;
    @Column(name="Phone_no")
    private String phoneNo;
    @Column(name="date_of_birth")
    private Date dateOfbirth;
    @Column(name="gender")
    private String gender;
    @Column(name="is_indian")
    private boolean isIndian;
}
