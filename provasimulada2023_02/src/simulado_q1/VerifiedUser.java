package simulado_q1;

import java.util.Date;

public class VerifiedUser extends User {
    private Date verificationDate;

    public VerifiedUser(String name, Date verificationDate) {
        super(name);
        this.verificationDate = verificationDate;
    }

    public Date getVerificationDate() {
        return verificationDate;
    }
}