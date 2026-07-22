package bo;

import po.MantisLoginPage;
import po.MantisMyViewPage;

public class MantisBO {

    public MantisMyViewPage loginAsAdmin() {
        return new MantisLoginPage()
                .open()
                .submitUsername("administrator")
                .submitPassword("root123");
    }
}
