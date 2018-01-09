package io.github.shibadog.ragdoll.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.shibadog.ragdoll.entity.Chain;
import io.github.shibadog.ragdoll.exception.ApplicationException;

@RestController
@RequestMapping("/test")
public class TestControler {

    private Chain chain;

    public TestControler() throws ApplicationException {
        try {
            this.chain = new Chain();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Chain get() throws ApplicationException {
        String data = "new Data!!";
        return this.chain.generateNextBlock(data);
    }
}