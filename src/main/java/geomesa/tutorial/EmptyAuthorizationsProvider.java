package geomesa.tutorial;

import geomesa.core.security.AuthorizationsProvider;
import org.apache.accumulo.core.security.Authorizations;

import java.io.Serializable;
import java.util.Map;

/**
 * Implementation of auth provider that always returns empty auths
 */
public class EmptyAuthorizationsProvider
        implements AuthorizationsProvider {

    @Override
    public Authorizations getAuthorizations() {
        return new Authorizations();
    }

    @Override
    public void configure(Map<String, Serializable> params) {

    }
}
