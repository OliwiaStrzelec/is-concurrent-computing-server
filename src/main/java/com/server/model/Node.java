package com.server.model;
import lombok.*;


import javax.persistence.*;


@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "app_node")
public class Node {
    @Id
    @GeneratedValue
    private Long id;
    private Long fileid;
    private int nodeid;
    private double x;
    private double y;
    private double z;
    private double temp;

    public Node(Long fileid, int id, int x, int y, int z, double temp){
        this.fileid=fileid;
        this.nodeid=id;
        this.x=x;
        this.y=y;
        this.z=z;
        this.temp=temp;
    }
}
