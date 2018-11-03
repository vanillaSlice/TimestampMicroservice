package lowe.mike.timestampapp;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 * {@link TimestampApplication} tests.
 *
 * @author Mike Lowe
 */
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
@ContextConfiguration
@ExtendWith(SpringExtension.class)
public class TimestampApplicationTests {

  @Autowired
  private MockMvc mvc;

  @Test
  public void convert_returnsTimestampResponse() throws Exception {
    mvc.perform(get("/convert/1450137600"))
        .andExpect(status().isOk())
        .andExpect(content().json("{\"unix\":1450137600,\"natural\": \"December 15, 2015\"}"));
  }

}
