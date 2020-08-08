package hacine.mohamed.abdelhakim.cloudfirestore;

import java.io.Serializable;

public class Note  {
String documentid;
    String title ;
    private int priority;



    String Description;

    public Note() {
    }


    public Note(String title, String description, int priority) {
        this.title = title;
        this.priority = priority;
        Description = description;

    }

    public String getDocumentid() {
        return documentid;
    }

    public void setDocumentid(String documentid) {
        this.documentid = documentid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
