package com.mitahcodegarage.kafkapublish.deserializers;

import com.mitahcodegarage.models.Batch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

@RunWith(MockitoJUnitRunner.class)
public class BatchDeserializerTest {
    private final String tenantId = "reebok";
    private final String pipelineId = "LKKHIOJO7689HIO";
    private final String sourceId = "1";
    private final String requestId = "REQ_1";
    private final String batchId = "JKBUI787u9NJK8ou";
    private final String dataLine1 = "FirstName|LastName|Gender";
    private final String dataLine2 = "Test|Data|Male";

    BatchStringDeserializer batchDeserializer;

    @Before
    public void setup(){
        batchDeserializer = new BatchStringDeserializer();
    }

    @Test
    public void deserializeBatchOfString() {
        Batch batch = new Batch(tenantId, pipelineId, sourceId, requestId, batchId);
        batch.addData(dataLine1);
        batch.addData(dataLine2);

        Batch<String> convertedBatch = batchDeserializer.deserialize(null, convertBatchToByte(batch));

        Assert.assertNotNull(convertedBatch);
        Assert.assertEquals(batchId, convertedBatch.getBatchId());
        Assert.assertEquals(dataLine1, convertedBatch.getData().get(0));
    }

    private byte[] convertBatchToByte(Batch batch) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(batch);
            oos.flush();
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
