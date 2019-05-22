package com.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class User {

    @Id @GeneratedValue
    private Long id;
    private @NonNull String name;
    private @NonNull String password;
}
