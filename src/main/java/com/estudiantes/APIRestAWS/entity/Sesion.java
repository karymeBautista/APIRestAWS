package com.estudiantes.APIRestAWS.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "sesiones-alumnos")
public class Sesion {
    @DynamoDBHashKey
    private String id;

    @DynamoDBAttribute
    private Long fecha; //unix time Stamp

    @DynamoDBAttribute
    private int alumnoId;

    @DynamoDBAttribute
    private Boolean active;

    @DynamoDBAttribute
    private String sessionString; //string alfanumerico de 128 caracteres

}
