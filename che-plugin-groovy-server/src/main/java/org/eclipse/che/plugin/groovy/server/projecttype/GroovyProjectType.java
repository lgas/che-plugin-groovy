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
package org.eclipse.che.plugin.groovy.server.projecttype;

import com.google.inject.Inject;
import org.eclipse.che.api.project.server.type.ProjectTypeDef;

import static org.eclipse.che.plugin.groovy.shared.Constants.GROOVY_PROJECT_TYPE_ID;
import static org.eclipse.che.plugin.groovy.shared.Constants.LANGUAGE;

/**
 * Created by gael on 04/08/16.
 */
public class GroovyProjectType extends ProjectTypeDef {
    @Inject
    public GroovyProjectType() {
        super(GROOVY_PROJECT_TYPE_ID, "GROOVY", true, true);
        addConstantDefinition(LANGUAGE, LANGUAGE, GROOVY_PROJECT_TYPE_ID);
    }
}
