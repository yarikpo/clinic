package ua.clamor1s.clinic.service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.clinic.dao.CheckDao;
import ua.clamor1s.clinic.model.Check;

import java.io.ByteArrayOutputStream;
import java.util.stream.Stream;

@Service
@Transactional(readOnly = true)
public class CheckServiceImpl implements CheckService {

    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @Autowired
    private CheckDao dao;


    @Override
    public ByteArrayOutputStream getCheckPdbById(int id) throws DocumentException {
        return makePdf(dao.getCheckById(id));
    }

    private ByteArrayOutputStream makePdf(Check check) throws DocumentException {

        Document document = new Document();

        PdfWriter.getInstance(document, byteArrayOutputStream);
        document.open();
        PdfPTable table = new PdfPTable(10);
        addTableHeader(table);
        addRow(table, check);
        document.add(table);
        document.close();

        return this.byteArrayOutputStream;
    }

    private void addTableHeader(PdfPTable table) {
        Stream.of("appointmentNumber", "doctorId", "doctorName", "clientId", "clientName", "favourId",
                        "favourName", "favourCost", "workplaceId", "date")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addRow(PdfPTable table, Check check) {
        System.out.println(check);
        table.addCell(check.getAppointmentNumber().toString());
        table.addCell(check.getDoctorId().toString());
        table.addCell(check.getDoctorName());
        table.addCell(check.getClientId().toString());
        table.addCell(check.getClientName());
        table.addCell(check.getFavourId().toString());
        table.addCell(check.getFavourName());
        table.addCell(check.getFavourCost().toString());
        table.addCell(check.getWorkplaceId().toString());
        table.addCell(check.getDate());
    }
}
