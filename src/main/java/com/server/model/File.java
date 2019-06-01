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
@Table(name = "app_file")
public class File {
    @Id @GeneratedValue
    private Long id;
    private @NonNull String name;
    @CreationTimestamp
    private Date added;
    private String addedBy;

    public File(String name, String user) {
        this.addedBy = user;
        this.name = name;
    }
}
