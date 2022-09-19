package com.uditkumawat.craftproject.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name="driver_documents")
public class Document {

    @Id
    @Column(name="document_id",nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long documentId;

    @Column(name="document_name")
    private String documentName;

    @Column(name="document_type")
    private DocumentType documentType;

    @ManyToOne
    @JoinColumn(name="driver_id")
    private Driver driver;

    @Lob
    private byte[] data;

    public Document() {

    }

    public Document(String fileName, DocumentType documentType, byte[] data,Driver driver) {
        this.documentName = fileName;
        this.documentType = documentType;
        this.data = data;
        this.driver = driver;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Document(Long documentId, String documentName, DocumentType documentType, Driver driver, byte[] data) {
        this.documentId = documentId;
        this.documentName = documentName;
        this.documentType = documentType;
        this.driver = driver;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentId=" + documentId +
                ", documentName='" + documentName + '\'' +
                ", documentType=" + documentType +
                ", driver=" + driver +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
