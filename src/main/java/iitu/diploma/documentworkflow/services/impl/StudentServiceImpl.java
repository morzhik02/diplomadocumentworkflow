package iitu.diploma.documentworkflow.services.impl;

import iitu.diploma.documentworkflow.services.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private String studData;

    @Override
    public String getData() {
        return "Student data is " + this.studData;
    }

    @Override
    public void setData(String studData) {
        this.studData = studData;
    }
}
