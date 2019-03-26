package ru.mmivanov.cs.responses;

import java.util.ArrayList;

public class CertificateResponse {
    private final ArrayList certificates;

    public CertificateResponse(ArrayList certificates) {
        this.certificates = certificates;
    }

    public ArrayList getCertificates() {
        return certificates;
    }
}
