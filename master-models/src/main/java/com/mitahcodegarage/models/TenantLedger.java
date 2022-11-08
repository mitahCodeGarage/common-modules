package com.mitahcodegarage.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TenantLedger extends Tenant {
    private long createdOn;
}
