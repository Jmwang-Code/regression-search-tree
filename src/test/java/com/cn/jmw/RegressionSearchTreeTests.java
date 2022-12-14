package com.cn.jmw;

import org.apache.bsf.BSFException;
import org.apache.bsf.BSFManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class RegressionSearchTreeTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
        BSFManager mgr = new BSFManager();
        try {
            // Set variables
            mgr.declareBean("var1", 5, Integer.class);
            mgr.declareBean("date",  new Date(), Date.class);
            String script = "import java.util.Date;"
                    +" String var1 = var1 + \"_\" + date.toString();"
                    +" System.out.println(date.toString());"
                    +" return var1";
            Object result = mgr.eval("beanshell", "no", 0, 0, script);
            System.out.println("source result:" + result);
        }
        catch (BSFException ex) {
            ex.printStackTrace();
        }
    }

}
