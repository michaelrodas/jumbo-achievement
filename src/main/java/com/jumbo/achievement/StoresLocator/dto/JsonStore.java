package com.jumbo.achievement.StoresLocator.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JsonStore {
    @JsonIgnore
    private Attributes attributes;
    private List<Store> stores;

    @NoArgsConstructor
    private static class Attributes {
    }
}
