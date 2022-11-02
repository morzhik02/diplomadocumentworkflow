package iitu.diploma.documentworkflow.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //@OneToMany(mappedBy = "stud_id", cascade = CascadeType.ALL)
    @Column(name = "login")
    //private Set<Documents> documents = new HashSet<Documents>();
    private Long login;

    /*public void addDoc(Documents document){
        documents.add(document);
        document.setStud_id(this);
    }*/

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "group_id")
    private Long groupId;
}
