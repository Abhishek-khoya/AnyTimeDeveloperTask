package com.anytimedeveloper.akprojects.studentStack.pojos;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Entity(name = "country")
public class Country {
    @Column(name="country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long countryId;
    @Column(name="country_name")
    private String countryName;
}
