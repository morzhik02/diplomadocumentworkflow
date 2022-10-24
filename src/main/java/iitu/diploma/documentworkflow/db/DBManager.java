package iitu.diploma.documentworkflow.db;

import java.util.ArrayList;
import java.util.Objects;

public class DBManager {
    private static ArrayList<Document> documents = new ArrayList<>();
    static {
        documents.add(new Document(1L, "Справка", 1, 27488, 0, "Создано"));
        documents.add(new Document(2L, "Заявление", 2,27488, 0, "Создано"));
        documents.add(new Document(3L, "Подать документы", 3, 27488, 0, "Создано"));
    }

    private static Long id = 4L;
    private static int num = 4;

    public static ArrayList<Document> getDocuments(){
        return documents;
    }

    public static void addDoc(Document document){
        document.setId(id);
        document.setNum(num);
        documents.add(document);
        id++;
        num++;
    }

    public static Document getDocument(Long id){
        for (Document doc : documents){
            if (Objects.equals(doc.getId(), id)) {
                return doc;
            }
        }
        return null;
    }
}
