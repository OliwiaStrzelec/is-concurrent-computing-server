package com.server.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "app_user")
public class User {

    @Id @GeneratedValue
    private Long id;

    private @NonNull String name;

    private @NonNull String username;

    private @NonNull String password;
}
