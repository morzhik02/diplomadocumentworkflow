package iitu.diploma.documentworkflow.services;

import iitu.diploma.documentworkflow.entities.Documents;
import iitu.diploma.documentworkflow.entities.Students;

import java.util.List;

public interface DocumentService {
    Documents addDoc(Documents document);
    List<Documents> getAllDocs();
    Documents getId(Long id);
    void deleteDoc(Documents document);
    Documents saveDoc(Documents document);

    List<Students> getAllStudents();
    Students addStudent(Students student);
    Students saveStudent(Students student);
    Students getStudent(Long id);
    
}
