package iitu.diploma.documentworkflow.beans;

import org.springframework.stereotype.Component;

@Component
public class TestBean {
    private String text = "hello";

    public TestBean(){
        System.out.println("Create test bean");
    }

    public void setText(String text){
        this.text = text;
    }

    public String getData(){
        return "This is " + this.text + " data";
    }
}
