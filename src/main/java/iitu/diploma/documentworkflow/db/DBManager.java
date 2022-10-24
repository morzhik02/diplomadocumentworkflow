package iitu.diploma.documentworkflow.db;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Document> documents = new ArrayList<>();
    static {
        documents.add(new Document(1L, "Справка", 1234));
        documents.add(new Document(2L, "Заявление", 1235));
        documents.add(new Document(3L, "Подача документов", 1236));
    }

    private static Long id = 4L;

    public static ArrayList<Document> getDocuments(){
        return documents;
    }

    public static void addDoc(Document document){
        document.setId(id);
        documents.add(document);
        id++;
    }

    public static Document getDocument(Long id){
        for (Document doc : documents){
            if (doc.getId() == id)
                return doc;
        }
        return null;
    }
}
