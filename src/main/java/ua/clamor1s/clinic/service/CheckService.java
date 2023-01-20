package ua.clamor1s.clinic.service;

import com.itextpdf.text.DocumentException;

import java.io.ByteArrayOutputStream;

public interface CheckService {

    ByteArrayOutputStream getCheckPdbById(int id) throws DocumentException;

}
