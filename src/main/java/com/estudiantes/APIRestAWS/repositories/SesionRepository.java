package com.estudiantes.APIRestAWS.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.estudiantes.APIRestAWS.entity.Sesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SesionRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Sesion save(Sesion sesion){
        dynamoDBMapper.save(sesion);
        return sesion;
    }

    public Sesion getSessionBySessionString(String sessionString){
        Sesion sesion = null;
        Map<String, AttributeValue> eav= new HashMap<String ,AttributeValue>();
        eav.put(":sessionString", new AttributeValue().withS(sessionString));

        DynamoDBScanExpression scanExpression=new DynamoDBScanExpression()
                .withFilterExpression("sessionString = :sessionString")
                .withExpressionAttributeValues(eav);
        List<Sesion> useResult = dynamoDBMapper.scan(Sesion.class, scanExpression);
        if(!useResult.isEmpty() && useResult.size()>0) {
            sesion=useResult.get(0);
        }
        return sesion;
    }
}
