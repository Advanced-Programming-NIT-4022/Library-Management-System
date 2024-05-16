package org.LMS;

import org.apache.commons.codec.digest.DigestUtils;

public class Password {
    private String hashedPassword;
    static Password passwordByHash(String hashedPassword){
        Password password = new Password();
        password.hashedPassword=hashedPassword;
        return password;
    }
    Password() {
    }

    Password(String password) {
        hashPassword(password);
    }

    void hashPassword(String password) {
        hashedPassword = DigestUtils.sha256Hex(password);
    }
    String getHashedPassword(){
        return hashedPassword;
    }
    boolean verifyPassword(String password) {
        return hashedPassword.equals(DigestUtils.sha256Hex(password));
    }

}
