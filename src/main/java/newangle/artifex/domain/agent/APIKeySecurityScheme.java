package newangle.artifex.domain.agent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class APIKeySecurityScheme extends SecurityScheme {

    /**
     * O nome do header, query ou cookie a ser usado.
     */
    private String name;

    /**
     * A localização da chave de API.
     */
    private InType in;

    /**
     * Enum para os locais válidos da chave de API.
     */
    public enum InType {
        @JsonProperty("query")
        QUERY,
        @JsonProperty("header")
        HEADER,
        @JsonProperty("cookie")
        COOKIE
    }
}