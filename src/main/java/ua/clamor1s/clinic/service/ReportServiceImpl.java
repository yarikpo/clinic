package ua.clamor1s.clinic.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.clinic.dao.ReportCellDao;
import ua.clamor1s.clinic.model.ReportCell;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional(readOnly = true)
public class ReportServiceImpl implements ReportService {

    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @Autowired
    private ReportCellDao dao;

    @Override
    public ByteArrayOutputStream getFullReport() throws DocumentException {
        return makePdf(dao.getFullReport());
    }

    private ByteArrayOutputStream makePdf(List<ReportCell> reports) throws DocumentException {
        Document document = new Document(PageSize.LETTER,30,30,60,35);
        PdfWriter.getInstance(document, byteArrayOutputStream);
        document.open();
        PdfPTable table = new PdfPTable(5);
        addTableHeader(table);
        addRows(table, reports);
        document.add(table);
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk("\n\nTotal income: " + dao.getFullCost(), font);
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(chunk);
        document.close();

        return this.byteArrayOutputStream;
    }

    private void addTableHeader(PdfPTable table) {
        Stream.of("appointmentNumber", "doctorId", "favourId", "favourCost", "date")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table, List<ReportCell> reports) {
        for (ReportCell report : reports) {
            table.addCell(report.getAppointmentNumber().toString());
            table.addCell(report.getDoctorId().toString());
            table.addCell(report.getFavourId().toString());
            table.addCell(report.getFavourCost().toString());
            table.addCell(report.getDate());
        }
    }



}
