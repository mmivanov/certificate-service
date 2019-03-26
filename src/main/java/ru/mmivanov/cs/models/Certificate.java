package ru.mmivanov.cs.models;

import java.util.Date;

public class Certificate {
    public static final String ID_ATTRIBUTE = "id_";
    public static final String TBL_STATUS_ATTRIBUTE = "tbl_status_";
    public static final String TBL_CERT_NUM_ATTRIBUTE = "tbl_cert_num_";
    public static final String TBL_ISSUE_DATE_ATTRIBUTE = "tbl_issue_date_";
    public static final String TBL_END_DATE_ATTRIBUTE = "tbl_end_date_";
    public static final String TBL_DECLARANT_ATTRIBUTE = "tbl_declarant_";
    public static final String TBL_MANUFACTURER_ATTRIBUTE = "tbl_manufacturer_";
    public static final String TBL_PRODUCTION_ATTRIBUTE = "tbl_production_";
    public static final String TBL_REGLAMENT_ATTRIBUTE = "tbl_reglament_";
    private String status = CertificateStatus.unknown;
    private String certNum = "";
    private Date issueDate = new Date(0);
    private Date endDate = new Date(0);
    private String declarant = "";
    private String manufacturer = "";
    private String production = "";
    private String reglament = "";

    public Certificate() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCertNum() {
        return certNum;
    }

    public void setCertNum(String certNum) {
        this.certNum = certNum;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDeclarant() {
        return declarant;
    }

    public void setDeclarant(String declarant) {
        this.declarant = declarant;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getReglament() {
        return reglament;
    }

    public void setReglament(String reglament) {
        this.reglament = reglament;
    }
}
