package com.cambi.vending_machine.controller;
import com.cambi.vending_machine.dao.interfaces.CambiScoreDao;
import com.cambi.vending_machine.dao.interfaces.TestDao;
import com.cambi.vending_machine.model.product.Product;
import com.cambi.vending_machine.model.stack.PreferenceStack;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {
    private final TestDao testDao;
    private final CambiScoreDao cambiScoreDao;

    public TestController(TestDao testDao, CambiScoreDao cambiScoreDao) {
        this.testDao = testDao;
        this.cambiScoreDao = cambiScoreDao;
    }

    @GetMapping("/test")
    public String test() {
        Integer result = testDao.getTest();
        System.out.println(result);
        return Integer.toString(result);
    }
    @GetMapping("/product")
    public String getProduct() {
        Product result = testDao.getProduct(1);
        //System.out.println(result);
        return result.toString();
    }
    @GetMapping("/stack")
    public String preferenceStack() {
        PreferenceStack result = testDao.getPreferenceStack(1);
        //System.out.println(result);
        cambiScoreDao.getCambiScore();
        return result.toString();
    }
    @GetMapping("/score")
    public double cambiScore() {
        return cambiScoreDao.getCambiScore();
    }



}