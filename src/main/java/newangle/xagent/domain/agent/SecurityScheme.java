package newangle.xagent.domain.agent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * Define um esquema de segurança (polimórfico) baseado na especificação OpenAPI 3.0.
 * Usa @JsonTypeInfo para desserializar para a subclasse correta com base no campo 'type'.
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type",
    visible = true
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = APIKeySecurityScheme.class, name = "apiKey"),
    @JsonSubTypes.Type(value = HTTPAuthSecurityScheme.class, name = "http"),
    @JsonSubTypes.Type(value = MutualTLSSecurityScheme.class, name = "mutualTLS"),
    @JsonSubTypes.Type(value = OAuth2SecurityScheme.class, name = "oauth2"),
    @JsonSubTypes.Type(value = OpenIdConnectSecurityScheme.class, name = "openIdConnect")
})
@JsonInclude(JsonInclude.Include.NON_NULL) // Não incluir campos nulos no JSON
public abstract class SecurityScheme {

    /**
     * O tipo do esquema de segurança. Valores válidos: "apiKey", "http", 
     * "mutualTLS", "oauth2", "openIdConnect".
     */
    private String type;

    /**
     * Uma descrição para o esquema de segurança.
     */
    private String description;
}