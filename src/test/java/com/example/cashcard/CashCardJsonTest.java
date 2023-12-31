package com.example.cashcard;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class CashCardJsonTest {

    @Autowired
    private JacksonTester<CashCard> json;

    @Test
    public void testSerialize() throws IOException {
        CashCard cashCard = new CashCard(99L, 123.45);
        assertThat(json.write(cashCard)).isStrictlyEqualToJson("expected.json");
        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.id")
                .isEqualTo(99);
        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");
        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount")
                .isEqualTo(123.45);
    }

    @Test
    public void cashCardDeserilizationTest() throws IOException {
        String content = "{\"id\":99,\"amount\":123.45}";
        assertThat(json.parse(content)).isEqualTo(new CashCard(99L, 123.45));
        assertThat(json.parseObject(content).id()).isEqualTo(99L);
        assertThat(json.parseObject(content).amount()).isEqualTo(123.45);
    }

}
//    @Autowired
//    private JacksonTester<CashCard> json;
//
//    @Test
//    public void myFirstTest() {
//        CashCard cashCard = new CashCard(99L, 123.45);
//
//        assertThat(json.write(cashCard)).isStrictlyEqualToJson("expected.json");
//        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");
//        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.id").isEqualTo(99);
//        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");
//        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount").isEqualTo(123.45);
//    }
