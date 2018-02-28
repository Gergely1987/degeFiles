package security;

import base.Validator;

public class JsInjectionValidator implements Validator{

    @Override
    public boolean isValid(String username) {
        return (username==null || username.contains("<Script>"))? false:true;
    }
}
