package ru.mmivanov.cs.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.mmivanov.cs.models.Certificate;
import ru.mmivanov.cs.models.CertificateStatus;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class CertificateService {
    public ArrayList checkCertificate(String certificateNumber, String page, String pageSize) throws IOException, ParseException {
        Document doc = Jsoup.connect("http://public.fsa.gov.ru/table_rss_pub_rf/index.php").data(new HashMap<String, String>() {{
            put("MIME Type", "application/x-www-form-urlencoded");
            put("ajax", "main");
            put("input_1", certificateNumber);
            put("idid", "content-table");
            put("sortid_", "DESC");
            put("orderid_", "3");
            put("Divid_", "tableContent-content-table");
            put("Formid_", "formContentcontent-table");
            put("ajaxid_", "main&' + tableManager.getControlsData() + servicesManager.getAdvancedSearchParams() + '");
            put("page_noid_", page);
            put("rowActid_", "");
            put("prefixid_", "id_");
            put("findid_", "");
            put("btn_find_id_", "%CD%E0%E9%F2%E8");
            put("page_byid_", pageSize);
            put("html_id", "tableContent-content-table");
            put("ajaxId", "561514061");
            put("loadedExtraFiles", "35782l35784l35786l35788l35790l35798l35800l35802l35804l35806l35808l35810l35812l1124l35836l35818l35836l35818l35820l35822l35824l35826l35828l35830l35832l35834l35842l35844l35848l35852l35836l35818l35866l1166l1168l1170l1172l1174l1176l1178l1184l1186l1188l1190l1192l1194l1196l1198l1200l35784l35858l1204l1206l1188l1208l35854l35856l1216l1218l1220l1222l1222l1224l1078l1080l1082l1084l1086l1088l1212l1214l1210");
        }}).post();
        Elements rows = doc.select("#bodyTableData tbody tr");
        Certificate certificate = new Certificate();

        ArrayList<Certificate> result = new ArrayList<>();

        for (Element row : rows) {
            String id = row.id().replace("id_", "");
            for (Element column : row.getElementsByTag("td")) {
                String columnId = column.id();

                if (columnId.equals(Certificate.TBL_STATUS_ATTRIBUTE + id)) {
                    String status = column.child(0).className().replace("status-ico ", "");
                    certificate.setStatus(CertificateStatus.statuses.get(status));
                } else if (columnId.equals(Certificate.TBL_CERT_NUM_ATTRIBUTE + id)) {
                    certificate.setCertNum(column.child(0).html());
                } else if (columnId.equals(Certificate.TBL_ISSUE_DATE_ATTRIBUTE + id)) {
                    String value = column.child(0).html();
                    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                    try {
                        Date date = format.parse(value);
                        certificate.setIssueDate(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else if (columnId.equals(Certificate.TBL_END_DATE_ATTRIBUTE + id)) {
                    String value = column.child(0).html();
                    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                    Date date = format.parse(value);
                    certificate.setEndDate(date);
                } else if (columnId.equals(Certificate.TBL_DECLARANT_ATTRIBUTE + id)) {
                    certificate.setDeclarant(column.html());
                } else if (columnId.equals(Certificate.TBL_MANUFACTURER_ATTRIBUTE + id)) {
                    certificate.setManufacturer(column.html());
                } else if (columnId.equals(Certificate.TBL_PRODUCTION_ATTRIBUTE + id)) {
                    certificate.setProduction(column.html());
                } else if (columnId.equals(Certificate.TBL_REGLAMENT_ATTRIBUTE + id)) {
                    certificate.setReglament(column.html());
                }
            }
            result.add(certificate);
        }

        return result;
    }
}
