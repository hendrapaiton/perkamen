package com.lastare.perkamen.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LandingController.class)
public class LandingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @SuppressWarnings("null")
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("pageTitle", "Beranda"))
                // Verify Title from head fragment
                .andExpect(content().string(containsString("<title>Beranda - Perkamen</title>")))
                // Verify Navbar fragment content
                .andExpect(content().string(containsString("Perkamen")))
                .andExpect(content().string(containsString("Mulai Sekarang")))
                // Verify Hero section content
                .andExpect(content().string(containsString("Transformasi Digital")))
                // Verify Features section content
                .andExpect(content().string(containsString("Fitur Unggulan")))
                // Verify Footer fragment content
                .andExpect(content().string(containsString("Sistem Informasi Surat Menyurat Digital")));
    }
}
