package com.uditkumawat.craftproject.model;

import javax.persistence.*;

@Entity
@Table(name="documents")
public class Document {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    private String documentName;
    private DocumentType documentType;
    private boolean isVerified;
    @Lob
    private byte[] data;

    @Id
    public Long getId() {
        return id;
    }

    public Document(String fileName, DocumentType documentType, byte[] data) {
        this.documentName = fileName;
        this.documentType = documentType;
        this.data = data;
    }
}
