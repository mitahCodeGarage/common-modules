package com.mitahcodegarage.models.utilities;

import com.mitahcodegarage.models.Tenant;
import com.mitahcodegarage.models.datadefinition.DataDefinition;
import com.mitahcodegarage.models.exceptions.DataDefinitionNotFoundException;
import com.mitahcodegarage.models.exceptions.GenericTenantException;
import com.mitahcodegarage.models.exceptions.ObjectIsNullException;
import com.mitahcodegarage.models.exceptions.TenantNotFoundException;

import java.util.Optional;

public class ModelUtils {

    public static Tenant checkNullForTenant(Tenant tenant) {
        return Optional.ofNullable(tenant).orElseThrow(() -> new TenantNotFoundException(""));
    }

    public static Tenant checkNullForTenant(Optional<Tenant> tenant) {
        return tenant.orElseThrow(() -> new TenantNotFoundException("Database returned a NULL value for the tenant"));
    }

    public static Long convertIdFromStringToLong(String id) throws GenericTenantException{
        Long longId;
        try {
            longId = Long.parseLong(id.trim());
        } catch(NumberFormatException nfe) {
            throw new GenericTenantException("Unable to convert tenantId to long");
        }
        return longId;
    }

    public static DataDefinition checkNullForDataDefinition(Optional<DataDefinition> dataDefinition) {
        return dataDefinition.orElseThrow(() -> new DataDefinitionNotFoundException("Database returned a NULL value for the Data Definition"));
    }

    public static Object checkNullForObject(Object object) {
        if(null == object) {
            throw new ObjectIsNullException();
        }
        return object;
    }
}
