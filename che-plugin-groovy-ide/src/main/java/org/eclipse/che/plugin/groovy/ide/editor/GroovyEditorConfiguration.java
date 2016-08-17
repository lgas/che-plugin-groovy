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

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import org.eclipse.che.ide.api.editor.codeassist.CodeAssistProcessor;
import org.eclipse.che.ide.api.editor.editorconfig.AutoSaveTextEditorConfiguration;
import org.eclipse.che.ide.api.editor.partition.DocumentPartitioner;
import org.eclipse.che.ide.api.editor.texteditor.TextEditor;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by galaloum on 24/06/2016.
 */
public class GroovyEditorConfiguration extends AutoSaveTextEditorConfiguration{
    private Map<String, CodeAssistProcessor> codeAssist;

    @AssistedInject
    public GroovyEditorConfiguration(@Assisted final TextEditor editor//, final GroovyCodeAssistProcessorFactory codeAssistProcessorFactory
    ) {
        codeAssist = new LinkedHashMap<>();
//        GroovyCodeAssistProcessor codeAssistProcessor = codeAssistProcessorFactory.create(editor);
//        codeAssist.put(DocumentPartitioner.DEFAULT_CONTENT_TYPE, codeAssistProcessor);
        codeAssist.put(DocumentPartitioner.DEFAULT_CONTENT_TYPE, new GroovyCodeAssistProcessor());
    }

    @Override
    public Map<String, CodeAssistProcessor> getContentAssistantProcessors() {
        return codeAssist;
    }
}
