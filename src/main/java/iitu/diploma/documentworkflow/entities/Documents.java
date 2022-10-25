package iitu.diploma.documentworkflow.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "d_items")
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

    @Column(name = "num")
    private int num;

    @Column(name = "stud_id")
    private int studId;

    @Column(name = "owner_id")
    private int ownerId;

    @Column(name = "stat", length = 50)
    private String status;
}
