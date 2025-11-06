package newangle.xagent.domain.agent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OpenIdConnectSecurityScheme extends SecurityScheme {

    /**
     * URL para descoberta dos metadados do provedor OpenID Connect.
     */
    private String openIdConnectUrl;
}