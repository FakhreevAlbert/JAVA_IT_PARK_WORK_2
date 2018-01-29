package ru.itpark.component;

import ru.itpark.domain.Keyword;

import java.util.function.Consumer;

public interface KeywordProvider {
    void forEach(Consumer<? super Keyword> consumer);
}
