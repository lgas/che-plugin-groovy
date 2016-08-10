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

import org.eclipse.che.ide.api.editor.codeassist.CodeAssistCallback;
import org.eclipse.che.ide.api.editor.codeassist.CodeAssistProcessor;
import org.eclipse.che.ide.api.editor.codeassist.CompletionProposal;
import org.eclipse.che.ide.api.editor.texteditor.TextEditor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by galaloum on 24/06/2016.
 */
public class GroovyCodeAssistProcessor implements CodeAssistProcessor {
    @Override
    public void computeCompletionProposals(TextEditor editor, int offset, CodeAssistCallback callback) {
        List<CompletionProposal> proposals = new ArrayList<>();

        proposals.addAll(Arrays.asList(
                new SimpleCompletionProposal("firstName"),
                new SimpleCompletionProposal("lastName"),
                new SimpleCompletionProposal("age")
        ));

        callback.proposalComputed(proposals);
    }

    @Override
    public String getErrorMessage() {
        return "No proposal were find !";
    }
}
