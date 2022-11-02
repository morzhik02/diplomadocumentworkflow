package iitu.diploma.documentworkflow.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "docs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "doc_type", length = 100)
    private String docType;

    @SequenceGenerator(name = "docsNumSeq", sequenceName = "docs_num_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "docsNumSeq")
    @Column(name = "num")
    private Long num;

    //@ManyToOne(fetch = FetchType.EAGER)
    //@Column(name = "stud_login")
    //private Students student;
    @Column(name = "stud_login")
    private int studLogin;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "stat", length = 50)
    private String status;
}
