package com.anytimedeveloper.akprojects.studentStack.pojos;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Entity(name="branch")
public class Branch {
    @Column(name = "code")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long code;
    @Column(name = "title")
    private String title;

}
