package iitu.diploma.documentworkflow.services.impl;

import iitu.diploma.documentworkflow.entities.Documents;
import iitu.diploma.documentworkflow.entities.Students;
import iitu.diploma.documentworkflow.repositories.DocumentRepository;
import iitu.diploma.documentworkflow.repositories.StudentRepository;
import iitu.diploma.documentworkflow.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Documents addDoc(Documents document) {
        return documentRepository.save(document);
    }

    @Override
    public List<Documents> getAllDocs() {
//        return documentRepository.findAllByIdIsGreaterThan(2L);
        return documentRepository.findAll();

    }

    @Override
    public Documents getId(Long id) {
        return documentRepository.getReferenceById(id);
    }

    @Override
    public void deleteDoc(Documents document) {
        documentRepository.delete(document);
    }

    @Override
    public Documents saveDoc(Documents document) {
        return documentRepository.save(document);
    }

    @Override
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Students addStudent(Students student) {
        return studentRepository.save(student);
    }

    @Override
    public Students saveStudent(Students student) {
        return studentRepository.save(student);
    }

    @Override
    public Students getStudent(Long id) {
        return studentRepository.getReferenceById(id);
    }
}
