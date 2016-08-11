/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.plugin.groovy.ide;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.eclipse.che.ide.api.editor.EditorRegistry;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.ide.api.filetypes.FileType;
import org.eclipse.che.ide.editor.orion.client.OrionContentTypeRegistrant;
import org.eclipse.che.ide.editor.orion.client.jso.OrionContentTypeOverlay;
import org.eclipse.che.ide.editor.orion.client.jso.OrionHighlightingConfigurationOverlay;
import org.eclipse.che.plugin.groovy.ide.editor.GroovyEditorProvider;

/**
 * Created by galaloum on 24/06/2016.
 */
@Extension(title = "Groovy Editor")
public class GroovyJSEditorExtension {

    @Inject
    public GroovyJSEditorExtension(final EditorRegistry eRegistry,
                                   @Named("GroovyFileType") final FileType fType,
                                   final GroovyEditorProvider groovyEditorProvider) {

        eRegistry.registerDefaultEditor(fType, groovyEditorProvider);
    }

    @Inject
    protected void configureContentType(final OrionContentTypeRegistrant contentTypeRegistrant) {
        // register content type and configure orion
        final String contentTypeId = "text/x-groovy";

        OrionContentTypeOverlay contentType = OrionContentTypeOverlay.create();
        contentType.setId(contentTypeId);
        contentType.setName("Groovy Language");
        contentType.setExtension("groovy");
        contentType.setExtends("text/plain");

        // highlighting
        OrionHighlightingConfigurationOverlay config = OrionHighlightingConfigurationOverlay.create();
        config.setId("orion.groovy");
        config.setContentTypes(contentTypeId);
        config.setPatterns(
                "[\n" +
                        "  {include: \"orion.java\"},\n" +
                        "  {\n" +
                        "    match: \"\\\\b(?:it|delegate|owner|as|in|def|threadsafe|assert|use|with)\\\\b\",\n" +
                        "    name: \"keyword.groovy\"\n" +
                        "  }\n" +
                        "]");

        contentTypeRegistrant.registerFileType(contentType, config);
    }
}
