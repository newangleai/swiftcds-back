package newangle.artifex.domain.agent;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import newangle.artifex.domain.user.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ai_agents")
public class AiAgent {

    // === A2A COMPLIANCE ===

    /** The version of the A2A protocol this agent supports. */
    private String protocolVersion;

    /** A human-readable name for the agent. */
    private String name;

    /** A human-readable description of the agent. */
    private String description;

    /** The preferred endpoint URL for interacting with the agent. */
    private String url;

    /** * The transport protocol for the preferred endpoint. 
     * Renomeado de 'transportProtocol' e tipo mudado para String para suportar 'TransportProtocol | string'.
     */
    private String preferredTransport;

    /** * A list of additional supported interfaces.
     * Alterado de 'AgentInterface' singular para 'List<AgentInterface>'.
     */
    @JdbcTypeCode(SqlTypes.JSON)
    private List<AgentInterface> additionalInterfaces;

    /** An optional URL to an icon for the agent. */
    private String iconUrl;

    /** * Information about the agent's service provider. 
     * Assumindo que será armazenado como JSON.
     */
    @JdbcTypeCode(SqlTypes.JSON)
    private Object provider;

    /** The agent's own version number. */
    private String version;

    /** An optional URL to the agent's documentation. */
    private String documentationUrl;

    /** * A declaration of optional capabilities supported by the agent.
     * Renomeado de 'agentCapabilities'. Assumindo que será armazenado como JSON.
     */
    @JdbcTypeCode(SqlTypes.JSON)
    private AgentCapabilities capabilities;

    /** * A declaration of the security schemes available.
     * Descomentado e tipo definido como JSON.
     */
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, SecurityScheme> securitySchemes;

    /** * A list of security requirement objects.
     * Tipo definido como JSON.
     */
    @JdbcTypeCode(SqlTypes.JSON)
    private List<Map<String, List<String>>> security;

    /** * Default set of supported input MIME types.
     * Alterado de String[] para List<String> e tipo definido como JSON.
     */
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> defaultInputModes;

    /** * Default set of supported output MIME types.
     * Alterado de String[] para List<String> e tipo definido como JSON.
     */
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> defaultOutputModes;

    /** * The set of skills that the agent can perform.
     * Alterado de 'AgentSkill' singular para 'List<AgentSkill>'.
     */
    @JdbcTypeCode(SqlTypes.JSON)
    private List<AgentSkill> skills;

    /** If true, the agent can provide an extended agent card to authenticated users. */
    private Boolean supportsAuthenticatedExtendedCard;

    /** * JSON Web Signatures computed for this AgentCard.
     * Alterado de 'AgentCardSignature' singular para 'List<AgentCardSignature>'.
     */
    @JdbcTypeCode(SqlTypes.JSON)
    private List<AgentCardSignature> signatures;
    
    // =======================


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private Instant createdAt;
    
    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @PrePersist
    private void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = Instant.now();
        }
    }
    
}