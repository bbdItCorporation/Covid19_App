package com.bbd.Covid19_App.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AppErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object errorStatusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (errorStatusCode != null) {
            Integer numberOfStatusCode = Integer.valueOf(errorStatusCode.toString());

//            if(numberOfStatusCode == HttpStatus.NOT_FOUND) {
//                return "error-404.html";
//            }
        }

        return "error_pages/generalError.html";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }


}
