package com.jumbo.achievement.storeslocator.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class JsonStore {
    @JsonIgnore
    private Attributes attributes;
    private List<Store> stores;

    private static class Attributes {
    }
}
