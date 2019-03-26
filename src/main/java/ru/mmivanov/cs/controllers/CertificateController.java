package ru.mmivanov.cs.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mmivanov.cs.responses.CertificateResponse;
import ru.mmivanov.cs.services.CertificateService;

import java.io.IOException;
import java.text.ParseException;

@RestController
public class CertificateController {
    @RequestMapping("/api/")
    public CertificateResponse response(
            @RequestParam(value = "name", defaultValue = "User") String name,
            @RequestParam(value = "page", defaultValue = "0") String page,
            @RequestParam(value = "pageSize", defaultValue = "10") String pageSize
    ) throws IOException, ParseException {
        CertificateService service = new CertificateService();
        return new CertificateResponse(service.checkCertificate(name, page, pageSize));
    }
}
