package com.devaj.kafka.consumer.model;

import lombok.*;

/**
 * Created by antonio on 27/04/2020.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String name;
    private int age;
}
