package iitu.diploma.documentworkflow.services;

import iitu.diploma.documentworkflow.entities.Documents;

import java.util.List;

public interface DocumentService {
    Documents addDoc(Documents document);
    List<Documents> getAllDocs();
    Documents getId(Long id);
    void deleteDoc(Documents document);
    Documents saveDoc(Documents document);
}
