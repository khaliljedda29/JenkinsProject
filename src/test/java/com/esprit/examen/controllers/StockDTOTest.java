/*package com.esprit.examen.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.ParseException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@RunWith(SpringRunner.class)
public class StockDTOTest {

    @Autowired
    private JacksonTester< StockDTO > json;

    private static final String LIBELLE_STOCK = "test libelle";
    private static final Integer QTE = 10;
    private static final Integer QTE_MIN = 1;


    private static final String JSON_TO_DESERIALIZE =
            "{\"libelleStock\":\"" +
                    LIBELLE_STOCK +
                    "\",\"qte\":\"" +
                    QTE +
                    "\",\"qteMin\":\"" +
                    QTE_MIN +
                    "}";

    private StockDTO stockDTO;

    @Before
    public void setup() throws ParseException, IOException {
        stockDTO = new StockDTO(LIBELLE_STOCK, QTE, QTE_MIN);
    }

    @Test
        public void libelleStockSerializes() throws IOException {
            assertThat(this.json.write(stockDTO))
                    .extractingJsonPathStringValue("@.libelleStock")
                    .isEqualTo(LIBELLE_STOCK);
        }
    }

*/
