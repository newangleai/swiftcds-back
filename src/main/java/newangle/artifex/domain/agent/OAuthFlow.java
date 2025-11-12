package newangle.artifex.domain.agent;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Define um único fluxo de OAuth 2.0.
 */
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAuthFlow {

    /**
     * A URL de autorização para este fluxo.
     */
    private String authorizationUrl;

    /**
     * A URL do endpoint de token para este fluxo.
     */
    private String tokenUrl;

    /**
     * A URL do endpoint de refresh token para este fluxo.
     */
    private String refreshUrl;

    /**
     * Os escopos disponíveis para este fluxo.
     * A chave é o nome do escopo, e o valor é a descrição.
     */
    private Map<String, String> scopes;
}