package newangle.xagent.domain.agent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OAuth2SecurityScheme extends SecurityScheme {

    /**
     * Objeto contendo informações de configuração para os tipos de fluxo suportados.
     */
    private OAuthFlows flows;
}