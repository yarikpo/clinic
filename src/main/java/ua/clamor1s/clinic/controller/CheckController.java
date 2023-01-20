package ua.clamor1s.clinic.controller;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.clamor1s.clinic.service.CheckService;
import ua.clamor1s.clinic.service.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Controller
@RequestMapping("/checks")
public class CheckController {

    @Autowired
    private CheckService service;
    @Autowired
    private ReportService reportService;

    @GetMapping
    public void getFullReport(HttpServletResponse res) {
        String filename = "report.pdf";

        byte[] contents = null;
        try {
            contents = reportService.getFullReport().toByteArray();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        try {
            res.getOutputStream().write(contents);
            res.setContentType("application/pdf");
            res.setHeader("Content-disposition", "attachment;filename=" + filename);
            res.flushBuffer();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/{id}")
    public void getCheckPdfById(@PathVariable int id, HttpServletRequest req, HttpServletResponse res) {
        String filename = "check" + id + ".pdf";

        byte[] contents = null;
        try {
            contents = service.getCheckPdbById(id).toByteArray();
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        try {
            res.getOutputStream().write(contents);
            res.setContentType("application/pdf");
            res.setHeader("Content-disposition", "attachment;filename=" + filename);
            res.flushBuffer();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
