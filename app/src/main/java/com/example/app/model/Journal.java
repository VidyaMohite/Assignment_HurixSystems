package com.example.app.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Journal {
    private String id;
    private String journal;
    private String eissn;
    private String publication_date;
    private String article_type;
    private List<String> author_display;
    @SerializedName("abstract")
    private List<String> abstract_;
    private String title_display;
    private String score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getEissn() {
        return eissn;
    }

    public void setEissn(String eissn) {
        this.eissn = eissn;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    public String getArticle_type() {
        return article_type;
    }

    public void setArticle_type(String article_type) {
        this.article_type = article_type;
    }

    public List<String> getAuthor_display() {
        return author_display;
    }

    public void setAuthor_display(List<String> author_display) {
        this.author_display = author_display;
    }

    public List<String> getAbstract_() {
        return abstract_;
    }

    public void setAbstract_(List<String> abstract_) {
        this.abstract_ = abstract_;
    }

    public String getTitle_display() {
        return title_display;
    }

    public void setTitle_display(String title_display) {
        this.title_display = title_display;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }




   /* "id":"10.1371/journal.pone.0000290",
            "journal":"PLoS ONE",
            "eissn":"1932-6203",
            "publication_date":"2007-03-14T00:00:00Z",
            "article_type":"Research Article",
            "author_display":["Rayna I. Kraeva",
            "Dragomir B. Krastev",
            "Assen Roguev",
            "Anna Ivanova",
            "Marina N. Nedelcheva-Veleva",
            "Stoyno S. Stoynov"],
            "abstract"
            "title_display":"Stability of mRNA/DNA and DNA/DNA Duplexes Affects mRNA Transcription",
            "score"*/
}
