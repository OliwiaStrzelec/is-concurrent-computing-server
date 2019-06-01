package com.server.model;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "app_files")
public class Files {
    @Id @GeneratedValue
    private Long id;

    private @NonNull String name;
    @CreationTimestamp
    private Date added;
    private String addedby;
    public Files(String name, String user) {
        this.addedby = user;
        this.name = name;
    }
}
