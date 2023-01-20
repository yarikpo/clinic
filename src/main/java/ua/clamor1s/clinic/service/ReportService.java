package ua.clamor1s.clinic.service;

import com.itextpdf.text.DocumentException;

import java.io.ByteArrayOutputStream;

public interface ReportService {

    ByteArrayOutputStream getFullReport() throws DocumentException;

}
