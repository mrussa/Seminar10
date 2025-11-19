package backend.academy.seminar10.examples;

import java.math.BigDecimal;

public class BadNaming {

    BigDecimal p; // Финальная цена

    BigDecimal basePrice;
    BigDecimal totalDiscount;
    BigDecimal finalPrice;

}

class UserManager {

    private String n;         // имя
    private String em;        // email
    private boolean aktiv;    // активен?
    private boolean adm;      // админ?

    public UserManager(String n, String em, boolean aktiv, boolean adm) {
        this.n = n;
        this.em = em;
        this.aktiv = aktiv;
        this.adm = adm;
    }

    public boolean chk() {
        return aktiv;
    }

    public boolean process() {
        return adm;
    }
}

class UserManager {

    private String name;
    private String email;
    private boolean active;
    private boolean admin;

    public UserManager(String name, String email, boolean active, boolean admin) {
        this.name = name;
        this.email = email;
        this.active = active;
        this.admin = admin;
    }

    public boolean canLogin() {
        return active;
    }

    public boolean isAdmin() {
        return admin;
    }
}


