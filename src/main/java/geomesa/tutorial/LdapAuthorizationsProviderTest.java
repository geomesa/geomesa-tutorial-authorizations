package geomesa.tutorial;

import org.apache.accumulo.core.security.Authorizations;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;

/**
 * Integration test for connecting to LDAP for authorizations
 */
public class LdapAuthorizationsProviderTest {

    public static void main(String[] args) {
        // create the provider and initialize it with the 'configure' method
        LdapAuthorizationsProvider provider = new LdapAuthorizationsProvider();
        provider.configure(new HashMap<String, Serializable>());

        // set dummy authentication token corresponding to user 'rod'
        SecurityContextHolder.getContext().setAuthentication(new TestingAuthenticationToken("rod", null));

        // get the authorizations - this will connect to ldap using the values in geomesa-ldap.properties
        Authorizations auths = provider.getAuthorizations();

        System.out.println("Retrieved auths from LDAP: " + auths);
    }
}
