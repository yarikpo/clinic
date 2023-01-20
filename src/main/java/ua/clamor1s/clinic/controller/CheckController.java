package ua.clamor1s.clinic.controller;

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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Controller
@RequestMapping("/checks")
public class CheckController {

    @Autowired
    private CheckService service;

    @GetMapping("/{id}")
    public void getCheckPdfById(@PathVariable int id, HttpServletRequest req, HttpServletResponse res) {
//        res.setContentType("application/pdf");
        String filename = "check" + id + ".pdf";
//        res.setHeader("Content-Disposition", "attachment;filename=" + filename);
        byte[] contents = null;
        try {
            contents = service.getCheckPdbById(id).toByteArray();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.parseMediaType("application/pdf"));
//
//        headers.setContentDispositionFormData(filename, filename);
//        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
//        ResponseEntity<byte[]> respons = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
//
//        return respons;

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
