package com.server.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "app_element")
public class Element {
    @Id
    @GeneratedValue
    private Long id;
    private Long fileid;
    private int nodeid;
    private int domid;
    private int node_1;
    private int node_2;
    private int node_3;
    private int node_4;
    private int node_5;
    private int node_6;
    private int node_7;
    private int node_8;

    public Element(Long file, int id, int dom, int n1, int n2, int n3, int n4, int n5, int n6, int n7, int n8){
        this.fileid=file;
        this.nodeid=id;
        this.domid=dom;
        this.node_1=n1;
        this.node_2=n2;
        this.node_3=n3;
        this.node_4=n4;
        this.node_5=n5;
        this.node_6=n6;
        this.node_7=n7;
        this.node_8=n8;
    }

}
