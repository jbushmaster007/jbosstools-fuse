/*******************************************************************************
 * Copyright (c) 2018 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.fusesource.ide.projecttemplates.impl.simple;

import org.fusesource.ide.camel.model.service.core.util.FuseBomFilter;
import org.fusesource.ide.foundation.core.util.VersionUtil;
import org.fusesource.ide.projecttemplates.adopters.configurators.TemplateConfiguratorSupport;
import org.fusesource.ide.projecttemplates.adopters.creators.TemplateCreatorSupport;
import org.fusesource.ide.projecttemplates.util.CommonNewProjectMetaData;

public class OSESpringBootXMLTemplateForFuse7 extends AbstractOSESpringBootXMLTemplate {
	
	protected static final String PLACEHOLDER_FABRIC8MAVENPLUGIN_VERSION = "%%%PLACEHOLDER_FABRIC8MAVENPLUGIN_VERSION%%%";
	private static final String MINIMAL_COMPATIBLE_CAMEL_VERSION = "2.20.0";

	@Override
	public TemplateConfiguratorSupport getConfigurator() {
		String bomVersion = getArtifactLastVersion(FuseBomFilter.BOM_FUSE_FIS.getGroupId(), FuseBomFilter.BOM_FUSE_FIS.getArtifactId());
		return new MavenConfiguratorForOSESpringBootTemplate(bomVersion);
	}

	@Override
	public TemplateCreatorSupport getCreator(CommonNewProjectMetaData projectMetaData) {
		return new OSEUnzipTemplateCreator("7");
	}

	@Override
	public boolean isCompatible(String camelVersion) {
		return new VersionUtil().isGreaterThan(camelVersion, MINIMAL_COMPATIBLE_CAMEL_VERSION);
	}
}
