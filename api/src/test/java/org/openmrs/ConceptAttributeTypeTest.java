/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.openmrs.api.context.Context;
import org.openmrs.test.jupiter.BaseContextSensitiveTest;

public class ConceptAttributeTypeTest extends BaseContextSensitiveTest {

    @Test
    public void shouldSaveAndFetchConceptAttributeType() {
        ConceptAttributeType type = new ConceptAttributeType();
        type.setName("JPA Test Type");
        type.setDatatypeClassname("org.openmrs.customdatatype.datatype.FreeTextDatatype");
        type.setMinOccurs(0);
        type.setMaxOccurs(1);

        Context.getConceptService().saveConceptAttributeType(type);

        ConceptAttributeType fetched = Context.getConceptService().getConceptAttributeType(type.getId());
        assertNotNull(fetched);
        assertEquals("JPA Test Type", fetched.getName());
    }
}