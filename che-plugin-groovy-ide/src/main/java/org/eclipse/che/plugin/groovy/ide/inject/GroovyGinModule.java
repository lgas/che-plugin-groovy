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
package org.eclipse.che.plugin.groovy.ide.inject;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.assistedinject.GinFactoryModuleBuilder;
import com.google.gwt.inject.client.multibindings.GinMultibinder;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import org.eclipse.che.ide.api.extension.ExtensionGinModule;
import org.eclipse.che.ide.api.filetypes.FileType;
import org.eclipse.che.ide.api.project.type.wizard.ProjectWizardRegistrar;
import org.eclipse.che.plugin.groovy.ide.Resources;
import org.eclipse.che.plugin.groovy.ide.editor.GroovyCodeAssistProcessorFactory;
import org.eclipse.che.plugin.groovy.ide.editor.GroovyEditorConfigurationFactory;
import org.eclipse.che.plugin.groovy.ide.project.GroovyProjectWizardRegistrar;


/**
 * Created by galaloum on 24/06/2016.
 */
@ExtensionGinModule
public class GroovyGinModule extends AbstractGinModule {
    @Override
    protected void configure() {
        GinMultibinder.newSetBinder(binder(), ProjectWizardRegistrar.class).addBinding().to(GroovyProjectWizardRegistrar.class);

        install(new GinFactoryModuleBuilder().build(GroovyCodeAssistProcessorFactory.class));
        install(new GinFactoryModuleBuilder().build(GroovyEditorConfigurationFactory.class));
    }

    @Provides
    @Singleton
    @Named("GroovyFileType")
    protected FileType provideGroovyFileType() {
        return new FileType(Resources.INSTANCE.icon(), "groovy");
    }
}
