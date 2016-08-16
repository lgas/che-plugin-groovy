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
package org.eclipse.che.plugin.groovy.ide.editor;

import com.google.inject.Inject;
import org.eclipse.che.ide.api.editor.EditorPartPresenter;
import org.eclipse.che.ide.api.editor.EditorProvider;
import org.eclipse.che.ide.api.editor.defaulteditor.AbstractTextEditorProvider;
import org.eclipse.che.ide.api.editor.editorconfig.TextEditorConfiguration;
import org.eclipse.che.ide.api.editor.texteditor.TextEditor;

/**
 * Created by galaloum on 24/06/2016.
 */
public class GroovyEditorProvider extends AbstractTextEditorProvider {

    private final GroovyEditorConfigurationFactory editorConfigurationFactory;

    @Inject
    public GroovyEditorProvider(final GroovyEditorConfigurationFactory editorConfigurationFactory) {
        this.editorConfigurationFactory = editorConfigurationFactory;
    }

    @Override
    public String getId() {
        return "GROOVY_EDITOR";
    }

    @Override
    public String getDescription() {
        return "Groovy Editor";
    }

    @Override
    protected TextEditorConfiguration getEditorConfiguration() {
        return editorConfigurationFactory.create(this.getEditor());

    }
}
