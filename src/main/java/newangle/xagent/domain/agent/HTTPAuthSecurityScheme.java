package newangle.xagent.domain.agent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HTTPAuthSecurityScheme extends SecurityScheme {

    /**
     * O nome do esquema de autenticação HTTP a ser usado (ex: "basic", "bearer").
     */
    private String scheme;

    /**
     * Dica sobre o formato do bearer token (ex: "JWT").
     */
    private String bearerFormat;
}