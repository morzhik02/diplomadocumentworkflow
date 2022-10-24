package iitu.diploma.documentworkflow.db;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<DocTypes> docTypes = new ArrayList<>();
    static {
        docTypes.add(new DocTypes(1L, "Заявление"));
    }

    private static Long id;

    public static ArrayList<DocTypes> getDocTypes(){
        return docTypes;
    }

    public static void addDoc(DocTypes docType){
        docType.setId(id);
        docTypes.add(docType);
        id++;
    }
}
