package edu.stanford.bmir.protege.web.shared.projectsettings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gwt.user.client.rpc.IsSerializable;
import edu.stanford.bmir.protege.web.shared.project.ProjectId;
import edu.stanford.bmir.protege.web.shared.shortform.DictionaryLanguageData;

import javax.annotation.Nonnull;
import java.io.Serializable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 09/07/2012
 */
@AutoValue
@GwtCompatible(serializable = true)
public abstract class ProjectSettings implements Serializable, IsSerializable {

    private static final String PROJECT_ID = "projectId";

    private static final String DISPLAY_NAME = "displayName";

    private static final String DESCRIPTION = "description";

    private static final String DEFAULT_LANGUAGE = "defaultLanguage";

    private static final String SLACK_INTEGRATION_SETTINGS = "slackIntegrationSettings";

    private static final String WEBHOOK_SETTINGS = "webhookSettings";

    /**
     * Gets the projectId.
     * @return The projectId.  Not {@code null}.
     */
    @JsonProperty(PROJECT_ID)
    @Nonnull
    public abstract ProjectId getProjectId();

    /**
     * Gets the project display name.
     * @return The project display name.  Not {@code null}.
     */
    @Nonnull
    @JsonProperty(DISPLAY_NAME)
    public abstract String getProjectDisplayName();

    /**
     * Gets the project description.
     * @return The project description as a string.  May be empty. Not {@code null}.
     */
    @Nonnull
    @JsonProperty(DESCRIPTION)
    public abstract String getProjectDescription();

    @Nonnull
    @JsonProperty(DEFAULT_LANGUAGE)
    public abstract DictionaryLanguageData getDefaultLanguage();

    @Nonnull
    @JsonProperty(SLACK_INTEGRATION_SETTINGS)
    public abstract SlackIntegrationSettings getSlackIntegrationSettings();

    @Nonnull
    @JsonProperty(WEBHOOK_SETTINGS)
    public abstract WebhookSettings getWebhookSettings();

    @Nonnull
    @JsonCreator
    public static ProjectSettings get(@Nonnull @JsonProperty(PROJECT_ID) ProjectId projectId,
                                      @Nonnull @JsonProperty(DISPLAY_NAME) String displayName,
                                      @Nonnull @JsonProperty(DESCRIPTION) String description,
                                      @Nonnull @JsonProperty(DEFAULT_LANGUAGE) DictionaryLanguageData defaultLanguage,
                                      @Nonnull @JsonProperty(SLACK_INTEGRATION_SETTINGS) SlackIntegrationSettings slackIntegrationSettings,
                                      @Nonnull @JsonProperty(WEBHOOK_SETTINGS) WebhookSettings webhookSettings) {
        return new AutoValue_ProjectSettings(projectId,
                                             displayName,
                                             description,
                                             defaultLanguage,
                                             slackIntegrationSettings,
                                             webhookSettings);
    }
}
